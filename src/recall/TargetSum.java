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


    /**
     *
     * 一般在求装满背包有几种方法时：递推公式都为：dp[j]+=dp[j-nums[i]]
     * dp[j]：容量为j的背包最多有dp[j]种方法
     * 递推公式：dp[j]+=dp[j-nums[i]]
     * 初始化：dp[0]=1
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays1(int[] nums, int target) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (target > sum) {
            return 0;
        }
        if ((target+sum)%2==1){
            return 0;
        }
        int bagSize = (target + sum) / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[bagSize];

    }
}
