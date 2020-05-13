package chuxiao.leetcode.linear.stack.leetcode20;

import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character topChar = stack.pop();
                if (c == '}' && topChar != '{') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == ')' && topChar != '(') {
                    return false;
                }
            }

        }

        return stack.isEmpty();
    }
}
