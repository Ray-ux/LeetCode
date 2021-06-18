package stack;

import java.util.Stack;

/**
 * 有效的括号
 *
 * @author 张烈文
 */
public class ValidParentheses {
    public boolean isValid(String s) {


        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            }else if(c=='['){
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
