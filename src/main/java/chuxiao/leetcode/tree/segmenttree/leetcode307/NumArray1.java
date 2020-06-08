package chuxiao.leetcode.tree.segmenttree.leetcode307;

//超时的解法
public class NumArray1 {

    //原始数据
    private final int[] data;

    //sum[i]表示，从[0,i)区间数值的和
    private final int[] sum;

    public NumArray1(int[] nums) {

        data = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }

        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }


    public void update(int i, int val) {

        data[i] = val;

        for (int j = i; j < data.length; j++) {
            sum[j + 1] = sum[j] + data[j];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
