package chuxiao.leetcode.old.array;

import java.util.Arrays;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: 6
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: 24
 *
 * */
public class 三个数的最大乘积628 {
    public static void main(String[] args) {
        int [] in = {-9,-1,0,1,2,3,4};
        System.out.println(maximumProduct(in));
    }

    //最大的三个整数，最小的两个负数
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int max = nums [0] * nums [1] * nums [nums.length -1];
        int tmp = nums[nums.length -1]*nums[nums.length -2] * nums [nums.length - 3];
        if(tmp> max){
            max = tmp;
        }
        return max;
    }
}
