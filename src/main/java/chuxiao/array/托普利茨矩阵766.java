package chuxiao.array;
/**
 * 如果一个矩阵的每一方向由左上到右下的对角线上具有相同元素，那么这个矩阵是托普利茨矩阵。
 * 给定一个 M x N 的矩阵，当且仅当它是托普利茨矩阵时返回 True。
 *
 * 示例 1:
 * 输入:
 * matrix = [
 *   [1,2,3,4],
 *   [5,1,2,3],
 *   [9,5,1,2]
 * ]
 * 输出: True
 * 解释:
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是True。
 *
 * 示例 2:
 * 输入:
 * matrix = [
 *   [1,2],
 *   [2,2]
 * ]
 * 输出: False
 * 解释:
 * 对角线"[1, 2]"上的元素不同。
 *
 *
 * */
public class 托普利茨矩阵766 {
    public static void main(String[] args) {
        int[][] in ={ {1,2},
                {2,1},
                {9,5}};
        System.out.println(isToeplitzMatrix(in));
    }

    public static boolean isToeplitzMatrix(int[][] matrix) {
        int len1 =matrix.length;
        int len2 = matrix[0].length;

        for(int i = 0 ; i < len2; i++){
            int nextx = i;
            for(int j = 1; j < len1; j++){
                nextx++;
                if(nextx >= len2){
                    continue;
                }else {
                    if(matrix[0][i] != matrix[j][nextx]){
                        return false;
                    }
                }
            }

        }

        for(int i = 1 ; i < len1; i++){
            int nexty = i;
            for(int j = 1; j < len2; j++){
                nexty++;
                if(nexty >= len1){
                    continue;
                }else {
                    if(matrix[i][0] != matrix[nexty][j]){
                        return false;
                    }
                }
            }

        }

        return true;
    }
}
