package stack;

import java.util.Stack;

/**
 * 栈的压入，弹出序列
 *
 * @author 张烈文
 * @date 2021/10/10 21:18
 */
public class StackPushAndPopOrder {

    /**
     * 思路：将pushed中的元素加入栈中，若栈不为空且栈顶元素等于popped[i]的元素则弹出且i++
     * 直到不等于再向栈中加入新的元素，最后判断栈是否为空即可
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();

    }
}
