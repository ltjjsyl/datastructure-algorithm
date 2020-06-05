package chuxiao.leetcode.tree.heap.leetcode347;

import chuxiao.datastructure.linear.queue.Queue;
import chuxiao.datastructure.tree.heap.PriorityQueue;

import java.util.Map;
import java.util.TreeMap;

class Solution1 {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }

        Queue<Freq> pq = new PriorityQueue<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.getSize() < k) {
                pq.enqueue(new Freq(entry.getKey(), entry.getValue()));
            } else if (entry.getValue() > pq.getFront().f) {
                pq.dequeue();
                pq.enqueue(new Freq(entry.getKey(), entry.getValue()));
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.dequeue().e;
        }

        return res;
    }

    private class Freq implements Comparable<Freq> {
        public int e;
        public int f;

        public Freq(int e, int f) {
            this.e = e;
            this.f = f;
        }

        @Override
        public int compareTo(Freq another) {
            if (this.f < another.f) {
                return 1;
            } else if (this.f > another.f) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
