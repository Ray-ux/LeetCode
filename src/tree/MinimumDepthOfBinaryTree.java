package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 最小路径
 *
 * @author 张烈文
 */
public class MinimumDepthOfBinaryTree {

//    非递归解法，具体思路：层序遍历，当出现一个弹出的节点的左右子树为空时则返回当前深度，否则每遍历完一层深度就加一
    public int minDepth(TreeNode root) {
//      根节点为空则返回0
        if(root==null){
            return 0;
        }
//        深度初始值
        int depth = 1;
//        使用双端队列
        Deque<TreeNode> queue = new LinkedList();
        queue.addLast(root);

        while(!queue.isEmpty()){
//            当前层的节点数目
            int size = queue.size();
//            弹出当前层的所有节点
            while(size-->0){
                TreeNode cur = queue.removeFirst();
//                若当前节点的左右子树为空则返回深度
                if(cur.left==null&&cur.right==null){
                    return depth;
                }
//               向队列添加进左右子树
                if(cur.left!=null){
                    queue.addLast(cur.left);
                }
                if(cur.right!=null){
                    queue.addLast(cur.right);
                }
            }
//            一层循环完深度加一
            ++depth;
        }

        return depth;
    }


}
