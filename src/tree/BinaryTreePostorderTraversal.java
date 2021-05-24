package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的后序遍历 递归与非递归
 *
 * @author 张烈文
 */
public class BinaryTreePostorderTraversal {

    //    递归解法
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(res, root);
        return res;
    }

    private void dfs(List<Integer> res, TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            dfs(res, node.left);
        }
        if (node.right != null) {
            dfs(res, node.right);
        }
        res.add(node.val);

    }

    //    非递归
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;   //记录上一个节点

        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
//                查看栈顶元素
                cur = stack.peek();
//                判断当前节点的右子树是否为空或者当前节点的右子树是否等于上一个节点
                if (cur.right == null || cur.right==pre) {
                    res.add(cur.val);
                    pre = cur;
                    stack.pop();
                    cur = null;
                }else{
                    cur = cur.right;
                }
            }
        }
        return res;
    }
}
