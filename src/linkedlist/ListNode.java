package linkedlist;

/**
 * 链表节点
 * @author 张烈文
 */
public class ListNode {
    public ListNode next;
    public  int val;

    ListNode() {

    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}
