package tree;

/**
 * 验证二叉搜索树
 *
 * 中序遍历是有序的,因此只需要考虑当前节点是否大于前一个节点,若大于则true,否则false
 * @author 张烈文
 */
public class ValidateBinarySearchTree {


    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {

        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= pre) {
            return false;
        }
        pre=root.val;
        return isValidBST(root.right);
    }


}
