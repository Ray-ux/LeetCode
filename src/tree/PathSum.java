package tree;

/**
 * 路径总和
 * @author 张烈文
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
//      递归的终止条件
        if(root==null){
            return false;
        }
//        当前节点没有左右节点且当前节点等于目标值时，则代表，在该条路径下的和等于targetSum
        if(root.left==null&&root.right==null&&targetSum==root.val){
            return true;
        }
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
}
