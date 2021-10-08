package tree;

/**
 * 树的子结构
 * @author 张烈文
 * @date 2021/10/8 19:41
 */
public class TreeSonStructure {

    /**
     * 先序遍历+判断是否是子树
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
//        特殊情况处理：
        if (B == null || A == null) {
            return false;
        }
//     先序遍历：判断以A为根节点的树是否包含B子树isContain(A, B),若A为根节点的包含B子树则我们就判断A的左子树是否包含B：isSubStructure(A.left, B)
        return isContain(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    /**
     * 这里实际上和相同的树很类似，但是由于B是子结构因此我们在实现终止条件的时候的会有不同
     * 即：当节点B为空：说明B已匹配完成，因此返回true
     *    当节点A为空，说明已经越过A叶子节点，而此时B依然不为空，因此匹配失败，返回false
     *    当节点A和B的值不同：说明匹配失败，返回false
     * @param A
     * @param B
     * @return
     */
    private boolean isContain(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        if (A.val != B.val) {
            return false;
        }

//        这里的逻辑就是A.val==B.val，然后在判断A的左子树和B的左子树，和A的右子树和B的右子树
//        实际和相同的树一样
        return isContain(A.left, B.left) && isContain(A.right, B.right);

    }
}
