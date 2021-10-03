package stack;

import com.sun.java.swing.plaf.windows.WindowsTextAreaUI;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 队列实现栈
 *
 * @author 张烈文
 * @date 2021/10/2 15:23
 */
public class QueueImplementStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public QueueImplementStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.offer(x);
        // 将queue2队列中元素全部转给queue1队列
        while (!queue2.isEmpty()) {
            queue1.offer(queue2.poll());
        }
        // 交换queue1和queue2,使得queue1队列没有在push()的时候始终为空队列
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
       return queue2.poll();
    }

    public int top() {
        return queue2.peek();
    }

    public boolean empty() {
        return queue2.isEmpty();
    }
}
