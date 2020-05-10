package chuxiao.datastructure.linear.queue;

import chuxiao.datastructure.linear.array.myarray.v2.Array;

public class ArrayQueue<E> implements Queue<E> {

    Array<E> array;

    public ArrayQueue() {
        array = new Array<>();
    }

    public ArrayQueue(int capacity) {
        array = new Array<>(capacity);
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>();

        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 0) {
                System.out.println(queue.dequeue());
                System.out.println(queue);
            }
        }
        System.out.println(queue.getFront());
        System.out.println(queue);
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    //O(n)
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Queue ");
        stringBuilder.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            stringBuilder.append(array.get(i));
            if (i != array.getSize() - 1) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("] tail");

        return stringBuilder.toString();
    }
}
