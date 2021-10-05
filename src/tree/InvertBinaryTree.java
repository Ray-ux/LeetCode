package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 翻转二叉树
 * @author 张烈文
 */
public class InvertBinaryTree {

//    递归三部曲，要从宏观出发
//    1.找终止条件
//    2.该层级要做什么事
//    3，找返回值

    public TreeNode invertTree(TreeNode root) {
//        1.终止条件肯定是当前节点为空的时候啥
        if (root == null) {
            return root;
        }

//        2.该层级要做的事情实际就是将两个节点交换，从宏观上看一颗二叉树实际上就是根节点和左右子树
//          我们只需要把左右子子树交换即可， （一定不要去纠结于细枝末节）
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;
//        再递归
        invertTree(root.left);
        invertTree(root.right);
        return root;

    }

//    非递归利用层序遍历来翻转二叉树
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        while (!deque.isEmpty()) {
//            先获得当前节点
            TreeNode curNode = deque.removeFirst();
//            以下操作为交换两节点
            TreeNode rightNode = curNode.right;
            curNode.right = curNode.left;
            curNode.left = rightNode;
//            下面就是将节点加入队列中，操作和层序遍历一样
            if (curNode.left != null) {
                deque.addLast(curNode.left);
            }
            if (curNode.right != null) {
                deque.addLast(curNode.right);
            }
        }
        return root;
    }
}
