package chuxiao.array;

/**
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * 返回其总持续时间（以秒为单位）可被60整除的歌曲对的数量。形式上，我们希望索引的数字  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * <p>
 * 示例 1：
 * 输入：[30,20,150,100,40]
 * 输出：3
 * <p>
 * 解释：这三对的总持续时间可被 60 整数：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * <p>
 * 示例 2：
 * 输入：[60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整数。
 */
public class 总持续时间可被60整除的歌曲1010 {
    public static void main(String[] args) {

    }

    //超时
    public static int numPairsDivisibleBy60(int[] time) {
        int length = time.length;
        int nums = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if ((time[i] + time[j]) % 60 == 0) {
                    nums++;
                }
            }
        }
        return nums;
    }


    public static int numPairsDivisibleBy601(int[] time) {
        int count = 0;
        int[] index = new int[60];
        for (int n : time) {
            // 最后还要取模60，是因为(60 - n % 60)的值有可能等于60，而对于我们声明的数组来说，60已经越界了
            count += index[(60 - n % 60) % 60];
            index[n % 60]++;
        }
        return count;
    }
}
