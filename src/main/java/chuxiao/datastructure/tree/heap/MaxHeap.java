package chuxiao.datastructure.tree.heap;

import chuxiao.datastructure.linear.array.myarray.v2.Array;

import java.util.Random;

/**
 * 最大堆
 */
public class MaxHeap<E extends Comparable<E>> {

    private final Array<E> data;

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(E[] arr) {

        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>(n);

        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        System.out.println(maxHeap.replace(3));
        System.out.println(maxHeap.replace(1000));
        System.out.println(maxHeap.replace(1000));
        System.out.println(maxHeap.replace(1000));
        System.out.println(maxHeap.replace(1000));
        System.out.println(maxHeap.replace(1000));
        System.out.println("=======================");
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < n; i++) {
            if (res[i - 1] < res[i]) {
                throw new IllegalStateException("Heap has wrong.");
            }
        }
        System.out.println("Test heap complete.");
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    public E findMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }

        return data.get(0);
    }

    public E extractMax() {

        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);
        return ret;
    }

    public E replace(E e) {

        E ret = findMax();
        data.set(0, e);
        siftDown(0);
        return ret;
    }

    //完全二叉树，左孩子没有的时候右孩子一定没有
    private void siftDown(int k) {

        int leftChildIndex = leftChild(k);
        while (leftChildIndex < data.getSize()) {
            int maxChildIndex = leftChildIndex;
            int rightChildIndex = leftChildIndex + 1;
            if (rightChildIndex < data.getSize() &&
                    data.get(rightChildIndex).compareTo(data.get(leftChildIndex)) > 0) {
                maxChildIndex = rightChildIndex;
            }
            if (data.get(k).compareTo(data.get(maxChildIndex)) >= 0) {
                break;
            }
            data.swap(k, maxChildIndex);
            leftChildIndex = leftChild(maxChildIndex);
            k = maxChildIndex;
        }
    }

    private void siftDown1(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);

            if (j + 1 < data.getSize() &&
                    data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    //返回当前index父节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("Index 0 doesn't has parent");
        }
        return (index - 1) / 2;
    }

    //返回当前index左孩子的索引
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    //返回当前index右孩子的索引
    private int rightChild(int index) {
        return 2 * index + 2;
    }
}
