package tree;

import java.util.*;
/**
 * 二叉树的先序遍历
 * @author 张烈文
 */
public class BinaryTreePreorderTraversal {

//    非递归前序遍历

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
//        创建一个栈
        Stack<TreeNode> stack = new Stack<>();
//        将头节点推入到栈中
        stack.push(root);
        while (!stack.isEmpty()) {
//            弹出头节点
            TreeNode node = stack.pop();
//            添加进结果集中
            res.add(node.val);
//           由于是先序遍历，因此先将右节点推入栈
            if (node.right != null) {
                stack.push(node.right);

            }
//            再将左节点推入栈中，此时栈顶元素就是左节点，满足了先序遍历的条件
            if (node.left != null) {
                stack.push(node.left);

            }
        }
        return res;
    }

    //    递归
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode node) {
        if (node == null) {
            return;
        }
        res.add(node.val);
        if (node.left != null) {
            dfs(res, node.left);
        }
        if (node.right != null) {
            dfs(res, node.right);
        }

    }
}
