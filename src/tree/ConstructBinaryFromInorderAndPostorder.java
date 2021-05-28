package tree;

import java.util.HashMap;

/**
 * 从中序与后序遍历序列构造二叉树
 *
 * @author 张烈文
 */
public class ConstructBinaryFromInorderAndPostorder {
    int[] post;
    HashMap<Integer, Integer> memory;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            memory.put(inorder[i], i);
        }
        post = postorder;
        return builder(0, inorder.length - 1, 0, postorder.length - 1);
    }

    private TreeNode builder(int is, int ie, int ps, int pe) {

//        递归终止条件
        if (is > ie || ps > pe) {
            return null;
        }
//        获取根节点
        int root = post[pe];
//        从中序序列中获取该根节点的下标
        int ri = memory.get(root);
//        构造根节点
        TreeNode node = new TreeNode(root);
//        构造左子树，中序遍历序列的左子树为[is,ri-1],后序遍历的区间为[ps,ps+ri-is-1]
        node.left = builder(is, ri - 1, ps, ps + ri - is - 1);
//        构造右子树，中序遍历序列的右子树为[ri-1,ie],后序遍历的区间为[ps+ri-is,pe-1]
        node.right = builder(ri + 1, ie, ps + ri - is, pe-1);
        return node;
    }
}
