package linkedlist;

/**
 * 链表中倒数第K个节点
 *
 * @author 张烈文
 */
public class KthNodeFromEndLinkedList {
    public ListNode getKthFromEnd(ListNode head, int k) {
//        判断特殊情况
        if(head==null){
            return head;
        }
//        双指针
        ListNode fast = head, slow = head;
//        快指针先走k步
        while(k-->0){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        return slow;
    }
}
