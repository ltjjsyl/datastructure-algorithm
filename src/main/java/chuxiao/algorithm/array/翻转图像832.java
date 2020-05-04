package chuxiao.algorithm.array;
/**
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 *
 * 示例 1:
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 *
 * 示例 2:
 * 输入: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
 * 输出: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 解释: 首先翻转每一行: [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]]；
 *      然后反转图片: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
 * 说明:
 *
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 *
 * */
public class 翻转图像832 {
    public static void main(String[] args) {
        int[][] arr1 = {{1,0,0},{0,0,0},{1,1,1},{0,1,0}};
        int[][] result = flipAndInvertImage(arr1);

        for (int i = 0; i < result.length;i++){
            for(int j = 0; j < result[i].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static  int[][] flipAndInvertImage(int[][] A) {
        int len1 = A.length;
        int len2 = A[0].length;

        int[][] res = new int[len1][len2];

        for(int i = 0; i < len1; i++) {
            int start = 0;
            int end = len2 - 1;

            while (start <= end) {
                res[i][end] = (~A[i][start]) & 0x01;
                res[i][start] = (~A[i][end]) & 0x01;
                start++;
                end--;
            }
        }

        return res;
    }
}