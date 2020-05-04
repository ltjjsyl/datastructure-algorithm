package chuxiao.algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 *  给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 在杨辉三角中，每个数是它左上方和右上方的数的和。
 *
 * 示例:
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 *
 * */
public class 杨辉三角118 {
    public static void main(String[] args) {
        System.out.println(generate(10));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1; i <= numRows; i++){
            List<Integer> rowData = new ArrayList<>();
            if(res.isEmpty()){
                rowData.add(1);
            }else {
                List<Integer> lastRowData = res.get(i-2);
                for(int j = 0; j < i; j++){
                    if(j == 0 || j == i - 1){
                        rowData.add(1);
                    }else {
                        rowData.add(lastRowData.get(j)+lastRowData.get(j-1));
                    }
                }
            }
            res.add(rowData);
        }

        return res;
    }
}
