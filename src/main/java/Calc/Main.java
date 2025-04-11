package Calc;


import java.util.Scanner;
import lombok.Getter;
import lombok.Setter;


public class Main {


    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();

        System.out.println("Калькулятор запущен. Введите выражение (например: 3+7 или 3 + 7).");
        System.out.println("Введите exit для выхода.");

        while (true) {
            System.out.print("\nВведите выражение: ");
            String userInput = consoleReader.readLine();

            if ("exit".equalsIgnoreCase(userInput.trim())) {
                System.out.println("Программа завершена.");
                break;
            }

            try {
                String result = calc(userInput);
                System.out.println("Результат: " + result);
            } catch (CalculatorException e) {

                System.out.println("Ошибка (CalculatorException): " + e.getMessage());
            } catch (Exception e) {

                System.out.println("Непредвиденная ошибка: " + e.getMessage());
            }
        }
    }
    public static String calc(String input) {
        Calculator calculator = new Calculator();
        calculator.setExpression(input);
        return calculator.performCalculation();
    }
}
