package linkedlist;

/**
 * @author 张烈文
 */
public class ReverseNodesInKgroup {

    public ListNode<Integer> reverseKGroup(ListNode<Integer> head, int k) {
//        如果仅存一个节点或者不存在节点就直接返回
        if (head == null || head.next == null) {
            return head;
        }
//        用来保存反转之后的链表
        ListNode<Integer> res = new ListNode<>();
        ListNode cur = res;
        ListNode lenNode = head;
//        求链表长度
        int len = getLength(lenNode);

//        len/k旨在算出一共要进行多少次的翻转
        for (int i = 0; i < len / k; i++) {
            int num = k;
//         这里利用反转链表的非递归方式来实现反转
            ListNode pre = null;
            while (num-- > 0) {
                ListNode nextNode = head.next;
                head.next = pre;
                pre = head;
                head = nextNode;
            }

//            将当前翻转好的一组，加入到结果链表中
            while (pre != null) {
                cur.next = pre;
                pre = pre.next;
                cur = cur.next;
            }
        }
//        当不够进行翻转的节点加入到结果链表后(len-k*(len/k))
        cur.next = head;
        return res.next;

    }

    private int getLength(ListNode lenNode) {
        int count = 0;
        while (lenNode != null) {
            ++count;
            lenNode = lenNode.next;
        }
        return count;
    }
}
