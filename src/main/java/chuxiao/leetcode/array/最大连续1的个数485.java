package chuxiao.leetcode.array;

/**
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 * <p>
 * 示例 1:
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 */
public class 最大连续1的个数485 {
    public static void main(String[] args) {
        int[] in = {1,1,0,1,1,1,0,1};
        System.out.println(findMaxConsecutiveOnes(in));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxlen = 0;

        int start = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if(start == -1){
                    start = i;
                }
            } else if (start != -1) {
                int tmpLen = i - start;
                maxlen = (maxlen > tmpLen) ? maxlen : tmpLen;
                start = -1;
                //System.out.println(maxlen);
            }
        }
        if (start != -1) {
            int tmpLen = nums.length - start;
            maxlen = (maxlen > tmpLen) ? maxlen : tmpLen;
            start = -1;
        }
        return maxlen;
    }
}
