package chuxiao.array;
/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于⌊n/2⌋的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2。
 * */
public class 求众数169 {
    public static void main(String[] args) {
        int [] in = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(in));
    }

    //方法一 map 计数  找到出现次数最多的数
    //方法二 排序

    //在索引i时，xxxx

    //在索引i时，i之前包括i出现最多的数
    public static int majorityElement(int[] nums) {
        int cand = 0;
        int times = 0;
        for(int i = 0; i < nums.length; i++){
            if(times == 0){
                cand = nums[i];
                times++;
            }else if(cand == nums[i]){
                times++;
            }else {
                times--;
            }
        }
        return cand;
    }
}
