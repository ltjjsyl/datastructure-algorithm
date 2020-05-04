package chuxiao.algorithm.array;
/**
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。
 * 该数列由0和1开始，后面的每一项数字都是前面两项数字的和。也就是
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 * 示例 1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * 示例 2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 示例 3：
 *
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 * */
public class 斐波那契数509 {
    public static void main(String[] args) {
        System.out.println(fib2(0));
        System.out.println(fib2(1));
        System.out.println(fib2(5));
        System.out.println(fib2(30));
    }
    //执行用时	内存消耗
    //13 ms	    32.9 MB
    public static int fib1(int N) {
        if(N == 0 || N == 1){
            return N;
        }

        return fib1(N-1) + fib1(N-2);
    }


    //执行用时	内存消耗
    //1 ms	    33.8 MB
    public static int fib2(int N) {
        if(N == 0 || N == 1){
            return N;
        }

        int[] data = new int[N+1];
        data[0] = 0;
        data[1] = 1;
        for(int i = 2; i <= N; i++){
            data[i] = data[i-1] + data[i-2];
        }
        return data[N];
    }

    //尾递归
}
