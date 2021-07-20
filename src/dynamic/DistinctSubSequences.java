package dynamic;

/**
 * 不同的子序列
 *
 * @author 张烈文
 * @date 2021/7/20 15:32
 */
public class DistinctSubSequences {
    /**
     * 1.确定dp[i][j]:以i-1为结尾的s子序列中出现以j-1为结尾的t的个数dp[i][j]
     * 2.递推公式：dp[i][j]=dp[i-1][j-1]+dp[i-1][j] 或dp[i][j]=dp[i-1][j]
     * 3.初始化：以i-1为结尾的s可以随便删除元素，出现空字符串的个数，那么dp[i][0]一定都是1
     * @param s
     * @param t
     * @return
     */
    public int numDistinct(String s, String t) {

        int ns = s.length();
        int nt = t.length();
        int[][] dp = new int[ns + 1][nt + 1];
        for (int i = 0; i <= ns; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= ns; i++) {
            for (int j = 1; j <= nt; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }else{
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[ns][nt];
    }
}
