package chuxiao.array;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 给定一个非空且只包含非负数的整数数组nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是找到与nums拥有相同大小的度的最短连续子数组，返回其长度。
 * 示例 1:
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.

 * 示例 2:
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 */
public class 数组的度697 {
    public static void main(String[] args) {
        int[] in = {1};
        System.out.println(findShortestSubArray1(in));
    }

    public static int findShortestSubArray1(int[] nums) {
        int max = 1;
        Map<Integer, Integer> startMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        Map<Integer, Integer> stat = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer start = startMap.get(nums[i]);
            if (start == null || start > i) {
                startMap.put(nums[i], i);
            }

            Integer end = endMap.get(nums[i]);
            if (end == null || end < i) {
                endMap.put(nums[i], i);
            }

            Integer val = stat.get(nums[i]);
            if (val == null) {
                stat.put(nums[i], 1);
            } else {
                stat.put(nums[i], val + 1);
                if (val + 1 > max) {
                    max = val + 1;
                }
            }
        }


        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer,Integer> entry : stat.entrySet()) {
            if (entry.getValue() == max) {
                int num = entry.getKey();
                int len = endMap.get(num) - startMap.get(num);
                if (len < min) {
                    min = len;
                }
            }
        }
        return min + 1;
    }

    public static int findShortestSubArray2(int[] nums) {
        int max = 0;
        Map<Integer, Integer> startMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        List<Integer> numList = new ArrayList<>();
        Map<Integer, Integer> stat = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer start = startMap.get(nums[i]);
            if (start == null || start > i) {
                startMap.put(nums[i], i);
            }

            Integer end = endMap.get(nums[i]);
            if (end == null || end < i) {
                endMap.put(nums[i], i);
            }

            Integer val = stat.get(nums[i]);
            if (val == null) {
                stat.put(nums[i], 1);
            } else {
                stat.put(nums[i], val + 1);
                if (val + 1 > max) {
                    max = val + 1;
                    numList.clear();
                    numList.add(nums[i]);
                }
                if (val + 1 == max) {
                    numList.add(nums[i]);
                }
            }
        }
        if(numList.isEmpty()){
            return 1;
        }
        int min = Integer.MAX_VALUE;
        for (Integer e : numList) {
            int len = endMap.get(e) - startMap.get(e);
            if (len < min) {
                min = len;
            }
        }
        return min + 1;
    }
}
