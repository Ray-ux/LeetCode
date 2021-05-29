package tree;

/**
 * 合并二叉树
 * @author 张烈文
 */
public class MergeTwoBinaryTrees {

//    递归三部曲：
//    1.找递归终止条件
//    2.看当前这一级要做什么
//    3.找返回值

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
//        当两个节点都为空时则终止合并
        if (root1 == null && root2 == null) {
            return null;
        }
        int curSum = 0;
        if (root1 == null) {
            curSum = root2.val;
        } else if (root2 == null) {
            curSum = root1.val;
        } else {
            curSum = root2.val + root1.val;
        }
        TreeNode node = new TreeNode(curSum);
//        这里要注意判断一下当前接节点是否为空，不然可能会出现空指针
        node.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        node.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return node;
    }
}
