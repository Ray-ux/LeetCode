package recall;

/**
 * 目标和
 *
 * @author 张烈文
 */
public class TargetSum {

    /**
     * 思路一：二叉树求路径和，回溯dfs
     */
    int res = 0;
    public  int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        dfs(sum, target, nums, 0);
        return res;

    }
    private  void dfs(int sum, int target, int[] nums, int index) {
        if (index == nums.length) {
            if (sum==target) {
                res++;
            }
            return;
        }

        dfs(sum + nums[index], target, nums, index + 1);
        dfs(sum - nums[index], target, nums, index + 1);
    }
}
