package linkedlist;

/**
 * @author 张烈文
 */
public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {

//        开辟一个虚拟头节点
        ListNode dummyHead = new ListNode();
        dummyHead.next=head;
//        快指针指向head
        ListNode fast = head;
//        slow指针指向虚拟头节点
        ListNode slow = dummyHead;
//        快指针先走n步
        while (n-- > 0) {
            fast = fast.next;
        }
//        两个指针一起走
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummyHead.next;
    }
}
