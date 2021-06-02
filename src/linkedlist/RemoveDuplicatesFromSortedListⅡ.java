package linkedlist;

/**
 * 删除排序链表中的重复元素Ⅱ
 * @author 张烈文
 */
public class RemoveDuplicatesFromSortedListⅡ {

    /**
     * 思路一:一次遍历,开辟虚拟头节点
     * 思路二:用hash记录次数,然后排序,重新构建链表,但时间复杂度较高
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummyHead=new ListNode(0,head);
        ListNode cur=dummyHead;
//        需要保证cur.next与cur.next.next!=null
        while(cur.next!=null&&cur.next.next!=null){
            if(cur.next.val==cur.next.next.val){
                int x=cur.next.val;
//                去重后将当前节点指向没有重复元素的下一个节点
                while(cur.next!=null&&cur.next.val==x){
                    cur.next=cur.next.next;
                }
            }else{
                cur=cur.next;
            }
        }
        return dummyHead.next;
    }
}
