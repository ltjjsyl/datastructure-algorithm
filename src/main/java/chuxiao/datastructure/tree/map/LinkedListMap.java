package chuxiao.datastructure.tree.map;

import java.util.ArrayList;
import java.util.List;

public class LinkedListMap<K, V> implements Map<K, V> {

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    public static void main(String[] args) {
        System.out.println("Pride and Prejudice");

        List<String> words = new ArrayList<>();
        if (FileOperation.readFile("E:\\code\\develop\\datastructure-algorithm\\src\\main\\resources\\pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            Map<String, Integer> map = new LinkedListMap<>();
            for (String word : words) {
                if (map.containsKey(word))
                    map.set(word, map.get(word) + 1);
                else
                    map.add(word, 1);
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of PRIDE: " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        System.out.println();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(K key, V value) {

        Node res = findNode(key);
        if (res != null) {
            res.value = value;
            return;
        }

        dummyHead.next = new Node(key, value, dummyHead.next);
        size++;
    }

    @Override
    public V get(K key) {

        Node res = findNode(key);
        if (res != null) {
            return res.value;
        }
        return null;
    }

    @Override
    public void set(K key, V value) {

        Node ret = findNode(key);
        if (ret == null) {
            throw new IllegalArgumentException("not contains key : " + key);
        }
        ret.value = value;
    }

    @Override
    public boolean containsKey(K key) {
        return findNode(key) != null;
    }

    @Override
    public V remove(K key) {

        Node pre = dummyHead;
        while (pre.next != null && !pre.next.key.equals(key)) {
            pre = pre.next;
        }

        if (pre.next != null) {
            Node delNode = pre.next;
            pre.next = delNode.next;
            delNode.next = null;
            size--;
            return delNode.value;
        }

        return null;
    }

    private Node findNode(K key) {

        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key, V value) {
            this(key, value, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }
}
