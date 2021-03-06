package chuxiao.leetcode.old.array;
/**
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * */
public class 合并两个有序数组88 {

    public static void main(String[] args) {

    }

    //
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n -1;
        int m1 = m-1;
        int n1 = n-1;

        while (n1 >= 0 || m1 >=0){
            if(n1 < 0){
                nums1 [end--] = nums1 [m1--];
                continue;
            }

            if(m1 < 0){
                nums1 [end--] = nums2 [n1--];
                continue;
            }

            if(nums2[n1] > nums1 [m1]){
                nums1 [end--] = nums2 [n1--];
                continue;
            }else  {
                nums1 [end--] = nums1 [m1--];
                continue;
            }
        }
    }
}
