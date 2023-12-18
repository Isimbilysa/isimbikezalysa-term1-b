package term1exam.DevopsExam;

public class MathImpl implements MathOp{
    @Override
    public double doMath(double operand1, double operand2, String operation) throws InvalidOpException {
        if ("/".equals(operation) && operand2 == 0) {
            throw new InvalidOpException("Cannot divide by 0");
        }
        switch (operation) {
            case "*":
                return operand1 * operand2;
            case "/":
                return operand1 / operand2;
            case "+":
                return operand1 + operand2;
            case "-":
                return operand1 - operand2;
            default:
                throw new RuntimeException("Unknown operation");
        }
    }
}
