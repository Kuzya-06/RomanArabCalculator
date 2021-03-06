package ru.services;

import ru.enums.RomanOrArabEnum;

public class RomanArabConverter {

    private static String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
            "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
            "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
    };

    public static RomanOrArabEnum isRomanOrArab(String str) {

        boolean isArabNumber = false;
        boolean isRomanNumber = false;

        // ???????? - ???????? ?? ? int?
        try {
            int arabValue = Integer.parseInt(str);
            isArabNumber = true;
        } catch (NumberFormatException ex) {
            isArabNumber = false;
        }

        if (isRomanNumber(str)) {
            isRomanNumber = true;
        }

        if (isArabNumber != isRomanNumber) {

            if (isArabNumber) {
                return RomanOrArabEnum.ARAB;
            }
            if (isRomanNumber) {
                return RomanOrArabEnum.ROMAN;
            }
        }

        return RomanOrArabEnum.TYPE_NOT_FOUND;
    }


    public static int convertRomanToArab(String roman) {

        if (roman.equals("I")) {
            return 1;
        } else if (roman.equals("II")) {
            return 2;
        } else if (roman.equals("III")) {
            return 3;
        } else if (roman.equals("IV")) {
            return 4;
        } else if (roman.equals("V")) {
            return 5;
        } else if (roman.equals("VI")) {
            return 6;
        } else if (roman.equals("VII")) {
            return 7;
        } else if (roman.equals("VIII")) {
            return 8;
        } else if (roman.equals("IX")) {
            return 9;
        } else if (roman.equals("X")) {
            return 10;
        }

        throw new IllegalArgumentException("?????? ????????? ???????? ????? " + roman);
    }

    public static boolean isRomanNumber(String text) {
        String str = text;
        str = str.replace("I", "");
        str = str.replace("V", "");
        str = str.replace("X", "");
        str = str.replace("L", "");
        str = str.replace("C", "");
        str = str.replace("D", "");
        str = str.replace("M", "");

        if (str.length() == 0) {
            return true;
        } else {
            // ?????? ?? ???????
            return false;
        }
    }


    public static String convertArabToRoman(int numArabian) {

        if (numArabian >= 0) {
            if(numArabian <= roman.length - 1) {
                return roman[numArabian];
            } else{
                throw new IllegalArgumentException("?? ??????? ?????? ??????? ????? ?? ?????? 100");
            }
        } else {
            throw new IllegalArgumentException("? ??????? ??????? ??? ????????????? ?????");
        }
    }
}


