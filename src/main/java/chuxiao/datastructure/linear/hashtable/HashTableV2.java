package chuxiao.datastructure.linear.hashtable;

import java.util.ArrayList;
import java.util.TreeMap;

public class HashTableV2<K, V> {

    private static final int upperTol = 10;
    private static final int lowerTol = 2;


    private static final int[] capacity
            = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    private TreeMap<K, V>[] hashTable;
    private int M;
    private int size;
    private int capacityIndex = 0;

    public HashTableV2() {
        this.M = capacity[capacityIndex];
        this.size = 0;
        hashTable = new TreeMap[M];
        for (int i = 0; i < M; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    public static void main(String[] args) {

        System.out.println("Pride and Prejudice");

        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("E:\\code\\develop\\datastructure-algorithm\\src\\main\\resources\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            // Collections.sort(words);

            // Test BST
            long startTime = System.nanoTime();

            BST<String, Integer> bst = new BST<>();
            for (String word : words) {
                if (bst.contains(word))
                    bst.set(word, bst.get(word) + 1);
                else
                    bst.add(word, 1);
            }

            for (String word : words)
                bst.contains(word);

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("BST: " + time + " s");


            // Test AVL
            startTime = System.nanoTime();

            AVLTree<String, Integer> avl = new AVLTree<>();
            for (String word : words) {
                if (avl.contains(word))
                    avl.set(word, avl.get(word) + 1);
                else
                    avl.add(word, 1);
            }

            for (String word : words)
                avl.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("AVL: " + time + " s");


            // Test RBTree
            startTime = System.nanoTime();

            RBTree<String, Integer> rbt = new RBTree<>();
            for (String word : words) {
                if (rbt.contains(word))
                    rbt.set(word, rbt.get(word) + 1);
                else
                    rbt.add(word, 1);
            }

            for (String word : words)
                rbt.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("RBTree: " + time + " s");


            // Test HashTable
            startTime = System.nanoTime();

            HashTableV2<String, Integer> ht = new HashTableV2<>();
            //HashTable<String, Integer> ht = new HashTable<>(131071);
            for (String word : words) {
                if (ht.contains(word))
                    ht.set(word, ht.get(word) + 1);
                else
                    ht.add(word, 1);
            }

            for (String word : words)
                ht.contains(word);

            endTime = System.nanoTime();

            time = (endTime - startTime) / 1000000000.0;
            System.out.println("HashTable: " + time + " s");
        }

        System.out.println();
    }

    public int getSize() {
        return this.size;
    }

    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;

            if (size > upperTol * M && capacityIndex + 1 < capacity.length) {
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }
        }


    }

    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;
            if (size < lowerTol * M && capacityIndex - 1 >= 0) {
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
        }
        return ret;
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException("not contains key: " + key);
        }
        map.put(key, value);
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }

    private void resize(int newM) {

        TreeMap<K, V>[] newHashTable = new TreeMap[newM];
        for (int i = 0; i < newM; i++) {
            newHashTable[i] = new TreeMap<>();
        }

        int oldM = M;
        M = newM;
        for (int i = 0; i < oldM; i++) {
            for (K key : hashTable[i].keySet()) {
                newHashTable[hash(key)].put(key, hashTable[i].get(key));
            }
        }
        this.hashTable = newHashTable;
    }
}
