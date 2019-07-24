package chuxiao.array;
/**
 * 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i]为奇数时，i也是奇数；当 A[i]为偶数时，i也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 *
 * 示例：
 * 输入：[4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * */
public class 按奇偶排序数组II922 {
    public static void main(String[] args) {
        int[] in = {4,3,32,1};
        int[] restult = sortArrayByParityII(in);

        for(int i = 0; i < restult.length; i++){
            System.out.print(restult[i] + " ");
        }
    }

    public static int[] sortArrayByParityII(int[] A) {
        int enenIndex = 0; //偶数
        int oddIndex = A.length - 1; //奇数

        while (true){
            while (enenIndex < A.length && A[enenIndex] % 2 == 0){
                enenIndex += 2;
            }

            while (oddIndex > 0 && A[oddIndex]%2 != 0){
                oddIndex -=2;
            }

            if(enenIndex >= A.length || oddIndex <= 0){
                break;
            }

            int tmp = A[enenIndex];
            A[enenIndex] = A[oddIndex];
            A[oddIndex] = tmp;
        }
        return A;
    }
}
