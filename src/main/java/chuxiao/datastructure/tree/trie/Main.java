package chuxiao.datastructure.tree.trie;

import chuxiao.datastructure.linear.hashtable.FileOperation;
import chuxiao.datastructure.tree.set.BSTSet;
import chuxiao.datastructure.tree.set.Set;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        //if (FileOperation.readFile("E:\\code\\develop\\datastructure-algorithm\\src\\main\\resources\\pride-and-prejudice.txt", words)) {
        if (FileOperation.readFile("E:\\code\\develop\\datastructure-algorithm\\src\\main\\resources\\a-tale-of-two-cities.txt", words)) {

            // Test BSTSet
            long startTime = System.nanoTime();
            Set<String> set = new BSTSet<>();

            for (String word : words) {
                set.add(word);
            }
            for (String word : words) {
                set.contains(word);
            }

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BSTSet: word size = " + set.getSize());
            System.out.println("BSTSet: " + time + " s");


            // Test Trie
            startTime = System.nanoTime();
            Trie trie = new Trie();
            for (String word : words) {
                trie.add(word);
            }
            for (String word : words) {
                trie.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;

            System.out.println("Trie: word size = " + trie.getSize());
            System.out.println("Trie: " + time + " s");
        }
    }
}
