
package oop_lab11_1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ExceptionDemo demo = new ExceptionDemo();
        Scanner input = new Scanner(System.in);
        String numA = input.nextLine();
        String numB = input.nextLine();
        String numC = input.nextLine();
        demo.cal(numA, numB, numC);
        input.close();
    }
    
}
