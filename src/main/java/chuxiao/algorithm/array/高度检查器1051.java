package chuxiao.algorithm.array;

import java.util.Arrays;

/**
 * 学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
 * 请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。

 * 示例：
 * 输入：[1,1,4,2,1,3]
 * 输出：3
 * 解释：
 * 高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。
 * */
public class 高度检查器1051 {
    public static void main(String[] args) {
        int[] in = {1,1,4,2,1,3};
        int result = heightChecker(in);
        System.out.println("result = " + result);
    }

    public static int heightChecker(int[] heights) {
        int res = 0;
        int[] copy = Arrays.copyOf(heights,heights.length);
        Arrays.sort(heights);
        for(int i =0 ; i < copy.length; i++){
            if(copy[i] != heights[i]){
                res++;
            }
        }
        return res;
    }
}
