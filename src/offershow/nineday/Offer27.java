package offershow.nineday;



import linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 回文链表
 * @author 张烈文
 * @date 2021/9/26 11:14
 */
public class Offer27 {

    /**
     * 思路一：转换为数组，然后双指针
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        List<Integer> temp = new ArrayList<>();
        while (head != null) {
            temp.add(head.val);
            head = head.next;
        }
        int start = 0, end = temp.size()-1;
        while (start <= end) {
            if (!temp.get(start).equals(temp.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * 对链表反转
     * @param head
     * @return
     */
    public  boolean isPalindrome1(ListNode head) {
        ListNode mid = findMid(head);
        ListNode l1 = head;
        ListNode l2 = reverse(mid.next);
        mid.next = null;
        while (l1!=null&&l2 != null) {
            if (l1.val != l2.val) {
                return false;
            }
            l1 = l1.next;
            l2 = l2.next;
        }
        return true;
    }

    /**
     * 寻找中点采用新建虚拟节点的方式进行，这种方式适用于节点个数奇偶数的情况
     *
     * 但是如果不采用虚拟节点的方式，仅适用于奇数节点的情形
     * @param head
     * @return
     */
    private ListNode findMid(ListNode head) {
        ListNode fast = new ListNode(0);
        ListNode slow = fast;
        fast.next = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private  ListNode reverse(ListNode temp) {
        ListNode pre = null;
        ListNode cur = temp;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nextNode;
        }
        return pre;
    }


}
