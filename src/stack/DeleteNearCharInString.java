package stack;

import java.util.Stack;

/**
 * 删除字符串中的所有相邻重复项
 * @author 张烈文
 * @date 2021/10/3 15:44
 */
public class DeleteNearCharInString {
    /**
     * 用当前栈顶元素与当前元素匹配：
     * 1.若相等则弹出栈顶元素
     * 2.若不相等则将当前元素放入栈中
     * @param s
     * @return
     */
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peek() != s.charAt(i)) {
                stack.push(s.charAt(i));
            }else{
                stack.pop();
            }
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.reverse().toString();
    }
}
