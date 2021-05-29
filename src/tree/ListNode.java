package tree;

/**
 * 链表节点
 * @author 张烈文
 */
public class ListNode<T> {
     ListNode next;
     T val;

    ListNode() {

    }

    ListNode(T val) {
        this.val = val;
    }

    ListNode(T val, ListNode next) {
        this.val = val;
        this.next = next;
    }


}
