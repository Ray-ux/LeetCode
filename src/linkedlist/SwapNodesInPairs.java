package linkedlist;

/**
 * @author 张烈文
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        // 头节点的下一个节点
        ListNode nextNode=head.next;
        // 将头节点next指向nextNode的下一个节点
        head.next=nextNode.next;
        // 最后将nextNode.next指向head即可
        nextNode.next=head;
        // 一对交换之后的后一个节点的next指向下一对交换之后的前一个节点
        head.next=swapPairs(head.next);
        // 返回两个节点交换之后的头节点
        return nextNode;

    }
}
