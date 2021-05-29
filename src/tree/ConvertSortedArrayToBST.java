package tree;

/**
 * 将有序数组转换为二分搜索树
 *
 * @author 张烈文
 */
public class ConvertSortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {

        return buidler(nums, 0, nums.length - 1);

    }

//    使用左闭右闭
    private TreeNode buidler(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (r + l) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buidler(nums, l, mid - 1);
        node.right = buidler(nums, mid + 1, r);
        return node;

    }
}
