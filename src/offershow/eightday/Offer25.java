package offershow.eightday;

import linkedlist.ListNode;

/**
 * 链表相加
 *
 * @author 张烈文
 * @date 2021/9/25 13:21
 */
public class Offer25 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reverseL1 = reverseList(l1);
        ListNode reverseL2 = reverseList(l2);
        ListNode res = new ListNode();
        ListNode cur = res;
        int temp = 0;
        while (reverseL1 != null || reverseL2 != null) {
            int num1 = reverseL1 == null ? 0 : reverseL1.val;
            int num2 = reverseL2 == null ? 0 : reverseL2.val;
            int sum = num1 + num2 + temp;
            int d = sum % 10;
            temp = sum / 10;
            cur.next = new ListNode(d);
            cur = cur.next;
            if (reverseL1 != null) {
                reverseL1 = reverseL1.next;
            }
            if (reverseL2 != null) {
                reverseL2 = reverseL2.next;
            }
        }
        if (temp == 1) {
            cur.next = new ListNode(1);
        }
        return reverseList(res.next);
    }
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }
}
