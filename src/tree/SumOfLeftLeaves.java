package tree;

import java.util.Stack;

/**
 * 左叶子节点之和
 * @author 张烈文
 */
public class SumOfLeftLeaves {


    /**
     * 递归方式，确定左叶子节点：左节点不为空，且左节点无左右孩子
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int res = 0;
//        判断当前节点的左节点是否为叶子节点，如果是则将左叶子节点赋值给临时变量
        if (root.left != null && root.left.left == null && root.left.right == null) {
            res = root.left.val;
        }
        return res + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }


    /**
     * 迭代方式，重点注意一下判断左叶子节点的逻辑
     * @param root
     * @return
     */
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int result = 0;
        while (!stack.isEmpty()) {
            TreeNode top = stack.pop();
            if (top.left != null && top.left.left == null && top.right.right == null) {
                result += top.left.val;
            }
            if (top.right != null) {
                stack.push(top.right);
            }
            if (top.left != null) {
                stack.push(top.left);
            }
        }
        return result;
    }
}
