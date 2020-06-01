package chuxiao.datastructure.tree.set;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static double testSetOneTime(Set<String> set, String filename) {

        long startTime = System.nanoTime();
        //System.out.println(filename);

        List<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            //System.out.println("Total words: " + words.size());

            for (String word : words) {
                set.add(word);
            }

            //System.out.println("Total different words: " + set.getSize());
        }


        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    private static double testSetByTimes(Set<String> set, String filename, int times) {
        double totalTimes = 0.0;

        for (int i = 0; i < times; i++) {
            double runtime = testSetOneTime(set, filename);
            totalTimes = totalTimes + runtime;
        }

        return totalTimes / (double) times;
    }


    public static void main(String[] args) {

        String filename = "E:\\code\\develop\\datastructure-algorithm\\src\\main\\resources\\pride-and-prejudice.txt";

        int times = 10;

        Set<String> bstSet = new BSTSet<>();
        double runTime1 = testSetByTimes(bstSet, filename, times);
        System.out.println("BSTSet: spend time: " + runTime1 + "s");

        Set<String> linkedListSet = new LinkedListSet<>();
        double runTime2 = testSetByTimes(linkedListSet, filename, times);
        System.out.println("LinkedListSet: spend time: " + runTime2 + "s");


        System.out.println("========================");
        filename = "E:\\code\\develop\\datastructure-algorithm\\src\\main\\resources\\a-tale-of-two-cities.txt";
        bstSet = new BSTSet<>();
        runTime1 = testSetByTimes(bstSet, filename, times);
        System.out.println("BSTSet: spend time: " + runTime1 + "s");

        linkedListSet = new LinkedListSet<>();
        runTime2 = testSetByTimes(linkedListSet, filename, times);
        System.out.println("LinkedListSet: spend time: " + runTime2 + "s");

        //System.out.println("LoopQueue fast than ArrayQueue : " + runTime1 / runTime2);
    }
}
