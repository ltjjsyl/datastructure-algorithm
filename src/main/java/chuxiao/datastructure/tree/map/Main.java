package chuxiao.datastructure.tree.map;

import chuxiao.datastructure.tree.set.BSTSet;
import chuxiao.datastructure.tree.set.FileOperation;
import chuxiao.datastructure.tree.set.LinkedListSet;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static double testMapOneTime(Map<String, Integer> map, String filename) {

        long startTime = System.nanoTime();
        //System.out.println(filename);

        List<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            //System.out.println("Total words: " + words.size());

            for (String word : words) {
                if (map.containsKey(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            //System.out.println("Total different words: " + set.getSize());
        }


        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    private static double testMapByTimes(Map<String, Integer> map, String filename, int times) {
        double totalTimes = 0.0;

        for (int i = 0; i < times; i++) {
            double runtime = testMapOneTime(map, filename);
            totalTimes = totalTimes + runtime;
        }

        return totalTimes / (double) times;
    }


    public static void main(String[] args) {

        String filename = "E:\\code\\develop\\datastructure-algorithm\\src\\main\\resources\\pride-and-prejudice.txt";

        int times = 10;

        Map<String, Integer> map = new LinkedListMap<>();
        double runTime = testMapByTimes(map, filename, times);
        System.out.println("LinkedListMap: spend time: " + runTime + "s");

        map = new BSTMap<>();
        runTime = testMapByTimes(map, filename, times);
        System.out.println("BSTMap: spend time: " + runTime + "s");


        System.out.println("========================");
        filename = "E:\\code\\develop\\datastructure-algorithm\\src\\main\\resources\\a-tale-of-two-cities.txt";
        map = new LinkedListMap<>();
       runTime = testMapByTimes(map, filename, times);
        System.out.println("LinkedListMap: spend time: " + runTime + "s");

        map = new BSTMap<>();
        runTime = testMapByTimes(map, filename, times);
        System.out.println("BSTMap: spend time: " + runTime+ "s");

        //System.out.println("LoopQueue fast than ArrayQueue : " + runTime1 / runTime2);
    }

}
