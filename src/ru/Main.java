package ru;

import ru.services.Calculator;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        System.out.println(calc(input));
//        calculator.calculate("1 - 2 "); // нет в задании
//        calculator.calculate("1 + 2");
//        calculator.calculate(" X * X");
//        calculator.calculate("VI / III");
//        calculator.calculate("IX - II");
//        calculator.calculate("I - II"); // throws Exception //т.к. в римской системе нет отрицательных чисел
        //       calculator.calculate("I + 1"); // throws Exception //т.к. используются одновременно разные системы счисления
//        calculator.calculate("1"); // throws Exception //т.к. строка не является математической операцией
        //       calculator.calculate("1 + 2 + 3"); // throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)

        //       while (true){
        //         calculator.calculate(sc.nextLine());
        //     }
    }
    public static String calc(String input){
        Calculator calculator = new Calculator();
        return calculator.calculate(input);
    }
}
