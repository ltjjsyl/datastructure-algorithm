package chuxiao.leetcode.array;
/**
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 *
 * 示例
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 *
 * */
public class 按奇偶排序数组905 {
    public static void main(String[] args) {
        int[] in = {3};
        int[] restult = sortArrayByParity2(in);

        for(int i = 0; i < restult.length; i++){
            System.out.print(restult[i] + " ");
        }
    }


    public static int[] sortArrayByParity1(int[] A) {
        int len = A.length;
        int[] res = new int[len];
        int start = 0;
        int end = len -1;
        for(int i = 0; i < len; i++){
            if(A[i] % 2 == 0){
                res[start++] = A[i];
            }else {
                res[end--] = A[i];
            }
        }
        return res;
    }


    public static int[] sortArrayByParity2(int[] A) {
        int start = 0;
        int end = A.length - 1;

        while (true){
            while (start < end && A[start] % 2 == 0){
                start++;
            }
            while (end > start && A[end] % 2 != 0){
                end--;
            }

            if(start >= end){
                break;
            }

            int tmp = A[start];
            A[start] = A[end];
            A[end] = tmp;
            start++;
            end--;
        }
        return A;
    }
}
