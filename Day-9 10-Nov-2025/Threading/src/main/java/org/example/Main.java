package org.example;
import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer{
    private Queue<Integer> queue = new LinkedList<>();
    private int capacity;

    public SharedBuffer(int capacity){
        this.capacity = capacity;
    }

    public synchronized void produce(int value) throws InterruptedException{
        while(queue.size() == capacity){
            wait();
        }
        queue.add(value);
        System.out.println("Produced Value: "+ value);
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException{
        while(queue.isEmpty()){
            wait();
        }

        int value = queue.poll();
        System.out.println("Consumer Consumed: "+value);

        notifyAll();
    }

}


class Producer implements Runnable{
    private SharedBuffer buffer;

    public Producer(SharedBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        try{
            for(int i=1;i<=50;i++){
                buffer.produce(i);
                Thread.sleep(100);
            }
        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}

class Consumer implements  Runnable{
    private SharedBuffer buffer;

    public Consumer(SharedBuffer buffer){
        this.buffer = buffer;
    }

    @Override
    public void run(){
        try{
            for(int i=1;i<=50;i++){
                buffer.consume();
                Thread.sleep(150);
            }
        }
        catch(InterruptedException  e){
            Thread.currentThread().interrupt();
        }
    }
}

interface A {
    void eat();
}

public class Main {
    public void getA(A a){

    }
    public static void main(String[] args) {
        SharedBuffer buffer = new SharedBuffer(5);

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 50; i++) buffer.produce(i);
            } catch (InterruptedException e) {}
        });
        Thread consumer = new Thread(()->{
            try{
                for(int i=1;i<=50;i++){
                    buffer.consume();
                    Thread.sleep(150);
                }
            }
            catch(InterruptedException  e){
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    };
}




