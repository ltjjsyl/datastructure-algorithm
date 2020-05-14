package chuxiao.datastructure.linear.list.recursive;

public class Sum {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        System.out.println(new Sum().sum(nums));
    }

    public int sum(int[] arr) {
        return sum(arr, 0);
    }

    public int sum(int[] arr, int l) {

        if (l == arr.length) {
            return 0;
        }

        return arr[l] + sum(arr, l + 1);
    }
}
