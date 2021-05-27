package tree;

/**
 * 左叶子节点之和
 * @author 张烈文
 */
public class SumOfLeftLeaves {

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
}
