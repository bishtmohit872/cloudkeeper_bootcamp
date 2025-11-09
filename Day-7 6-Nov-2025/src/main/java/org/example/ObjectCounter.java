package org.example;

public class ObjectCounter {
    static int count=0;
    ObjectCounter(){
        count+=1;
    }

    static int getCount(){
        return count;
    }
}
