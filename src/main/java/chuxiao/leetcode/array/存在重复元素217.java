package chuxiao.leetcode.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回true。如果数组中每个元素都不相同，则返回 false。
 *
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 *
 * */
public class 存在重复元素217 {
    public static void main(String[] args) {
        int [] in = {1,2,3,4};
        System.out.println(containsDuplicate3(in));
    }

    public static boolean containsDuplicate1(int[] nums) {
        Map<Integer,Integer> stat = new HashMap<>();
        for(int e: nums){
            Integer val = stat.get(e);
            if(val== null){
                stat.put(e,1);
            }else {
                return true;
            }
        }
        return false;
    }

    public static boolean containsDuplicate2(int[] nums) {
        Set<Integer> stat = new HashSet<>();
        for(int e: nums){
            if(stat.contains(e)){
                return true;
            }else {
                stat.add(e);
            }
        }
        return false;
    }

    public static boolean containsDuplicate3(int[] nums) {
       for(int i = 0; i <nums.length; i++){
           for(int j = i+1; j < nums.length;j++){
               if((nums [i] ^ nums[j]) == 0){
                   return true;
               }
           }
       }
       return false;
    }
}
