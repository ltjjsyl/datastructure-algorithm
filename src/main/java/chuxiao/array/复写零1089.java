package chuxiao.array;

import java.util.Arrays;

/**
 * 给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 * 注意：请不要在超过该数组长度的位置写入元素。
 * 要求：请对输入的数组就地进行上述修改，不要从函数返回任何东西。
 *
 * 示例 1：
 * 输入：[1,0,2,3,0,4,5,0]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 *
 * 示例 2：
 * 输入：[1,2,3]
 * 输出：null
 * 解释：调用函数后，输入的数组将被修改为：[1,2,3]
 *
 */
public class 复写零1089 {
    public static void main(String[] args) {
        int [] in = {0,1,7,6,0,2,0,7};
        duplicateZeros2(in);
        for(int eelement : in){
            System.out.print(eelement + " ");
        }
    }

    public static void duplicateZeros1(int[] arr) {
        int[] tmp = new int[arr.length];
        int index = 0;
        for (int i = 0; i < arr.length;){
            tmp[i] = arr [index++];
            if(tmp[i] == 0 && i < arr.length - 1){
               tmp[i+1] = 0;
               i+=2;
            }else {
                i++;
            }
        }
        System.arraycopy(tmp,0,arr,0,arr.length);
    }

    public static void duplicateZeros2(int[] arr) {
        int toIndex = 0;
        for (int i = 0; i < arr.length;){
            if(arr[toIndex] == 0 && i < arr.length - 1){
                i += 2;
                toIndex++;
            }else {
                if(arr[toIndex] != 0 || i != arr.length - 1){
                    toIndex++;
                }
                i++;
            }

        }
        int index = arr.length - 1;
        for(int i = toIndex-1; i >= 0; i--){
            //System.out.println(index + " "+ toIndex);
            arr[index] = arr[i];
            if(arr[i] == 0){
                arr[index-1] = 0;
                index -= 2;
            }else {
                index--;
            }
        }
    }

}
