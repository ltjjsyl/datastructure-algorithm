package chuxiao.algorithm.array;

/**
 * 给定一个矩阵 A， 返回A的转置矩阵。
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * 示例 1：
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *
 * */
public class 转置矩阵867 {
    public static void main(String[] args) {
        int[][] arr1 = {{1,2,3},{4,5,6}};
        int[][] result = transpose(arr1);

        for (int i = 0; i < result.length;i++){
            for(int j = 0; j < result[i].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] transpose(int[][] A) {
        int len1 = A.length;
        int len2 = A[0].length;

        int [][] res = new int[len2][len1];

        for(int i = 0; i < len1; i++){
            for(int j = 0; j < len2; j++){
                res[j][i] = A[i][j];
            }
        }

        return res;
    }

}
