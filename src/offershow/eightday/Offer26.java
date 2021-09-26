package offershow.eightday;

import linkedlist.ListNode;

/**
 * 重排链表
 *
 * @author 张烈文
 * @date 2021/9/25 13:47
 */
public class Offer26 {

    /**
     * 先寻找链表中点，然后再将右边部分反转，最后合并
     * @param head
     */
    public void reorderList(ListNode head) {
        ListNode mid = findMidNode(head);
        ListNode l1 = head;
        ListNode l2 = reverseList(mid.next);
//       由于我们是在同一个链表上操作的，因此我们应该在找到中间节点及反转右边部分后，将mid.next置为null
//        要不然在后续的操作会造成死循环
        mid.next = null;
        mergeList(l1, l2);
    }

    private void mergeList(ListNode l1, ListNode l2) {
        while (l2 != null) {
            ListNode temp1 = l1.next;
            ListNode temp2 = l2.next;
//            l1.next = l2;
//            l1 = temp1;
//            l2.next = temp1;
//            l2 = temp2;
            l1.next = l2;
            l1 = l1.next;
            l1.next = temp1;
            l1 = temp1;
            l2 = temp2;
        }
        l1.next = null;
    }

    /**
     * 反转右边部分的链表
     * @param midRight
     * @return
     */
    private ListNode reverseList(ListNode midRight) {
        ListNode cur = midRight;
        ListNode pre = null;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }

    /**
     * 寻找链表中点
     * @param head
     * @return
     */
    private ListNode findMidNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
