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
        try {
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

            sign = Sign.getByValue(lastSign);

            if (signCounter == 1) {
                String[] numbers = text.split("\\" + lastSign);
                firstValue = new RomanArabNumber(numbers[0]);
                secondValue = new RomanArabNumber(numbers[1]);
                if (!(firstValue.getType().equals(RomanOrArabEnum.TYPE_NOT_FOUND) ||
                        secondValue.getType().equals(RomanOrArabEnum.TYPE_NOT_FOUND))) {

                    if (firstValue.getType().equals(secondValue.getType())) {
                        romanOrArabEnum = firstValue.getType();
                    } else {
                        try {
                            throw new IllegalArgumentException();
                        } catch ( IllegalArgumentException e){
                            System.out.println("T.k. ispolzuetsya odnovremenno raznye sistemy schisleniya - т.к. используются одновременно разные системы счисления");
                        }
                        }
                } else {
                    try {
                        throw new IllegalArgumentException();
                    } catch (IllegalArgumentException e){
                        System.out.println("Ne udalos' opredelit' tip dannyh chisla - Не удалось определить тип данных числа");
                    }
                }

            } else {
                try {
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e){
                    System.out.println("T.k. stroka ne yavlyaetsya matematicheskoy operaciey. - т.к. строка не является математической операцией");
                }
            }

        } catch (IllegalArgumentException ex) {
            ex.printStackTrace();
        }

    }

}
