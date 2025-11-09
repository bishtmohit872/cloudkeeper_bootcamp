package org.example;

public class StudentReport {
    String name;
    int sub1,sub2,sub3;
    StudentReport(String name,int sub1,int sub2,int sub3){
        this.name = name;
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
    }

    public int totalMarks(){
        return this.sub1+this.sub2+this.sub3;
    }

    public float average(){
        return (this.sub1 + this.sub2 + this.sub3)/3;
    }
}
