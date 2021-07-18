package dynamic;

/**
 *
 * 最长公共子序列
 * @author 张烈文
 * @date 2021/7/18 15:18
 */
public class LongestCommonSubSequence {

    /**
     * 此题与最长重复子数组的区别在于上一题要求连续二此题不连续,只需要多增加一个条件即可
     * dp[i][j]：以下标i-1之前的text1和以下标j-1之前的text2，最长的公共子序列为dp[i][j]
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {

        int n1 = text1.length() + 1;
        int n2 = text2.length() + 1;
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
//                    如果不相等，则比较看text1[0, i - 2]与text2[0, j - 1]的最⻓公共⼦序列 和
//                    text1[0, i - 1]与text2[0, j - 2]的最⻓公共⼦序列，取最⼤的
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2];
    }
}
