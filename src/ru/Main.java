package ru;

import ru.services.Calculator;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        Calculator calculator = new Calculator();
        Scanner sc = new Scanner(System.in);
       calculator.calculate(sc.nextLine());
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
}
