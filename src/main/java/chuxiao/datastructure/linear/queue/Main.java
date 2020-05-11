package chuxiao.datastructure.linear.queue;

import java.util.Random;

public class Main {

    private static double testQueueOneTime(Queue<Integer> q, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    private static double testQueueByTimes(String type, int times, int opCount) {
        double totalTimes = 0.0;

        for (int i = 0; i < times; i++) {
            Queue<Integer> queue = getNewQueue(type);
            double runtime = testQueueOneTime(queue, opCount);
            totalTimes = totalTimes + runtime;
        }

        return totalTimes / (double) times;
    }

    private static Queue<Integer> getNewQueue(String type) {

        if (type.equalsIgnoreCase("arrayqueue")) {
            return new ArrayQueue<>();

        }
        if (type.equalsIgnoreCase("loopqueue")) {
            return new LoopQueue<>();
        }

        return null;
    }

    public static void main(String[] args) {

        int opCount = 100000;
        int times = 100;

        double runTime1 = testQueueByTimes("arrayqueue", times, opCount);
        System.out.println("ArrayQueue: spend time: " + runTime1 + "s");

        double runTime2 = testQueueByTimes("loopqueue", times, opCount);
        System.out.println("LoopQueue: spend time: " + runTime2 + "s");

        System.out.println("LoopQueue fast than ArrayQueue : " + runTime1 / runTime2);
    }
}
