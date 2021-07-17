package dynamic;

import java.util.Arrays;

/**
 *
 * 最长递增子序列
 * @author 张烈文
 * @date 2021/7/17 14:10
 */
public class LongEstIncreasingSubSequence {

    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int result = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (dp[i] > result) {
                result = dp[i];
            }
        }
        return result;

    }
}
