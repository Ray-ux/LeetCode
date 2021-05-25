package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 对称二叉树
 * @author 张烈文
 */
public class SymmetricTree {

//    递归解法
//    具体思路:左子树的左孩子与右子树的右孩子比较，左子树的右孩子与右子树的左子树比较
    public boolean isSymmetric(TreeNode root) {

        if (root == null) {
            return true;
        }
       return dfs(root.left, root.right);
    }

    private boolean dfs(TreeNode left, TreeNode right) {
//        递归的终止条件是两个节点都为空
//        或者两个节点中有一个为空
//        或者两个节点的值不相等
        if (left==null&&right==null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
//        在递归的比较左节点的左孩子和右节点的右孩子
//        以及比较左节点的右孩子和右节点的左孩子
        return dfs(left.left, right.right) && dfs(left.right, right.left);

    }

//    非递归方式一
    public boolean isSymmetric1(TreeNode root) {
        if(root==null||(root.left==null&&root.right==null)){
            return true;
        }
//        队列保存节点
        Deque<TreeNode> queue = new LinkedList<>();
//        将根节点的左右子树加入队列
        queue.addLast(root.left);
        queue.addLast(root.right);
        while (!queue.isEmpty()) {
//            弹出左子树左节点
            TreeNode left = queue.removeFirst();
//            弹出右子树右节点
            TreeNode right = queue.removeFirst();
//            当左右节点都为空时则继续循环，如果有一个为空就返回false
            if (left == null && right == null) {
                continue;
            }
            if (left == null || right == null) {
                return false;
            }
//            若左右节点不相等则返回false
            if (left.val != right.val) {
                return false;
            }
//            与递归的思路一样，将左子树的左节点加入队尾
            queue.addLast(left.left);
//            将右子树的右节点加入队尾
            queue.addLast(right.right);
//            将左子树的右节点加入队尾
            queue.addLast(left.right);
//            将右子树的左节点加入队尾
            queue.addLast(right.left);
        }
        return true;
    }
}
