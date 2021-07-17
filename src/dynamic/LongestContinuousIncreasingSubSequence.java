package dynamic;

import java.util.Arrays;

/**
 * 最长连续递增序列
 *
 * @author 张烈文
 * @date 2021/7/17 14:25
 */
public class LongestContinuousIncreasingSubSequence {
    public int findLengthOfLCIS(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        int result = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] > nums[i]) {
                dp[i + 1] = dp[i] + 1;
            }
            if (dp[i + 1] > result) {
                result =dp[i + 1];
            }
        }
        return result;

    }
}
