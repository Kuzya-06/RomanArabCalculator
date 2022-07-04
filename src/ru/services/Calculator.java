package ru.services;

import ru.dto.Expression;
import ru.dto.RomanArabNumber;
import ru.enums.RomanOrArabEnum;
import ru.enums.Sign;

import javax.sound.midi.Soundbank;

public class Calculator {

    private Expression expression;

    // public void calculate(String str) {
    public String calculate(String str) {
        String str1="";
        RomanArabNumber ravno = null;
        try {
            expression = new Expression(str);
            switch (expression.getSign()) {
                case PLUS:
                    ravno = new RomanArabNumber(expression.getFirstValue().getIntValue() + expression.getSecondValue().getIntValue());

                    break;
                case MINUS:
                    ravno = new RomanArabNumber(expression.getFirstValue().getIntValue() - expression.getSecondValue().getIntValue());

                    break;
                case MULTIPLY:
                    ravno = new RomanArabNumber(expression.getFirstValue().getIntValue() * expression.getSecondValue().getIntValue());

                    break;
                case DIVISION:
                    ravno = new RomanArabNumber(expression.getFirstValue().getIntValue() / expression.getSecondValue().getIntValue());

                    break;
            }

            ravno.setType(expression.getRomanOrArabEnum());
            //   System.out.println(ravno);

            if (ravno.getIntValue() < 1 && expression.getRomanOrArabEnum() == RomanOrArabEnum.ROMAN) {
                throw new IllegalArgumentException("Выражение для римских цифр только положительное");
            } else {
                 str1 = ravno.toString();
            }


        } catch (Exception ex) {
            //   System.out.println("Ошибка работы калькулятора");
            ex.printStackTrace();
        }
        return str1;
    }
}
