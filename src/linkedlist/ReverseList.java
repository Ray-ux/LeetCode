package linkedlist;

/**
 * @author 张烈文
 */
public class ReverseList {

//    方式一：非递归实现链表反转
    public ListNode reverseListNoRecur(ListNode head) {
        ListNode pre=null;
        ListNode cur=head;
        while(cur!=null){
            ListNode nextNode=cur.next;
            cur.next=pre;
            pre=cur;
            cur=nextNode;
        }
        return pre;
    }

    //    方式二：递归巧妙
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = reverseList(head.next);
//        先将head与head.next两个节点形成环状，然后在将head的next指向为null解开环状
        head.next.next = head;
//        解开环状达到以达到反转
        head.next = null;
        return cur;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode cur = head;
        int i = 2;
        while (i < 6) {
            cur.next = new ListNode(i++);
            cur = cur.next;
        }
        reverseList(head);
    }
}
