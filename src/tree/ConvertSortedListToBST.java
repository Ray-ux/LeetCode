package tree;



/**
 * 有序链表转换为二叉搜索树
 *
 * @author 张烈文
 */
public class ConvertSortedListToBST {

//    具体思路:相当于就是双指针
    public TreeNode sortedListToBST(ListNode<Integer> head) {
        return builder(head,null);
    }

    private TreeNode builder(ListNode left,ListNode right){
        if(left==right){
            return null;
        }
        ListNode midNode=getMidNode(left,right);
        TreeNode node=new TreeNode();
        node.left=builder(left,midNode);
        node.right=builder(midNode.next,right);
        return node;
    }

    private ListNode getMidNode(ListNode head,ListNode right){
        ListNode fast=head,slow=head;
        while(fast!=right&&fast.next!=right){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
