package tree;

/**
 * 平衡二叉树
 * @author 张烈文
 */
public class BalancedBinaryTree {

//    判断一棵树是BST等价于它的左右子树都是BST且俩子树高度差不超过1
//    因此我们创建一个类来包含当前树是否是BST和当前树的高度这两个信息

    class ReturnNode{
        int depth;
        boolean isB;
        public ReturnNode(int depth, boolean isB) {
            this.depth = depth;
            this.isB = isB;
        }
    }
    public boolean isBalanced(TreeNode root) {
        return isB(root).isB;
    }


    private ReturnNode isB(TreeNode node) {

        if (node == null) {
            return new ReturnNode(0, true);
        }
//        不平衡的情况由三种：左子树不平衡或者右子树不平衡，左树和右树差的绝对值大于1
        ReturnNode left = isB(node.left);
        ReturnNode right = isB(node.right);

        if (!left.isB || !right.isB) {
            return new ReturnNode(0, false);
        }
        if (Math.abs(left.depth - right.depth) > 1) {
            return new ReturnNode(0, false);
        }

//        不满足上述3种情况，说明平衡了，树的深度为左右俩子树最大深度
        return new ReturnNode(Math.max(left.depth, right.depth) + 1, true);

    }


}
