package tree;

/**
 *
 * 二叉树搜索树的后序遍历序列
 * @author 张烈文
 * @date 2021/10/9 19:58
 */
public class BstPostOrder {


    /**
     * 由于后序遍历是左右中：
     * 因此我们要找到第一个大于根节点的元素，并记录下标m
     * 如果i>=j则直接返回true
     * 此时区间[i,m-1]都要小于post[j]，[m,j-1]都要大于post[j],
     * @param postorder
     * @return
     */
    public boolean verifyPostorder(int[] postorder) {
//        约定空树不是二叉树
        int len=postorder.length;
        if (len ==0) {
            return false;
        }
        return isBst(postorder, 0, len - 1);
    }

    private boolean isBst(int[] postorder, int i, int j) {

        if (i >= j) {
            return true;
        }
//       新建指针p=i，以便保证i不变用于下一次递归，用p来遍历数组
        int p=i;
//        while循环找到第一个大于post[j]的元素下标
        while (postorder[p] < postorder[j]) {
            p++;
        }
//        第一个大于post[j]的元素下标
        int m=p;
        while (postorder[p] > postorder[j]) {
            p++;
        }
//        当p==j时，则代表区间[m,j-1]都是大于post[j]的
//        再递归判断[i,m-1]与[m,j-1]中的区间元素是否都是符合的
        return p == j && isBst(postorder, i, m - 1) && isBst(postorder, m, j - 1);
    }
}
