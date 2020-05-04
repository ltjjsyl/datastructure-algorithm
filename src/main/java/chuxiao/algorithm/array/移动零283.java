package chuxiao.algorithm.array;
/**
 * 给定一个数组nums，编写一个函数将所有0移动到数组的末尾，同时保持非零元素的相对顺序
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * */
public class 移动零283 {

    public static void main(String[] args) {
        int[] in = {1,1,0,3,12};
        moveZeroes2(in);
        for(int e : in){
            System.out.print(e + " ");
        }
    }

    public static void moveZeroes(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int start = 0;
        int end = len - 1;
        for(int e : nums){
            if(e == 0){
                end--;
            }else{
                res[start++] = e;
            }
        }
        nums = res;
    }

    //执行用时	内存消耗
    //1 ms	    42.3 MB
    public static void moveZeroes1(int[] nums) {
        int count = 0;
        for(int e : nums){
            if(e != 0){
                nums[count++] = e;
            }
        }
        for(int i = count; i < nums.length; i++){
            nums[i] = 0;
        }
    }

    //执行用时	内存消耗
    //1 ms	    40.9 MB
    public static void moveZeroes2(int[] nums) {
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                if(i != index){
                    nums[index] = nums[i];
                    nums[i] = 0;
                }
                index++;
            }
        }
    }
}
