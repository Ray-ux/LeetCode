package dynamic;

/**
 * 最大子序列和
 *
 * @author 张烈文
 * @date 2021/7/19 19:57
 */
public class MaximumSubarray {

    /**
     *
     * 1.确定dp[i]:包括下标i之前的最大连续子序列和为dp[i]
     * 2.递推公式：dp[i]:两个方向推出来：dp[i-1]+nums[i] 或nums[i]
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        int result=nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if(dp[i]>result){
                result=dp[i];
            }
        }
        return result;
    }
    /**
     * 贪心解法：从下标0向后开始统计和，当当前和已经小于0时，则重新从下一个位置开始统计和，当当前和大于最大和时，则最大值等于当前和
     * @param nums
     * @return
     */
    public int maxSubArray1(int[] nums) {

        int result = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += nums[i];
            if (count > result) {
                result = count;
            }
            if (count <= 0) {
                count = 0;
            }
        }
        return result;
    }
}
