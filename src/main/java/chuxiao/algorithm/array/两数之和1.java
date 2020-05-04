package chuxiao.algorithm.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组nums和一个目标值target，请你在该数组中找出和为目标值的那两个整数，并返回他们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * */
public class 两数之和1 {
    public static void main(String[] args) {
        int[] in = {2, 2, 11, 15};
        int[] result = twoSum(in,4);
        for(int e : result){
            System.out.print(e + " ");
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> stat = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int need = target - nums[i];
            if(stat.containsKey(need)){
                int[] res = new int[2];
                res[0] = stat.get(need);
                res[1] = i;
                return res;
            }
            stat.put(nums[i],i);
        }
        return null;
    }
}
