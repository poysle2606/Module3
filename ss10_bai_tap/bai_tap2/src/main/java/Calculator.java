public class Calculator {
    public static float calculate(float firstOperand, float secondOperand, String operand) {
        switch (operand) {
            case "+":
                return firstOperand + secondOperand;
            case "-":
                return firstOperand - secondOperand;
            case "*":
                return firstOperand * secondOperand;
            case "/":
                if (secondOperand != 0) {
                    return firstOperand / secondOperand;
                } else {
                    throw new RuntimeException("Can't divide by zero.");
                }
            default:
                throw new RuntimeException("Invalid operation");
        }
    }
}
