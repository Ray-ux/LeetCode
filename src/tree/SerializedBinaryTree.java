package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 序列化二叉树
 *
 * @author 张烈文
 */
public class SerializedBinaryTree {


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
//      若根节点为空直接返回
        if (root == null) {
            return "[]";
        }
        StringBuilder res = new StringBuilder("[");
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode tmp = deque.removeFirst();
            if (tmp != null) {
                res.append(tmp.val + ",");
                deque.add(tmp.left);
                deque.add(tmp.right);
            }else{
                res.append("null,");
            }
        }

//        删除最后一个,
        res.deleteCharAt(res.length() - 1);
        res.append("]");
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public  TreeNode deserialize(String data) {
        if (data.equals("[]")){
            return null;
        }
//        去掉[]，并已","为分隔符为一个字符串数组
        String[] vals=data.substring(1,data.length()-1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
//        初始化一个i来控制当前的位置
        int i = 1;
        while (!deque.isEmpty()) {
//            层序遍历构造二叉树
            TreeNode node = deque.removeFirst();
            if (!vals[i].equals("null")) {
                node.left = new TreeNode(Integer.parseInt(vals[i]));
//                这里将添加好的左节点加入队列中
                deque.offer(node.left);
            }
//            位置向后移动一位
            i++;
            if (!vals[i].equals("null")) {
                node.right = new TreeNode(Integer.parseInt(vals[i]));
                deque.offer(node.right);
            }
//            位置向后移动一位
            i++;
        }
        return root;
    }
}
