package tree;

import java.util.HashMap;

/**
 * 从前序与中序遍历序列构造二叉树
 *
 * 具体思路：由于先序遍历的遍历次序是：中左右，因此当我们递归到先序序列中每一个节点时都用当前元素来构造节点，
 * 由于当前节点已被用过因此需要将index指针向后移动一位
 * @author 张烈文
 */
public class ConstructBinaryTreeFromPreOrderandInOrder {

    //    记录中序遍历中元素预期对应的下标

    HashMap<Integer, Integer> map = new HashMap();
    //    保存先序遍历序列

    int[] pre;
    //    用该指针指向先序序列中当前需要构造节点的元素

    int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        将中序序列中的元素及下标存入map中
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        pre = preorder;
        return builder(0, inorder.length - 1);
    }
//    具体思路：[is,ri-1]代表左子树，[ri+1,ie]代表右子树。ri代表当前节点再中序序列中的位置

    private TreeNode builder(int is,int ie){
        if(ie<is){
            return null;
        }
//        当取出一个节点时，index向后移动一位
        int root=pre[index++];
        int ri=map.get(root);
        TreeNode node = new TreeNode(root);
//        构造左子树
        node.left = builder(is, ri - 1);
//        构造右子树
        node.right = builder(ri + 1, ie);
        return node;
    }
}
