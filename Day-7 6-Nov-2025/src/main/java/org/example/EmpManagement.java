package org.example;

class Employee {
    int id;
    String name;

    Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    double calculateSalary() {
        return 0;
    }

    void showInfo() {
        System.out.println(this.id + " - " + this.name + " - Salary: " + this.calculateSalary());
    }
}

class FullTimeEmployee extends Employee {
    double monthlySalary;

    FullTimeEmployee(int id, String name, double monthlySalary) {
        super(id, name);
        this.monthlySalary = monthlySalary;
    }

    @Override
    double calculateSalary() {
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee {
    int hoursWorked;
    double ratePerHour;

    PartTimeEmployee(int id, String name, int hoursWorked, double ratePerHour) {
        super(id, name);
        this.hoursWorked = hoursWorked;
        this.ratePerHour = ratePerHour;
    }

    @Override
    double calculateSalary() {
        return hoursWorked * ratePerHour;
    }
}

public class EmpManagement {
    public static void main(String[] args) {
        Employee[] employees = {
                new FullTimeEmployee(1, "Mohit", 30000),
                new PartTimeEmployee(2, "Sneha", 80, 200),
                new FullTimeEmployee(3, "Amit", 25000)
        };

        for (Employee e : employees) {
            e.showInfo(); // Polymorphism in action
        }
    }
}
