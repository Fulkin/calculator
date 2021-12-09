import exception.CalculatorException;

import java.util.Scanner;

/**
 * @author Fulkin
 * Created on 08.12.2021
 */

public class CalculatorMain {
    public static void main(String[] args) throws CalculatorException {

        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println(Qualifier.evaluate(sc.nextLine()));
        }
    }
}
