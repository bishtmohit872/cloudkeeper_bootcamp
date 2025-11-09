package org.example;

class Customer {
    int id;
    String name;
    String email;

    Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    void display() {
        System.out.println(id + " - " + name + " - " + email);
    }
}

public class POJO {
    public static void main(String[] args) {
        Customer[] customers = {
                new Customer(1, "mohit", "mohit@gmail.com"),
                new Customer(3, "Amit", "amit@outlook.com"),
                new Customer(3, "Rohit", "rohit@outlook.com")
        };

        for (Customer c : customers) {
            c.display();
        }
    }
}
