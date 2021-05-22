package linkedlist;

/**
 * @author 张烈文
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
//        判断为空直接返回
        if(head==null||head.next==null||k==0){
            return head;
        }
//        双指针
        ListNode fast=head,slow=head;
        ListNode dummyhead=head;
        ListNode res;
//        获取链表长度
        int len = getListLen(head);
//        快指针要先往后移动几步
        k=k%len;
        while(k>0){
            fast=fast.next;
            k--;
        }
//        slow和fast一起向后移动，直到fast.next==null
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
//        将fast.next指向头节点，实际上就是形成环状
        fast.next=dummyhead;
//        slow.next的赋值给res
        res=slow.next;
//        断开之前形成的环状
        slow.next=null;
        return res;

    }

    private int getListLen(ListNode head){
        int count=0;
        while(head!=null){
            head=head.next;
            count++;
        }
        return count;
    }
}
