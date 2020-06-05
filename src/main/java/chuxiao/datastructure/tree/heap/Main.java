package chuxiao.datastructure.tree.heap;

import java.util.Random;

public class Main {

    private static double testHeap(Integer[] arr, boolean heapify) {
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (heapify) {
            maxHeap = new MaxHeap<>(arr);
        } else {
            maxHeap = new MaxHeap<>(arr.length);
            for (int i = 0; i < arr.length; i++) {
                maxHeap.add(arr[i]);
            }
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = maxHeap.extractMax();
        }

        for (int i = 1; i < res.length; i++) {
            if (res[i - 1] < res[i]) {
                throw new IllegalStateException("Heap has wrong.");
            }
        }
        System.out.println("Test heap complete.");

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int n = 10000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time1 = testHeap(testData, false);
        System.out.println("without heapify time: " + time1);

        double time2 = testHeap(testData, true);
        System.out.println("with heapify time: " + time2);
    }
}
