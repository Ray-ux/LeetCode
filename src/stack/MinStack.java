package stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 最小栈
 *
 * @author 张烈文
 */
public class MinStack {

class StackWay1 {
    /**
     * 思路1；自定义一个栈，时间复杂度为O(n)
     */
    private Integer capacity = 10;
    private Integer[] stack = null;
    private Integer top = -1;
    private final Integer addNum = 2;

    /**
     * initialize your data structure here.
     */
    public StackWay1() {
        stack = new Integer[capacity];
    }

    public void push(int val) {
        if ((top + 1) >= capacity) {
            capacity = capacity + addNum;
            stack = Arrays.copyOf(stack, capacity);
        }
        stack[++top] = val;
    }

    public void pop() {
        if (top > -1) {
            top--;
        }
    }

    public int top() {
        return top > -1 ? stack[top] : -1;
    }

    public int getMin() {
        if (top > -1) {
            int min = stack[top];
            int tmp = top;
            while (tmp > -1) {
                if (stack[tmp] < min) {
                    min = stack[tmp];
                }
                tmp--;
            }
            return min;
        }
        return -1;
    }
}

    /**
     * 两个栈，一个记录栈中最小值，一个记录所有元素
     */
    class StackWay2 {
        Deque<Integer> xStack;
        Deque<Integer> minStack;

        public StackWay2() {
            xStack = new LinkedList<Integer>();
            minStack = new LinkedList<Integer>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int x) {
            xStack.push(x);
            minStack.push(Math.min(minStack.peek(), x));
        }

        public void pop() {
            xStack.pop();
            minStack.pop();
        }

        public int top() {
            return xStack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }



}
