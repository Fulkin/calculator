import exception.CalculatorException;
import util.Calculator;
import util.ConverterNums;
import util.Numeric;
import util.TypeNumber;

/**
 * @author Fulkin
 * Created on 09.12.2021
 */

public class Qualifier {

    public static String evaluate(String expression) throws CalculatorException {
        String[] array = expression.split(" ");
        if (array.length != 3) {
            throw new CalculatorException("Wrong number of values in a line");
        }
        Numeric a = defineNum(array[0]);
        Numeric b = defineNum(array[2]);

        if (a.getType() != b.getType()) {
            throw new CalculatorException("Using different types in a string");
        }

        Numeric result = Calculator.calculate(a,b, array[1]);

        if (result.getType() == TypeNumber.ROMAN) {
            return ConverterNums.intToRoman(result.getValue());
        } else {
            return String.valueOf(result.getValue());
        }
    }

    private static Numeric defineNum(String num) throws CalculatorException {
        try {
            int a = Integer.parseInt(num);
            if (checkRange(a)) {
                throw new CalculatorException("Exit the value of a number from the range");
            }
            return new Numeric(
                    a, TypeNumber.ARABIC
            );
        } catch (NumberFormatException e) {
            return new Numeric(
                    ConverterNums.romanToInt(num), TypeNumber.ROMAN
            );
        }
    }

    private static boolean checkRange(int a) {
        return a > 10 || a < 1;
    }

}
