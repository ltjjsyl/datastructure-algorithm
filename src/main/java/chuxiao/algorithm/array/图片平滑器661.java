package chuxiao.algorithm.array;

public class 图片平滑器661 {
    public static void main(String[] args) {

    }

    public static int[][] imageSmoother(int[][] M) {
        int len1 = M.length;
        int len2 = M[0].length;

        int[][] res = new int[len1][len2];

        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                int sum = M[i][j];
                int count = 1;
                res[i][j] = sum / count;
            }
        }

        return res;
    }
}
