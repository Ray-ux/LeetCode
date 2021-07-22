package dynamic;

/**
 * 最长回文子序列
 *
 * @author 张烈文
 * @date 2021/7/22 22:06
 */
public class LongestPalindromicSubSequence {

    /**
     *
     *此题和最长回文子串有差别：子串要求连续，而子序列就不用
     * 1.确定dp[i][j]:区间[i,j]的组成回文子序列长度文dp[i][j]
     * 2.确定递推公式
     * 3.初始化：一个字符的回文子序列长度就是1
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i - 1][i - j] + 2;
                }else{
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][n - 1];
    }
}
