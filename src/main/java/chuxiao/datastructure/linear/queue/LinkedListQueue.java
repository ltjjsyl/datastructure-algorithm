package chuxiao.datastructure.linear.queue;

import chuxiao.datastructure.linear.list.v2.LinkedList;

//从tail入队，head出队，因为是单向队列
public class LinkedListQueue<E> implements Queue<E> {

    private Node head;
    private Node tail;
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public static void main(String[] args) {
        LinkedListQueue<Integer> queue = new LinkedListQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                System.out.println(queue.dequeue());
                System.out.println(queue);
            }
        }
        System.out.println(queue.getFront());
        System.out.println(queue);
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }

        Node retNode = head;
        head = head.next;
        retNode.next = null;
        size--;
        if (head == null) {
            tail = null;
        }
        return retNode.e;
    }

    @Override
    public E getFront() {

        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return head.e;
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
    public String toString() {
        StringBuilder res = new StringBuilder();

        res.append("LinkedListQueue:").append(" front ");
        Node retNode = head;
        while (retNode != null){
            res.append(retNode.e).append("->");
            retNode = retNode.next;
        }

        res.append("NULL tail");
        return res.toString();
    }

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this.e = e;
            this.next = null;
        }

        public Node() {
            this.e = null;
            this.next = null;
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}
