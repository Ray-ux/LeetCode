package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度，递归与非递归
 * @author 张烈文
 */
public class MaximumDepthOfBinaryTree {

//    递归方式
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax,rightMax)+1;
    }

//    非递归，使用层序遍历,每一次内循环你结束对深度加一
    public int maxDepthNoRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode tmp = queue.removeFirst();
                ++depth;
                if (tmp.left != null) {
                    queue.addLast(tmp.left);
                }
                if (tmp.right != null) {
                    queue.addLast(tmp.right);
                }
            }
        }
        return depth;
    }

}
