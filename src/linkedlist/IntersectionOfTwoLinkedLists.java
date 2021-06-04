package linkedlist;

/**
 * 相交链表
 *
 * @author 张烈文
 */
public class IntersectionOfTwoLinkedLists {
    /**
     * 两个链表速度一致，走过的路程一致，那么肯定会同一个时间点到达终点
     * 如果到达终点的最后一段两人都走的话，那么这段路上两人携手共进           ----LeetCode 评论
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A == null ? headB : A.next;
            B = B == null ? headA : B.next;
        }
        return A;
    }
}
