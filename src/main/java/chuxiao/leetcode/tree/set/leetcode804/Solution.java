package chuxiao.leetcode.tree.set.leetcode804;

import java.util.Set;
import java.util.TreeSet;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codeTables = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};

        Set<String> res = new TreeSet<>();//使用HashSet也可以，或者说更好
        for (String word : words) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                sb.append(codeTables[word.charAt(i) - 'a']);
            }
            res.add(sb.toString());
        }

        return res.size();
    }
}
