package ru.dto;

import ru.enums.RomanOrArabEnum;
import ru.enums.Sign;
import ru.services.RomanArabConverter;

import java.util.ArrayList;
import java.util.Arrays;

public class Expression {
    // первое значение
    private RomanArabNumber firstValue;
    // второе значение
    private RomanArabNumber secondValue;
    // знак
    private Sign sign;
    // арабские или римские цифры
    private RomanOrArabEnum romanOrArabEnum = RomanOrArabEnum.TYPE_NOT_FOUND;

    public Expression(String str) {
        parse(str);
    }

    public RomanArabNumber getFirstValue() {
        return firstValue;
    }

    public RomanArabNumber getSecondValue() {
        return secondValue;
    }

    public Sign getSign() {
        return sign;
    }

    public RomanOrArabEnum getRomanOrArabEnum() {
        return romanOrArabEnum;
    }

    private void parse(String str) {
        // убрали везде пробелы
        String text = str.intern().replace(" ", "");

        // формируем список на основе массива "+", "-", "/", "*"
        ArrayList<String> signList = new ArrayList<>(Arrays.asList("+", "-", "/", "*"));

        // считает количество знаков в строке
        int signCounter = 0;
        int signPosition;
        String lastSign = "";
        for (String sign : signList) {
            int index = 0;
            if (text.contains(sign)) {
                while (true) {
                    index = text.indexOf(sign, index);
                    if (index != -1) {
                        signCounter++;
                        signPosition = index;
                        lastSign = sign;
                    } else {
                        break;
                    }
                    index = index + 1;
                }
            }
        }


        if (signCounter == 1) {
            sign = Sign.getByValue(lastSign);
            String[] numbers = text.split("\\" + lastSign); // нужно экранировать символ (lastSign) с помощью двух обратных слешей
            firstValue = new RomanArabNumber(numbers[0]);
            secondValue = new RomanArabNumber(numbers[1]);

            if(firstValue.getIntValue()<1 || firstValue.getIntValue()>10 ||
                    secondValue.getIntValue()<1 || secondValue.getIntValue()>10){
                throw new IllegalArgumentException("Числа должны быть от 1 до 10");
            }

            if (!(firstValue.getType().equals(RomanOrArabEnum.TYPE_NOT_FOUND) ||
                    secondValue.getType().equals(RomanOrArabEnum.TYPE_NOT_FOUND))) {

                if (firstValue.getType().equals(secondValue.getType())) {
                    romanOrArabEnum = firstValue.getType();
                } else {
                    throw new IllegalArgumentException("Используются одновременно разные системы счисления");
                }
            } else {
                throw new IllegalArgumentException("Не удалось определить тип данных числа");
            }

        } else {
            if(signCounter==0) {
                throw new IllegalArgumentException("Cтрока не является математической операцией");
            }else{
                throw new IllegalArgumentException("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
            }
        }
    }
}
