package ru;

import ru.services.Calculator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
        System.out.println(calculator.calculate(sc.nextLine()));

  //   System.out.println(calculator.calculate("1 - 2 ")); // нет в задании
 //       System.out.println(calculator.calculate("1 + 2"));
//       System.out.println(calculator.calculate(" X * X"));
 //       System.out.println(calculator.calculate("VI / III"));
 //       System.out.println(calculator.calculate("IX - II"));
 //       System.out.println(calculator.calculate("I - II")); // throws Exception //т.к. в римской системе нет отрицательных чисел
//        System.out.println(calculator.calculate("I + 1")); // throws Exception //т.к. используются одновременно разные системы счисления
 //       System.out.println(calculator.calculate("1")); // throws Exception //т.к. строка не является математической операцией
 //       System.out.println(calculator.calculate("1 + 2 + 3")); // throws Exception //т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)

    }
}
