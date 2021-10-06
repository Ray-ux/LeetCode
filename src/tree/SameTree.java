package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 相同的树
 *
 * @author 张烈文
 * @date 2021/10/6 19:45
 */
public class SameTree {


    /**
     *递归解法
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree1(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree1(p.left, q.left) && isSameTree1(p.right, q.right);
    }
    /**
     * 迭代方法：利用层序遍历
     *
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        Deque<TreeNode> queue1 = new LinkedList();
        Deque<TreeNode> queue2 = new LinkedList();
        queue1.addLast(p);
        queue2.addLast(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int size1 = queue1.size();
            int size2 = queue2.size();
            if (size1 != size2) {
                return false;
            }
            while (size1-- > 0) {
                TreeNode node1 = queue1.removeFirst();
                TreeNode node2 = queue2.removeFirst();
                if (node1 == null && node2 == null) {
                    continue;
                }
                if (node1 == null || node2 == null) {
                    return false;
                }
                if (node1.val != node2.val) {
                    return false;
                }
                queue1.addLast(node1.left);
                queue1.addLast(node1.right);
                queue2.addLast(node2.left);
                queue2.addLast(node2.right);
            }
        }
        return true;
    }
}
