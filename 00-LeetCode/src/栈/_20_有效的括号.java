package 栈;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */

public class _20_有效的括号 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            else {
                if (stack.isEmpty()) return false;

                char left = stack.pop();
                if (left == '(' && c != ')') return false;
                if (left == '[' && c != ']') return false;
                if (left == '{' && c != '}') return false;
            }
        }

        return stack.isEmpty();
    }

    public boolean isValid2(String s) {
        while (s.contains("{}") || s.contains("[]") || s.contains("()")) {
            s = s.replace("{}", "");
            s = s.replace("[]", "");
            s = s.replace("()", "");
        }
        return s.isEmpty();
    }
}
