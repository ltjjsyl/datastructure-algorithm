package chuxiao.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n (n=数组大小)的整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 *
 * 示例:
 * 输入:
 * [4,3,2,7,8,2,3,1]
 *
 * 输出:
 * [5,6]
 *
 *
 * */
public class 找到所有数组中消失的数字448 {
    public static void main(String[] args) {
        int [] in ={4,3,2,7,8,2,3,1};
        System.out.println(findDisappearedNumbers(in));
    }
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; ){
           // System.out.println(i+ " " + nums[i]);
            if((nums[i] == (i + 1)) || (nums[i] == nums[nums[i] - 1])){
                i++;
            }else {
                int tmp = nums[i];
                nums [i] = nums [nums[i]-1];
                nums [tmp -1] = tmp;
            }
        }
        for (int i =0 ;i <nums.length;i++){
            if(nums[i] != (i+1)){
                res.add(i+1);
            }
        }

        return  res;
    }
}
