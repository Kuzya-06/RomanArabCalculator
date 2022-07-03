package ru.dto;

import ru.enums.RomanOrArabEnum;
import ru.services.RomanArabConverter;

public class RomanArabNumber {
    private Integer intValue;
    private String strValue;
    private RomanOrArabEnum type;

    public RomanArabNumber(String str) {
        parse(str);
    }

    public RomanArabNumber(int value) {
        intValue = value;
        strValue = String.valueOf(value);
        type = RomanOrArabEnum.ARAB;
    }

    private void parse(String str) {
        type = RomanArabConverter.isRomanOrArab(str);
        switch (type) {
            case ROMAN:
                strValue = str;
                intValue = RomanArabConverter.convertRomanToArab(str);
                break;
            case ARAB:
                strValue = str;
                intValue = Integer.parseInt(str);
                break;
            case TYPE_NOT_FOUND:
                throw new IllegalArgumentException("Ошибка парсинга RomanArabNumber");
        }
    }

    public RomanOrArabEnum getType() {
        return type;
    }

    public Integer getIntValue() {
        return intValue;
    }

    public String getStrValue() {
        return strValue;
    }

    public void setType(RomanOrArabEnum type) {
        this.type = type;
    }

    @Override
    public String toString() {

        switch (type) {
            case ROMAN:
                return RomanArabConverter.convertArabToRoman(intValue);
            case ARAB:
                return intValue.toString();
            case TYPE_NOT_FOUND:
                throw new IllegalArgumentException("Ошибка типа данных");
        }

        throw new IllegalArgumentException("Ошибка в методе toString класса RomanArabNumber");
    }
}
