package linkedlist;

/**
 * 链表节点
 * @author 张烈文
 */
public class ListNode<T> {
     ListNode next;
     T data;

    ListNode() {

    }

    ListNode(T data) {
        this.data = data;
    }

    ListNode(T data, ListNode next) {
        this.data = data;
        this.next = next;
    }


}
