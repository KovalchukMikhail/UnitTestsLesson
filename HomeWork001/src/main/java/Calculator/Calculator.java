package Calculator;

public class Calculator {
    public static int calculation(int firstOperand, int secondOperand, char operator) {
        int result;

        switch (operator) {
            case '+':
                result = firstOperand + secondOperand;
                break;
            case '-':
                result = firstOperand - secondOperand;
                break;
            case '*':
                result = firstOperand * secondOperand;
                break;
            case '/':
                if (secondOperand != 0) {
                    result = firstOperand / secondOperand;
                    break;
                } else {
                    throw new ArithmeticException("Division by zero is not possible");
                }
            default:
                throw new IllegalStateException("Unexpected value operator: " + operator);
        }
        return result;
    }

    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        // purchaseAmount - сумма покупки
        // discountAmount - размер скидки
        if(discountAmount < 0 || discountAmount > 100){
            String message = "Недопустимое значение размера  скидки (" + discountAmount + "). Операция подсчета суммы покупки с учетом скидки прервана";
            throw new IllegalArgumentException(message);
        }
        if(purchaseAmount < 0){
            String message = "Недопустимое значение размера стоимости покупки (" + purchaseAmount + "). Операция подсчета суммы покупки с учетом скидки прервана";
            throw new IllegalArgumentException("");
        }

        double result = purchaseAmount - purchaseAmount * discountAmount * 0.01; // Метод должен возвращать сумму покупки со скидкой
        return result;
    }
}
