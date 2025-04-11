package Calc;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Calculator {
    private String expression;
    private int operandA;
    private int operandB;
    private String operator;

    public String performCalculation() {
        if (expression == null || expression.isBlank()) {
            throw new CalculatorException("Пустая строка. Формат: [число][оператор][число]");
        }
        String expr = expression.replaceAll("\\s+", "");
        String[] parts = expr.split("((?<=[+\\-*/])|(?=[+\\-*/]))");
        if (parts.length != 3) {
            throw new CalculatorException("Некорректный формат. Ожидается: [число][оператор][число]. Например: 3+7");
        }
        setOperandA(parseNumber(parts[0]));
        setOperator(parts[1]);
        setOperandB(parseNumber(parts[2]));


        if ("/".equals(operator) && operandB == 0) {
            throw new CalculatorException("Деление на ноль запрещено!");
        }


        if (operandA < 1 || operandA > 10) {
            throw new CalculatorException("Число " + operandA + " не должно быть меньше 1 или больше 10");
        }
        if (operandB < 1 || operandB > 10) {
            throw new CalculatorException("Число " + operandB + " не должно быть меньше 1 или больше 10");
        }

        int result;
        switch (operator) {
            case "+":
                result = operandA + operandB;
                break;
            case "-":
                result = operandA - operandB;
                break;
            case "*":
                result = operandA * operandB;
                break;
            case "/":
                result = operandA / operandB;
                break;
            default:
                throw new CalculatorException("Некорректная операция. Поддерживаются +, -, *, /");
        }
        return String.valueOf(result);
    }

    private int parseNumber(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new CalculatorException(
                    "Некорректное число: \"" + str + "\". Ожидаются целые числа в диапазоне 1..10"
            );
        }
    }
}
