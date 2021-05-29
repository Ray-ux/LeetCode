package tree;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 最大二叉树
 * @author 张烈文
 */
public class MaximumBinaryTree {

//    利用hashmap记录数组值及下标，该数组中无重复元素

    HashMap<Integer, Integer> memo = new HashMap<>();

    public  TreeNode constructMaximumBinaryTree(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            memo.put(nums[i], i);
        }
        return builder(0, nums.length-1,nums);

    }

    private   TreeNode builder(int start, int end,int[] nums) {
        if (start>end) {
            return null;
        }
        int maxNum = findMaxInNums(start, end, nums);
        int maxIndex = memo.get(maxNum);
        TreeNode node = new TreeNode(maxNum);
        node.left = builder(start, maxIndex - 1, nums);
        node.right = builder(maxIndex + 1, end, nums);
        return node;
    }

    private  int findMaxInNums(int start, int end, int[] nums) {
        int maxNum = nums[start];
        for (int i = start; i <= end; ++i) {
            if (nums[i] > maxNum) {
                maxNum = nums[i];
            }
        }
        return maxNum;
    }

}
