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
//        calculator.calculate("1 - 2 "); // ��� � �������
//        calculator.calculate("1 + 2");
//        calculator.calculate(" X * X");
//        calculator.calculate("VI / III");
//        calculator.calculate("IX - II");
//        calculator.calculate("I - II"); // throws Exception //�.�. � ������� ������� ��� ������������� �����
        //       calculator.calculate("I + 1"); // throws Exception //�.�. ������������ ������������ ������ ������� ���������
//        calculator.calculate("1"); // throws Exception //�.�. ������ �� �������� �������������� ���������
        //       calculator.calculate("1 + 2 + 3"); // throws Exception //�.�. ������ �������������� �������� �� ������������� ������� - ��� �������� � ���� �������� (+, -, /, *)

        //       while (true){
        //         calculator.calculate(sc.nextLine());
        //     }
    }
    public static String calc(String input){
        Calculator calculator = new Calculator();
        return calculator.calculate(input);
    }
}
