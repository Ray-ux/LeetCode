package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 * @author 张烈文
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root==null) {
            return res;
        }
        StringBuilder path = new StringBuilder();
        dfs(path, res, root);
        return res;

    }

    private void dfs(StringBuilder path, List<String> res, TreeNode node) {
//      递归终止条件
        if (node==null) {
            return;
        }
//        当前节点无左子树且无右子树时，则将其添加到结果集中
        if (node.left == null && node.right == null) {
            res.add(path.toString() + node.val);
        }

        int size = path.length();
        path.append(node.val).append("->");
        dfs(path, res, node.left);
        dfs(path ,res, node.right);
//        回溯
        path.delete(size, path.length());

    }

}
