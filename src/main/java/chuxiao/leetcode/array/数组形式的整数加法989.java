package chuxiao.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 对于非负整数 X 而言，X 的数组形式是每位数字按从左到右的顺序形成的数组。例如，如果 X = 1231，那么其数组形式为 [1,2,3,1]。
 * <p>
 * 给定非负整数 X 的数组形式 A，返回整数 X+K 的数组形式。
 *  
 * <p>
 * 示例 1：
 * 输入：A = [1,2,0,0], K = 34
 * 输出：[1,2,3,4]
 * 解释：1200 + 34 = 1234
 * <p>
 * 解释 2：
 * 输入：A = [2,7,4], K = 181
 * 输出：[4,5,5]
 * 解释：274 + 181 = 455
 * 示例 3：
 * <p>
 * 输入：A = [2,1,5], K = 806
 * 输出：[1,0,2,1]
 * 解释：215 + 806 = 1021
 * 示例 4：
 * <p>
 * 输入：A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * 输出：[1,0,0,0,0,0,0,0,0,0,0]
 * 解释：9999999999 + 1 = 10000000000
 */
public class 数组形式的整数加法989 {
    public static void main(String[] args) {
        int[] in = {9, 9, 9};
        System.out.println(addToArrayForm(in, 34));
    }

    public static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> res = new ArrayList<>();
        int lenK = String.valueOf(K).length();
        int lenA = A.length;
        int[] arrayK = new int[lenK];
        for (int i = lenK - 1; i >= 0; i--) {
            arrayK[i] = K % 10;
            K = K / 10;
        }

        int up = 0;
        for (int m = lenK - 1, n = lenA - 1; m >= 0 || n >= 0; m--, n--) {
            int tmpK = m >= 0 ? arrayK[m] : 0;
            int tmpA = n >= 0 ? A[n] : 0;
            int temp = tmpK + tmpA + up;
            if (temp >= 10) {
                up = 1;
            } else {
                up = 0;
            }
            res.add(temp % 10);
        }
        if (up == 1) {
            res.add(1);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i--) {
            result.add(res.get(i));
        }
        return result;
    }
}
