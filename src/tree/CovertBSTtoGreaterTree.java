package tree;

/**
 * 把二叉搜索树转换为累加树
 *
 * @author 张烈文
 */
public class CovertBSTtoGreaterTree {

    /**'
     * 反序中序遍历 ：右中左，并且用一个sum来记录节点值的和，并且不断更新当前遍历的节点的节点值
     */
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if (root != null) {

            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }

}
