package linkedlist;

/**
 * @author 张烈文
 * @date 2021/10/1 21:14
 */
public class ListNode {
    public ListNode next;
    public  int val;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
