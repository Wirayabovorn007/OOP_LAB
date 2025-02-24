package oop_lab11_1;

public class ExceptionDemo {

    public void cal(String numA, String numB, String numC) {
        try {
            double a = Double.parseDouble(numA);
            double b = Double.parseDouble(numB);
            double c = Double.parseDouble(numC);

            double x = b * b - 4 * a * c;

            double x1 = (-b + Math.sqrt(x)) / (2 * a);
            double x2 = (-b - Math.sqrt(x)) / (2 * a);

            System.out.println("x1: " + x1);
            System.out.println("x2: " + x2);
        } 
        catch (NumberFormatException e) {
            if (isNull(numA) || isNull(numB) || isNull(numC)) {
                System.out.println("Please enter 3 numbers as a, b, and c respectively.");
            } 
            else {
                System.out.println("Please input data in number format only.");
            }
        }
    }

    public static boolean isNull(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isNum(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

}
