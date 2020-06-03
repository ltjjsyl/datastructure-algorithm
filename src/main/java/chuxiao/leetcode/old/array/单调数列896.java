package chuxiao.leetcode.old.array;
/**
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 *
 * 示例 1：
 * 输入：[1,2,2,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：[6,5,4,4]
 * 输出：true
 *
 * 示例 3：
 * 输入：[1,3,2]
 * 输出：false
 *
 * 示例 4：
 * 输入：[1,2,4,5]
 * 输出：true
 *
 * 示例 5：
 * 输入：[1,1,1]
 * 输出：true
 *
 * */
public class 单调数列896 {
    public static void main(String[] args) {
        int [] in = {1,1,1,1};
        System.out.println(isMonotonic1(in));
    }

    // 极值
    public static boolean isMonotonic1(int[] A) {
        int len = A.length;
        if(len < 2){
            return true;
        }

        int i = 0;
        while (  i < len - 1 && A[i+1] == A[i]){
            i++;
        }
        if(i == len -1){
            return true;
        }

        if(A[i+1] > A[i]){
            for (int j = i+1; j <len -1; j++){
                if(A[j+1] < A[j]){
                    return false;
                }
            }
        }

        if(A[i+1] < A[i]){
            for (int j = i+1; j <len -1; j++){
                if(A[j+1] > A[j]){
                    return false;
                }
            }
        }

        return true;
    }
}
