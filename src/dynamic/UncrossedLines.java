package dynamic;

/**
 * 不相交的线
 *
 * @author 张烈文
 * @date 2021/7/19 19:39
 */
public class UncrossedLines {
    /**
     * 此题和最长公共子序列的题相同
     * @param nums1
     * @param nums2
     * @return
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n1 = nums1.length+1;
        int n2 = nums2.length+1;
        int[][] dp = new int[n1][n2];
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (nums1[i-1] == nums2[j-1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }

        }
        return dp[n1-1][n2-1];
    }
}
