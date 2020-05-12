package chuxiao.datastructure.linear.stack;

import java.util.Random;

public class Main {

    private static double testStackOneTime(Stack<Integer> stack, int opCount) {

        long startTime = System.nanoTime();

        Random random = new Random();
        for (int i = 0; i < opCount; i++) {
            stack.push(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0; i < opCount; i++) {
            stack.pop();
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    private static double testQueueByTimes(String type, int times, int opCount) {
        double totalTimes = 0.0;

        for (int i = 0; i < times; i++) {
            Stack<Integer> stack = getNewStack(type);
            double runtime = testStackOneTime(stack, opCount);
            totalTimes = totalTimes + runtime;
        }

        return totalTimes / (double) times;
    }

    private static Stack<Integer> getNewStack(String type) {

        if (type.equalsIgnoreCase("arraystack")) {
            return new ArrayStack<>();

        }
        if (type.equalsIgnoreCase("linkedliststack")) {
            return new LinkedListStack<>();
        }

        return null;
    }

    public static void main(String[] args) {

        int opCount = 10000000;
        int times = 1;

        double runTime1 = testQueueByTimes("arraystack", times, opCount);
        System.out.println("ArrayQueue: spend time: " + runTime1 + "s");

        double runTime2 = testQueueByTimes("linkedliststack", times, opCount);
        System.out.println("LoopQueue: spend time: " + runTime2 + "s");

        System.out.println("linkedliststack fast than arraystack : " + runTime1 / runTime2);

        //时间分析是复杂的，LinkedListStack主要操作时new
    }
}
