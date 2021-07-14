package dynamic;

/**
 *
 * 打家劫舍
 * @author 张烈文
 * @date 2021/7/14 8:57
 */
public class HouseRobber {


    /**
     * 1.dp[i]:下标i，dp[i]下标i(包含i)之前所能偷的最大金额
     * 2.递推公式：如果要偷第i间房那么，dp[i]=dp[i-2]+nums[i](i-2的最大金额+第i间房的最大金额)，如果不偷i间房，则考虑dp[i-1]，
     *   因此递推公式：dp[i]=Math.max(dp[i-2]+nums[i],dp[i-2])
     * 3.初始化dp[0]=nums[0],dp[1]=Math.max(dp[0],dp[1])
     * 4.dp[i]是由dp[i-2],dp[i-1]推导出来的，因此一定是从前往后
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0){
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[n-1];

    }
}
