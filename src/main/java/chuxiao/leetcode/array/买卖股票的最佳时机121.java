package chuxiao.leetcode.array;

/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 注意你不能在买入股票前卖出股票。
 * <p>
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * <p>
 * 示例 2:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class 买卖股票的最佳时机121 {
    public static void main(String[] args) {
        int[] in = {7,1,5,3,6,4};
        System.out.println(maxProfit(in));
    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        //[0,i) 的最小值
        int[] min = new int[prices.length + 1];
        min[0] = Integer.MAX_VALUE;
        for (int i = 1; i <= prices.length; i++) {
            if (prices[i - 1] < min[i - 1]) {
                min[i] = prices[i - 1];
            } else {
                min[i] = min[i - 1];
                int tmp = prices[i - 1] - min[i - 1];
                if (max < tmp) {
                    max = tmp;
                }
            }
        }

        return max;
    }
}
