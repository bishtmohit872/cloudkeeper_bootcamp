package org.example;
//simple calculator
class Calculator{
//    Calculator(){
//        System.out.println("Calculator Class here");
//    }

    public int add(int a,int b){
        return a+b;
    }

    public int sub(int a,int b){
        return Math.max(a,b)  - Math.min(a,b);
    }

    public int mul(int a,int b){
        return a*b;
    }

    public  int div(int a,int b){
        return Math.max(a,b)/Math.min(a,b);
    }
}

public class Main {
    //sum of digit
    public static int sum(int num){
        int value=num;
        int sum=0;
        while(value>0){
            sum=sum+value%10;
            value=value/10;
        }
        return sum;
    }
    //multiplication
    public static void multiplication(int num){
        for(int i=1;i<=10;i++){
            System.out.println(num + "x" + i + "=" + num*i);
        }
    }
    //factorial
    public static int factorial(int num){
        int fact=1;
        for(int i=num;i>=1;i--){
            fact=fact*i;
        }
        return fact;
    }

    //revers a number
    public static String Reverse(int num){
        int value=num;
        String reverse_num="";

        while(value>=1){
            reverse_num=reverse_num+(value%10);
            value=value/10;
        }
        return reverse_num;
    }



    public static void main(String[] args) {
        var result = sum(1234);
        System.out.println("total sum:"+result);

        multiplication(4);

        System.out.println("Factorial of given number:" + factorial( 5));

        System.out.println("Reverse of given number :" + Reverse(1234));

        Calculator cal = new Calculator();
        int totalSum = cal.add(2,3);
        int totalSub = cal.sub(4,6);
        int totalmul = cal.mul(2,3);
        int totaldiv = cal.div(3,5);
        System.out.println("calculator result: sum, sub ,mul, div respectivelu"+(totalSum)+","+(totalSub)+(totalmul)+(totaldiv));

        //Student Report
        StudentReport rep = new StudentReport("mohit",23,45,67);
        System.out.println("total marks:"+rep.totalMarks()+" total average:"+rep.average());

        //Bank Account
        BankAccount bankAccount = new BankAccount(2342432,"mohit",3453);
        bankAccount.getdata();

        //object counter
        ObjectCounter objectCounter1 = new ObjectCounter();
        ObjectCounter objectCounter2 = new ObjectCounter();
        ObjectCounter objectCounter3 = new ObjectCounter();
        ObjectCounter objectCounter4 = new ObjectCounter();
        System.out.println("total object :" + ObjectCounter.getCount());

        //MathUtils
        MathUtils mathUtils = new MathUtils();
        System.out.println("maximum: "+mathUtils.max(3,4));
        System.out.println("minimum: "+mathUtils.min(3,5));
        System.out.println("Average: "+mathUtils.average(3,6));

        //Book
        Book book = new Book("journey","mohit",345);
        book.showData();

        //Car
        Car car = new Car("toyota");
        car.showData();
        Car car1 = new Car("toyota",456);
        car1.showData();

        //division Exception

        DivisonException divisonException = new DivisonException();
        divisonException.divide(2,0);

        //nested try - catch in a seprate file NestedTryCatch



    }
}