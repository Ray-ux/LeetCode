package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 找树左下角的值
 * @author 张烈文
 */
public class FindBottomLeftTreeValue {

    //    非递归遍历，时间复杂度较高，待优化
    //    具体思路：层序遍历，先将每一层的节点都加入一个List中，一层结束后加入结果集中，最后取出最后一层的第一个节点即可

    public int findBottomLeftValue(TreeNode root) {

        if (root == null) {
            return 0;
        }
        Deque<TreeNode> deque = new LinkedList();
        List<List<Integer>> res = new ArrayList();
        deque.addLast(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> inner = new ArrayList();
            while (size-- > 0) {
                TreeNode tmp = deque.removeFirst();
                inner.add(tmp.val);
                if (tmp.left != null) {
                    deque.addLast(tmp.left);
                }
                if (tmp.right != null) {
                    deque.addLast(tmp.right);
                }
            }
            res.add(inner);
        }
        //        取出最后一层的第一个节点，即代表左下角的值

        return res.get(res.size() - 1).get(0);
    }
}
