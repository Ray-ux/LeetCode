package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 统计普通二叉树的节点个数
 *
 * @author 张烈文
 * @date 2021/10/5 19:59
 */
public class NomalTreeNodeNums {

    /**
     * 递归大致思路：统计左右字数的节点数最后在加上本身就可以啦
     * @param root
     * @return
     */
    public int count(TreeNode root) {
        return getNums(root);
    }

    private int getNums(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftNums = getNums(root.left); //左

        int rightNums = getNums(root.right); //右
        return leftNums + rightNums + 1;
    }

    /**
     * 思路二：利用层序遍历统计，没弹出一个节点就+1
     * @param root
     * @return
     */
    public int count1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        int count = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0) {
                TreeNode topNode = deque.removeFirst();
                count++;
                if (topNode.left != null) {
                    deque.addLast(topNode.left);
                }
                if (topNode.right != null) {
                    deque.addLast(topNode.right);
                }
            }
        }
        return count;
    }
}
