package niuke;

import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author 张烈文
 * @date 2021/9/19 14:43
 */
public class A3 {


    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Deque<Integer> deque = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        while (listNode != null) {
            deque.addLast(listNode.val);
            listNode = listNode.next;
        }
        while (!deque.isEmpty()) {
            res.add(deque.removeLast());
        }
        return res;
    }
}
