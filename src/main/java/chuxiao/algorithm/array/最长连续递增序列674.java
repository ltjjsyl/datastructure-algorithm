package chuxiao.algorithm.array;

/**
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 * <p>
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 */
public class 最长连续递增序列674 {
    public static void main(String[] args) {
        int[] in = {1, 3, 4, 7};
        System.out.println(findLengthOfLCIS(in));
    }

    public static int findLengthOfLCIS(int[] nums) {
        int length = nums.length;
        if (length < 1) {
            return 0;
        }

        int start = 0;
        int index = start + 1;
        int maxLen = 0;
        while (index < length) {
            if (nums[index] > nums[index - 1]) {
                index++;
            } else {
                int tmp = index - start;
                maxLen = Math.max(maxLen, tmp);
                start = index;
                index = start + 1;
            }
        }
        int tmp = index - start;
        maxLen = Math.max(maxLen, tmp);
        return maxLen;
    }
}
