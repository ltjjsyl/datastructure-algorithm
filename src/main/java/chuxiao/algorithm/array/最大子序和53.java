package chuxiao.algorithm.array;
/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * */
public class 最大子序和53 {
    public static void main(String[] args) {
        int [] in ={-2,-1,3,-4,1,-2,-1,-5,-4};
        System.out.println(maxSubArray(in));
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int index = 0;
        int sum = 0;
        while (index < nums.length){
            if(nums [index] > max){
                max =nums [index];
            }
            sum += nums [index];
            if(sum < 0){
               sum = 0;
            }else if(sum > max){
                max = sum;
            }

            index++;
        }
        return max;
    }

    //分制
    public static int maxSubArray1(int[] nums) {
        int max = Integer.MIN_VALUE;

        return max;
    }
}
