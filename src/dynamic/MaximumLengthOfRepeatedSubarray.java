package dynamic;

/**
 *
 * 最长重复数组
 * @author 张烈文
 * @date 2021/7/18 14:38
 */
public class MaximumLengthOfRepeatedSubarray {

    /**
     * 1。确定dp[i][j],以i-1为结尾的nums1和以j-1为结尾的nums2的数组，最长重复子数组
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[][] dp = new int[n1+1][n2+1];
        int result = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                if (dp[i][j] > result) {

                    result = dp[i][j];
                }
            }
        }
        return result;
    }




}
