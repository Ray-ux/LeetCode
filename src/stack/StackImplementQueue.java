package stack;

import java.util.Stack;

/**
 * 栈实现队列
 * 两个栈实现队列：将其中一个栈中的元素移到另一个栈中，就让先进后出的顺序变了回来即先进后出
 * @author 张烈文
 * @date 2021/10/2 15:10
 */
public class StackImplementQueue {

    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public StackImplementQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        dumpStack1();
        return stack2.pop();
    }


    public int peek() {
        dumpStack1();
        return stack2.peek();
    }

    public boolean isEmpty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }
    private void dumpStack1() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }


}
