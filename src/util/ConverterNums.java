package util;

import exception.CalculatorException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Fulkin
 * Created on 09.12.2021
 */

public class ConverterNums {

    private ConverterNums(){
    }

    public static String intToRoman(int num) {
        int[] values = {100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLiterals = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                num -= values[i];
                roman.append(romanLiterals[i]);
            }
        }
        return roman.toString();
    }

    public static int romanToInt(String s) throws CalculatorException {
        int[] nums = new int[s.length()];
        for(int i = 0; i < s.length(); i++){
            switch (s.charAt(i)) {
                case 'X' :
                    nums[i] = 10;
                    if (s.length() > 1) {
                        throw new CalculatorException("Exit the value of a number from the range");
                    }
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'I':
                    nums[i] = 1;
                    break;
                default:
                    throw new CalculatorException("Incorrect data entry or exit the value of a number from the range");
            }
        }
        int sum = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] < nums[i+1])
                sum -= nums[i];
            else
                sum += nums[i];
        }
        return sum + nums[nums.length-1];
    }
}
