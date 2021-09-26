package linkedlist;

/**
 * @author 张烈文
 */
public class ReorderList {

//   自己的思路: 求长度，递归,效率较低

    public void reorderList(ListNode head) {
        ListNode dummyHead = head, cur = head;
        int len = getLen(dummyHead);
//        如果当前链表长度小于3则返回
        if (len < 3) {
            return;
        }
//       将链表走到倒数第二个节点
        while (len-- > 2) {
            cur = cur.next;
        }
//        将最后一个节点指向头节点的下一个节点
        cur.next.next = head.next;
//        将头节点的next指向最后一个节点,相当于将其形成环状
        head.next = cur.next;
//        解除环状,将倒数第二个节点的next指向null
        cur.next = null;

//        递归进行
        reorderList(head.next.next);
    }

    private int getLen(ListNode head) {
        int len = 0;
        while (head != null) {
            ++len;
            head = head.next;
        }
        return len;
    }

//    先寻找链表的中点,然后将右边部分的链表翻转,最后在合并链表即可
    public void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode mid = middleNode(head);
        ListNode l1 = head;
        ListNode l2 = mid.next;
        mid.next = null;
        l2 = reverseList(l2);
        mergeList(l1, l2);
    }

    private void mergeList(ListNode l1, ListNode l2) {

        while (l1 != null && l2 != null) {
            ListNode tmp1 = l1.next;
            ListNode tmp2 = l2.next;
            l1.next = l2;
            l1=tmp1;
            l2.next=l1;
            l2=tmp2;
        }


    }


    //    反转链表
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur=  reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return cur;
    }

    //   寻找链表中间节点
    private ListNode middleNode(ListNode head) {

        ListNode slow = head, fast = head;
        while (slow != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
