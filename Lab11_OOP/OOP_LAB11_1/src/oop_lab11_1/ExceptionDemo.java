package oop_lab11_1;

public class ExceptionDemo {

    public static void main(String[] args) {
        try {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[1]);
            double c = Double.parseDouble(args[2]);

            double x = b * b - 4 * a * c;

            double x1 = (-b + Math.sqrt(x)) / (2 * a);
            double x2 = (-b - Math.sqrt(x)) / (2 * a);

            System.out.println("x1: " + x1);
            System.out.println("x2: " + x2);
        } 
        catch (NumberFormatException e) {
            if (isNull(args[0]) || isNull(args[1]) || isNull(args[2])) {
                System.out.println("Please enter 3 numbers as a, b, and c respectively.");
            } 
            else {
                System.out.println("Please input data in number format only.");
            }
         
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Please enter 3 numbers as a, b, and c respectively.");
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
