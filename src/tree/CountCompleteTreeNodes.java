package tree;

/**
 * 完全二叉树的节点个数
 *
 * @author 张烈文
 */
public class CountCompleteTreeNodes {


//    递归解法：时间复杂度为O(n)

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
//        左子树的节点树+右子树的节点树+一个根节点
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

//    非递归方式
    public int countNodes1(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftDepth = countLevel(root.left);
        int rightDepth = countLevel(root.right);
//        由于是完全二叉树，因此若出现left==right，则代表左子树的最后一层已经溢出到右子树了
        // 代表左子树是满的,若不等：则代表右子树比左子树少一层且右子树为满二叉树
        if (leftDepth == rightDepth) {
//            2^leftDepth,这里其实是（2^leftDepth-1）+1 (因为要加上根节点)
            return countNodes1(root.right) + 1 << leftDepth;
        }else {
            return countNodes1(root.left) + 1 << rightDepth;
        }
    }

//    计算深度
    private int countLevel(TreeNode node) {
        int level = 0;
        while (node != null) {
            ++level;
            node = node.left;
        }
        return level;
    }


}
