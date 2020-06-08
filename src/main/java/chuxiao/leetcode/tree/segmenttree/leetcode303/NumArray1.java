package chuxiao.leetcode.tree.segmenttree.leetcode303;

public class NumArray1 {

    //sum[i]表示，从[0,i)区间数值的和
    private final int[] sum;

    public NumArray1(int[] nums) {

        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
