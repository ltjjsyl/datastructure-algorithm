package chuxiao.leetcode.array;
/**
 *
 * 给出一个整数数组A和一个查询数组queries。
 * 对于第i次查询，有val=queries[i][0], index = queries[i][1]，我们会把val加到 A[index] 上。
 * 然后，第i次查询的答案是 A 中偶数值的和。
 * （此处给定的 index = queries[i][1]是从0开始的,索引每次查询都会永久修改数组A。）
 * 返回所有查询的答案。你的答案应当以数组answer给出answer[i]为第i次查询的答案。
 *
 * 示例：
 * 输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * 输出：[8,6,2,4]
 * 解释：
 * 开始时，数组为 [1,2,3,4]。
 * 将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 * 将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 * 将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 * 将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 *
 * */
public class 查询后的偶数和985 {
    public static void main(String[] args) {
        int[] A = {1,2,3,4};
        int[][] queries ={{1,0},{-3,1},{-4,0},{2,3}};

        int[] result = sumEvenAfterQueries(A, queries);
        for(int e : result){
            System.out.print(e + " ");
        }
    }

    public static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int len = A.length;
        int [] res = new int[len];
        int sum = 0;
        for(int j = 0; j < len; j++){
            if(A[j] % 2 == 0){
                sum += A[j];
            }
        }

        for(int i = 0; i < len; i++){
            int index = queries[i][1];
            int indexOldVal = ((A[index]%2) == 0) ? A[index] : 0;
            A[index] += queries[i][0];
            int indexNewVal =((A[index]%2) == 0) ? A[index] : 0;
            res[i] = sum - indexOldVal + indexNewVal;
            sum = res[i];
        }
        return res;
    }
}
