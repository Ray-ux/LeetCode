package dynamic;

import tree.TreeNode;

/**
 * 打家劫舍Ⅲ
 *
 * @author 张烈文
 * @date 2021/7/14 10:22
 */
public class HouseRobberⅢ {


    /**
     * 本地由于我们需要求从根节点所能偷到的最大金额，因此我们选用后序遍历
     *
     * 1.确定dp,我们要求一个节点偷与不偷的两个状态所得到的金钱，那么返回值就是一个长度为2的数组
     *   这个返回值下标为0记录的是不偷当前节点所得到的最大金钱，下标为1记录的是偷当前节点所得到的最大金钱
     * 2.确定递归终止条件：肯定是当前节点为空的时候返回{0,0}
     * 3.确定遍历顺序：后序，需要通过递归函数的返回值来做下一步计算
     * 4.逻辑：如果偷当前节点则左右节点不能偷：因此val=cur.val+left[0]+right[0]
     *        如不偷当前节点则左右节点能偷（也可不偷,反正去二者最大值）val=Math.max(left[0],right[1])+Math.max(right[0],right[1])
     * @param root
     * @return
     */
    public int rob(TreeNode root) {
        int[] robber = robber(root);
        return Math.max(robber[0], robber[1]);
    }

    private int[] robber(TreeNode root) {
        int[] ans = new int[2];
        if (root == null) {
            return ans;
        }
        int[] left = robber(root.left);
        int[] right = robber(root.right);

//        不偷当前节点
        ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
//        偷当前节点
        ans[1] = root.val + left[0] + right[0];
        return ans;

    }
}
