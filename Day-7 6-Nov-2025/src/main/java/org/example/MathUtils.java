package org.example;

public class MathUtils {
    int v1,v2;

    public int max(int a, int b){
        if(a>b){
            return a;
        }
        else{
            return b;
        }
    }
    public int min(int a, int b){
        if(a<b){
            return a;
        }
        else{
            return b;
        }
    }public int average(int a, int b){
        return (a+b)/2;
    }
}
