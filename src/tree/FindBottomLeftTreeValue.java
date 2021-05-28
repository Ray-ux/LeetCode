package tree;

import java.util.*;

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

//    从右往左遍历节点

    public int findBottomLeftValue1(TreeNode root) {

        Deque<TreeNode> queue = new LinkedList<>();
//            将头节点添加进队列
        queue.addLast(root);
        while (!queue.isEmpty()) {
//            将头节点出队
            root = queue.removeFirst();
//            先将右节点加入队列
            if (root.right != null) {
                queue.addLast(root.right);
            }
//            再将左节点加入队列
            if (root.left != null) {
                queue.addLast(root.left);
            }
        }
//        最终剩下的就是最左下角的叶子节点
        return root.val;
    }


    //    递归深度优先遍历dfs,该题由于根节点一定存在，因此res=任何值都可以

    int res = Integer.MAX_VALUE;
    int depth = -1;
    public int findBottomLeftValue2(TreeNode root) {

        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int h) {
//        递归终止条件：当前结点为null则返回
        if(node==null) {
            return res;
        }
//        如果当前高度大于depth则将h赋值给depth，将当前层的第一个节点赋值给res
//        事实上在以后的遍历该层节点时，都不会在进入该判断语句中
        if (h > depth) {
            depth = h;
            res = node.val;
        }

//        递归调用，深度+1
        dfs(node.left, h + 1);
        dfs(node.right, h + 1);

        return res;
    }
}