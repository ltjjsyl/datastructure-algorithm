package chuxiao.leetcode.array;

import java.util.Arrays;

/**
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 *
 * */
public class 缺失数字268 {
    public static void main(String[] args) {
        int [] in = {3,0,1};
        System.out.println(missingNumber2(in));
    }

    public static int missingNumber1(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length;i++){
            if(nums[i] != i){
                return i;
            }
        }
        return nums.length;
    }

    public static int missingNumber2(int[] nums) {
        int res = nums.length;
        for(int i = 0; i < nums.length;i++){
            res =res + i - nums[i];
        }
        return res;
    }


}
