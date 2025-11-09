package org.example;

public class Book {
    String title;
    String author;
    int price;
    Book(String title,String author,int price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void showData(){
        System.out.println("title:"+title);
        System.out.println("author:"+author);
        System.out.println("price:"+price);
    }
}
