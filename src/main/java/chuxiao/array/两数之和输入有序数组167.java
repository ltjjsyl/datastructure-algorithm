package chuxiao.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个已按照升序排列的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值index1和index2，其中 ndex1必须小于index2。
 *
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。\
 *
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 *
 * */
public class 两数之和输入有序数组167 {
    public static void main(String[] args) {
        int [] in= {2, 2, 11, 15};
        int [] result = twoSum(in,4);
        System.out.println(result);
        System.out.println(result[0]);
        System.out.println(result [1]);
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> stat = new HashMap<>();
        for(int i = 0; i < numbers.length; i++){
            Integer sub = stat.get(target - numbers [i]);
            if(sub != null){
                int [] res = new int[2];
                res[0] = sub + 1;
                res[1] = i + 1;
                return res;
            }else {
                stat.put(numbers[i], i);
            }
        }
        return null;
    }
}
