package linkedlist;

import java.util.PriorityQueue;

/**
 * @author 张烈文
 */
public class MergekSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>(((o1, o2) -> o1.val - o2.val));

//        遍历数组，将数组该位置的所在的链表头节点加入队列中
        for (ListNode node : lists) {
//            若头节点不为空，则加入进去
            if (node != null) {
                pq.offer(node);
            }
        }
        ListNode dummyHead = new ListNode();
        ListNode cur = dummyHead;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            cur.next = minNode;
            cur = cur.next;
//            如果当前最小节点还有下一个节点则将其加入队列中，由于是最小优先队列，如加入的节点比对立里的节点还小，那么下一次出队就是该当前加入的节点
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        return dummyHead.next;

    }
}
