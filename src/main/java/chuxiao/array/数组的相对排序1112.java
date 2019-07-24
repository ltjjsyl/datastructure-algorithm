package chuxiao.array;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 给你两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。
 * 未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 *
 * 示例：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 *
 * */
public class 数组的相对排序1112 {
    public static void main(String[] args) {
        int[] arr1 = {2,3,1,3,2,4,6,7,9,2,19,8};
        int[] arr2 = {2,1,4,3,9,6};
        int [] result = relativeSortArray(arr1,arr2);
        for (int e: result) {
            System.out.print(e + " ");
        }
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> stat = new TreeMap<>();
        for(int i = 0; i < arr1.length; i++){
            if(stat.get(arr1[i]) == null){
                stat.put(arr1[i],1);
            }else {
                stat.put(arr1[i],stat.get(arr1[i])+1);
            }
        }
        //System.out.println("stat:" +stat);
        int[] res = new int[arr1.length];
        int index = 0;
        for(int j = 0; j< arr2.length;j++){
            int size = stat.get(arr2[j]);
          //  System.out.println("key:" + arr2[j] + "size :" + size);
            for(int k = index; k < index + size; k++){
                res[k] = arr2[j];
                //System.out.println(k + ":" +res[k]);
            }
            index += size;
            stat.remove(arr2[j]);
        }
        System.out.println("stat:" +stat);

        for(int x : stat.keySet()){
            int num = stat.get(x);
            for(int m = index; m < index + num; m++){
                res[m] = x;
               // System.out.println(m + ":" +res[m]);
            }
            index += num;
        }

        return res;
    }
}
