package org.example;

public class NestedTryCatch {

    public static void main(String args[]) {

        try {
            int arr[] = new int[3];
            try {
                int result = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Caught ArithmeticException: " + e.getMessage());
            }

            arr[5] = 20;
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}
