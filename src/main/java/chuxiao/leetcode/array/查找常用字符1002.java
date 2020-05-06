package chuxiao.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定仅有小写字母组成的字符串数组A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
 * 例如，如果一个字符在每个字符串中出现3次，但不是4次，则需要在最终答案中包含该字符3次。
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 *
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 *
 * */
public class 查找常用字符1002 {
    public static void main(String[] args) {
        String [] in = {"cool","lock","cook"};
        System.out.println(commonChars(in));
    }

    public static List<String> commonChars(String[] A) {
        int len = A.length;
        int[][] stat = new int [26][len];

        for(int i = 0; i < len; i++){
            for(int j = 0; j < A[i].length(); j++){
                stat[A[i].charAt(j) - 'a'][i]++;
            }
        }

        List<String> res = new ArrayList<>();
        for(char k = 0; k < 26; k++){
            int min = Integer.MAX_VALUE;
            for(int m = 0; m < len; m++){
                if(stat[k][m] < min){
                    min = stat[k][m];
                }
            }
            for(int i = 0; i < min; i++){
                res.add(Character.toString((char) (k + 'a')));
            }
        }

        return  res;
    }


}
