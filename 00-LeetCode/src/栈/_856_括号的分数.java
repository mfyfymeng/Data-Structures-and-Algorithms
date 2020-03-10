package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/score-of-parentheses/
 */

public class _856_括号的分数 {
    public int scoreOfParentheses(String S) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char c : S.toCharArray()) {
            if (c == '(')
                stack.push(0);
            else {
                int v = stack.pop();
                int w = stack.pop();
                stack.push(w + Math.max(2 * v, 1));
            }
        }

        return stack.pop();
    }
}
