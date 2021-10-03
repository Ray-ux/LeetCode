package stack;

import java.util.Stack;

/**
 * 逆波兰表达式
 *
 * @author 张烈文
 * @date 2021/10/3 19:59
 */
public class EvaluateReversePolishNotation {

    /**
     * 思路：遇到数字将则将数字放入栈中，遇到运算符号则取出栈顶的两个元素进行运算并得出结果后放入栈中
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            char c = token.charAt(0);
//            执行的加减运算都应该是栈顶的第二个元素运算第一个元素
            if (!isOpe(token)) {
                stack.push(Integer.valueOf(token));
            } else if (c == '+') {
                stack.push(stack.pop() + stack.pop());
            } else if (c == '*') {
                stack.push(stack.pop() * stack.pop());
            } else if (c == '-') {
                stack.push(-stack.pop() + stack.pop());
            }else{
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2 / num1);
            }
        }
        return stack.pop();
    }


    /**
     * 该函数用于判断当前字符串是否是运算符
     * @param c
     * @return
     */
    private boolean isOpe(String c) {
        return c.length() == 1 && c.charAt(0) < '0' || c.charAt(0) > '9';
    }
}
