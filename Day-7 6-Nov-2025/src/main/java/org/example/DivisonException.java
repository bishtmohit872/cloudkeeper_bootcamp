package org.example;

class DivisonException {
    public void divide(int a,int b){
        try{
            System.out.println(a/b);
        }
        catch(ArithmeticException e){
            System.out.println("divide by zero");
        }
        finally {
            System.out.println("exception handelled");
        }
    }
}


