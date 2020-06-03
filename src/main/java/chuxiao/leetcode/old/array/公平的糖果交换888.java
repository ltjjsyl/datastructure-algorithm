package chuxiao.leetcode.old.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 爱丽丝和鲍勃有不同大小的糖果棒：A[i]是爱丽丝拥有的第i块糖的大小，B[j]是鲍勃拥有的第j块糖的大小。
 * 因为他们是朋友，所以他们想交换一个糖果棒，这样交换后，他们都有相同的糖果总量。
 * (一个人拥有的糖果总量是他们拥有的糖果棒大小的总和。）
 *
 * 返回一个整数数组ans，其中ans[0]是爱丽丝必须交换的糖果棒的大小，ans[1]是Bob必须交换的糖果棒的大小。
 * 如果有多个答案，你可以返回其中任何一个。保证答案存在。
 * 示例 1：
 * 输入：A = [1,1], B = [2,2]
 * 输出：[1,2]
 *
 * 示例 2：
 * 输入：A = [1,2], B = [2,3]
 * 输出：[1,2]
 *
 * 示例 3：
 * 输入：A = [2], B = [1,3]
 * 输出：[2,3]
 *
 * 示例 4：
 * 输入：A = [1,2,5], B = [2,4]
 * 输出：[5,4]
 *
 * */
public class 公平的糖果交换888 {
    public static void main(String[] args) {
        int []A = {1,2,5};
        int []B = {2,4};
        int [] result= fairCandySwap(A,B);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public static int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];

        int sumA = 0;
        for(int i = 0 ; i < A.length; i++){
            sumA+= A[i];
        }
        int sumB = 0;
        Set<Integer> stat = new HashSet<>();
        for(int j = 0; j < B.length;j++){
            stat.add(B[j]);
            sumB+=B[j];
        }

        int avg = (sumA + sumB)/2;
        for(int i = 0; i < A.length;i++){
            int diff = avg - (sumA - A[i]);
            if(stat.contains(diff)){
                res[0] = A[i];
                res[1] = diff;
                break;
            }
        }
        return res;
    }
}
