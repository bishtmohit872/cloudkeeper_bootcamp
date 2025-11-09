package org.example;

public class Car {
    String ModelName;
//    String Model;
    float price;

    Car(String ModelName){
        this.ModelName = ModelName;
    }

    Car(String ModelName,float price){
        this.ModelName = ModelName;
        this.price = price;
    }

    public void showData(){
        System.out.println("car details are :"+this.ModelName+" "+this.price);
    }

}
