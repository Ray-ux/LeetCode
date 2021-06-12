package tree;

/**
 * 删除二叉搜索树中的节点
 *
 * @author 张烈文
 */
public class DeleteNodeInABST {
    public TreeNode deleteNode(TreeNode root, int key) {

        return remove(root, key);
    }

    private TreeNode remove(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (key < root.val) {
            root.left = remove(root.left, key);
        } else if (key > root.val) {
            root.right = remove(root.right, key);
        }else{
//            待删除节点的左子树为空的时候
            if (root.left == null) {
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            }
            if (root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            }
//            待删除节点左右子树都不为空的情况，
//            找到比待删除节点大的最小节点，即待删除节点右子树的最小节点
//            用这个节点顶替删除节点的位置
            TreeNode successor = minimum(root.right);    //此处代表找到当前节点右子树中最小节点，当前节点的后继
            successor.right = removeMin(root.right);  //后继节点的右子树
            successor.left = root.left; //后继节点的左子树就等于原来节点的左子树
            root.left = root.right = null;  //当前节点左右子树为空，以便于虚拟机回收
            return successor;

        }
        return root;
    }

    private TreeNode removeMin(TreeNode node) {
        if (node.left == null) {
            TreeNode rightNode = node.right;
            node.right = null;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    private TreeNode minimum(TreeNode node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
    }
}
