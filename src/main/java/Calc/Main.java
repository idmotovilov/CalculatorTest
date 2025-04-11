package Calc;

public class Main {
    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        System.out.println("Калькулятор запущен. Введите выражение (например: 3+7).");
        System.out.println("Программа завершится после одного расчёта.");
        System.out.print("Введите выражение: ");
        String userInput = consoleReader.readLine();
        try {
            String result = calc(userInput);
            System.out.println("Результат: " + result);
            System.exit(0);
        } catch (CalculatorException e) {
            System.out.println("Ошибка (CalculatorException): " + e.getMessage());
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Непредвиденная ошибка: " + e.getMessage());
            System.exit(0);
        }
    }

    public static String calc(String input) {
        Calculator calculator = new Calculator();
        calculator.setExpression(input);
        return calculator.performCalculation();
    }
}
