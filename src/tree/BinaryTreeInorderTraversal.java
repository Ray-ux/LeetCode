package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 * @author 张烈文
 */
public class BinaryTreeInorderTraversal {

//    递归
    public List<Integer> inorderTraversal(TreeNode root) {

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
        res.add(node.val);
        if (node.right!=null) {
            dfs(res, node.right);
        }
    }

    //    非递归
    public List<Integer> inorderTraversal1(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }else{
                TreeNode tmp = stack.pop();
                res.add(tmp.val);
                cur = tmp.right;
            }
        }
        return res;
    }
}
