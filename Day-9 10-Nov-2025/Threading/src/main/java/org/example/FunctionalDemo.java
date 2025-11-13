package org.example;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.stream.Collectors;

import java.util.Optional;

public class FunctionalDemo {
    @FunctionalInterface
    public interface NumberRule<T>{
        Boolean test(T t);
    }

    static NumberRule<Integer> isEven =(Integer val)->{
        if(val%2==0){
            return true;
        }
        return false;
    };

    static NumberRule<Integer> primeNumber = (Integer val)->{
        if (val < 2) return false;
        for (int i = 2; i <= Math.sqrt(val); i++)
            if (val % i == 0) return false;
        return true;
    };

    public static void main(String args[]){

        // Q-1
        List<Integer> nums = Arrays.asList(3,10,2,15,8,21,14,7);

        List<Integer> evenNums = nums.stream().filter(n->{
            return isEven.test(n);}).collect(Collectors.toList());

        System.out.println(evenNums);

        List<Integer> prime = nums.stream().filter((n)->{
            return primeNumber.test(n);}).collect(Collectors.toList());

        System.out.println(prime);

        //Q-2

        List<Integer> results = nums.stream().filter(n->{
            return isEven.test(n);
        }).filter(n->{
            return primeNumber.test(n);
        }).collect(Collectors.toList());

        System.out.println(results);


        //Q-3

        Optional<Integer> firstSquared = results.stream()
                .map(n -> n * n)         // square the numbers
                .findFirst();            // get the first element (Optional)

        if (firstSquared.isPresent()) {
            System.out.println("First squared number: " + firstSquared.get());
        } else {
            System.out.println("No matching number found");
        }

    }
}
