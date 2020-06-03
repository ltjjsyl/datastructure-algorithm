package chuxiao.leetcode.old.array;

/**
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数0之外，这个整数不会以零开头。
 *
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 *
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 *
 * */
public class 加一66 {

    public static void main(String[] args) {
        int[] in = {9,1};
        int[] result = plusOne(in);

        for (int e:result) {
            System.out.print(e);
        }
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;

        int up = 1;
        for (int i = len - 1; i >= 0; i--) {
            int res = digits [i]  + up;
            if(res >= 10){
                digits [i] = res - 10;
            }else {
                up = 0;
                digits [i] = res;
                break;
            }
        }
        if(up != 0){
            int [] result = new int [len +1];
            result[0] = 1;
            for(int i = 1; i < len+1; i++){
                result [i] = digits [i-1];
            }
            return result;
        }
        return digits;
    }
}
