package chuxiao.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定由若干 0 和 1 组成的数组 A。我们定义 N_i：从 A[0] 到 A[i] 的第 i 个子数组被解释为一个二进制数（从最高有效位到最低有效位）。
 * <p>
 * 返回布尔值列表 answer，只有当 N_i 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 * <p>
 * 示例 1：
 * 输入：[0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为真。
 * <p>
 * 示例 2：
 * 输入：[1,1,1]
 * 输出：[false,false,false]
 * 示例 3：
 * <p>
 * 输入：[0,1,1,1,1,1]
 * 输出：[true,false,false,false,true,false]
 * <p>
 * 示例 4：
 * 输入：[1,1,1,0,1]
 * 输出：[false,false,false,false,false]
 */
public class 可被5整除的二进制前缀1018 {
    public static void main(String[] args) {
        int[] in = {1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0};
        System.out.println(prefixesDivBy5(in));
    }

    //long会溢出
    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<>();
        long tmp = 0;
        for (int i = 0; i < A.length; i++) {
            tmp = tmp * 2 + A[i];
            System.out.println(tmp);
            if (tmp % 5 == 0) {
                list.add(Boolean.TRUE);
            } else {
                list.add(Boolean.FALSE);
            }
        }
        return list;
    }

    public static List<Boolean> prefixesDivBy51(int[] A) {
        List<Boolean> list = new ArrayList<>();
        long tmp = 0;
        for (int i = 0; i < A.length; i++) {
            tmp = ((tmp * 2) % 10) + A[i];
            System.out.println(tmp);
            if (tmp % 5 == 0) {
                list.add(Boolean.TRUE);
            } else {
                list.add(Boolean.FALSE);
            }
        }
        return list;
    }
}
