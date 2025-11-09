// Q-3
import java.util.HashMap;

public class FirstNonRepeatingCharSimple {
    public static void main(String[] args) {
        String str = "aabbcdeffg";
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1) {
                System.out.println("First non-repeating character: " + str.charAt(i));
                return;
            }
        }

        System.out.println("No non-repeating character found!");
    }
}

//Q-4
import java.util.HashMap;

public class TwoSumSimple {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement)) {
                System.out.println("Indices: " + map.get(complement) + " and " + i);
                return;
            }
            
            map.put(nums[i], i);
        }

        System.out.println("No two numbers add up to target.");
    }
}

// Q-5
import java.util.ArrayList;
import java.util.Collections;

public class MergeSortedLists {
    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 1, 3, 5, 7);

        ArrayList<Integer> list2 = new ArrayList<>();
        Collections.addAll(list2, 2, 4, 6, 8);

        ArrayList<Integer> mergedList = new ArrayList<>(list1);
        mergedList.addAll(list2);

        Collections.sort(mergedList);

        System.out.println("Merged Sorted List: " + mergedList);
    }
}

//Q-6
class Table2 extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("2 x " + i + " = " + (2 * i));
            try {
                Thread.sleep(500); // half second delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Table4 extends Thread {
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("4 x " + i + " = " + (4 * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Table2 t1 = new Table2();
        Table4 t2 = new Table4();

        t1.start();
        t2.start();
    }
}

// Q-7
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class TableTask implements Runnable {
    private int number;

    public TableTask(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(new TableTask(2));
        executor.submit(new TableTask(4));

        executor.shutdown();
    }
}


