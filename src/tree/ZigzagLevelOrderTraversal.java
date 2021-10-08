package tree;

import java.util.*;

/**
 * 二叉树的锯齿形层序遍历
 * @author 张烈文
 * @date 2021/10/8 13:29
 */
public class ZigzagLevelOrderTraversal {


    /**
     * 通过一个isOrderLeft变量来控制在deque的哪一头加入元素，其余实际和层序遍历一致
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> queue=new LinkedList();
        boolean isOrderLeft=true;
        queue.add(root);
        while(!queue.isEmpty()){
            int size=queue.size();
            Deque<Integer> in=new LinkedList();
            for(int i=0;i<size;i++){
                TreeNode tmp=queue.poll();
                if(isOrderLeft){
                    in.offerLast(tmp.val);
                }else{
                    in.offerFirst(tmp.val);
                }
                if(tmp.left!=null){
                    queue.add(tmp.left);
                }
                if(tmp.right!=null){
                    queue.add(tmp.right);
                }
            }

            res.add(new ArrayList(in));
            isOrderLeft=!isOrderLeft;
        }
        return res;
    }
}
