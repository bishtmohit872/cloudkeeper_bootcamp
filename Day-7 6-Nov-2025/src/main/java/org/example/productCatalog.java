package org.example;

class InvalidPriceException extends Exception {
    public InvalidPriceException(String message) {
//        System.out.println("price Excepton invoked "+ message);
        super(message);
    }
}

class Product {
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) throws InvalidPriceException {
        if (price < 0) {
            throw new InvalidPriceException("Price cannot be negative!");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Price: " + price);
    }
}

public class productCatalog {
    public static void main(String[] args) {
        try {
            Product p1 = new Product(1, "Phone", 50000);
            Product p2 = new Product(2, "Laptop", 85000);
            Product p3 = new Product(3, "Earbuds", -2000); // Will throw exception

            p1.display();
            p2.display();
            p3.display();
        } catch (InvalidPriceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
