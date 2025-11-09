package org.example;

public class ExceptionPropogation {
    public static void m3(){
        System.out.println("this is m3");
    }

    public static void m2(){
        System.out.println(3/0);
    }
    public static void m1(){
        try{
            m2();
        }
        catch(ArithmeticException e){
            throw new ArithmeticException("re throwing");
        }
        finally{
            System.out.println("finally executed in m1");
        }
    }
    public static void main(String args[]){
        try{
            m1();
        }
        catch(ArithmeticException e){
            System.out.println("handled by main method");
        }
        finally {
            System.out.println("ended flow");
        }
    }
}
