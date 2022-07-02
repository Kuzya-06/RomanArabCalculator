package ru.enums;

import java.util.Arrays;

public enum Sign {

    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVISION("/");

    public String signStr;

    Sign(String signStr) {
        this.signStr = signStr;
    }

    public static Sign getByValue(String value) {
        return Arrays.stream(Sign.values()).filter(enumRole -> enumRole.signStr.equals(value)).findFirst().get();
    }
}