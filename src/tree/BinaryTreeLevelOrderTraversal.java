package tree;

import java.util.*;

/**
 * 二叉树的层序遍历
 * @author 张烈文
 */
public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> queue = new LinkedList<>();
//        将首节点添加到队尾
        queue.addLast(root);
        while (!queue.isEmpty()) {
//            当前层有几个几点
            int size = queue.size();
            List<Integer> inner = new ArrayList<>();
//            出队size个元素
            for (int i = 0; i < size; i++) {
//                移除队首元素
                TreeNode node = queue.removeFirst();
                inner.add(node.val);
                if (node.left != null) {
                    queue.addLast(node.left);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
            }
//            一层结束后加入结果集
            res.add(inner);

        }
        return res;
    }
}
