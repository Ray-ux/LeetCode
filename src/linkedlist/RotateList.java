package linkedlist;

/**
 * 旋转链表
 * @author 张烈文
 */
public class RotateList {

    /**
     * 以前实现代码：思路：本质上就是将尾部向前数k各元素作为头，原来头接到原来尾上
     * @param head
     * @param k
     * @return
     */
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

    /**
     * 对代码进行优化
     * @param head
     * @param k
     * @return
     */
    public ListNode rotateRight1(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        // 计算链表长度
        int len=getLen(head);
        ListNode fast=head,slow=head;
//        保存结果时的头节点
        ListNode res = null;
//        由于题目中未说k<len因此需要对其取余
        k=k%len;
        while(k-->0){
            fast=fast.next;
        }
//        当fast.next==null时则代表fast指针已经到了链表尾部
//        此时slow处于倒数第k各节点位置
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
//        将链表尾部.next指向链表头部，这里相当于就形成了环形
        fast.next=head;
//        保存结果的头节点
        res=slow.next;
//        去掉环
        slow.next=null;
        return res;
    }

    private int getLen(ListNode head){
        int count=0;
        while(head!=null){
            count++;
            head=head.next;
        }
        return count;
    }
}
