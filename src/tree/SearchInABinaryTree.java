package tree;

/**
 *
 * 二叉搜索树中的搜索
 * @author 张烈文
 */
public class SearchInABinaryTree {

    public TreeNode searchBST(TreeNode root, int val) {
//        寻找递归终止条件，当前节点的val==val则返回
        if(root!=null&&root.val==val){
            return root;
        }else if(root.left!=null&&val<root.val){
            return searchBST(root.left,val);
        }else if(root.right!=null&&val>root.val){
            return  searchBST(root.right,val);
        }
        return null;
    }
}
