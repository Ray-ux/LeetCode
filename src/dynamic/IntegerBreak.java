package dynamic;

/**
 * 整数拆分
 *
 * @author 张烈文
 */
public class IntegerBreak {

    /**
     * dp[i]：正整数i分拆所得到的最大乘积
     * 递推公式：我们从1遍历到j，依次记录最大的乘积，获取最大乘积的方式为：j*(i-j)或dp[i-j]*j
     *         由此得出：Math.max(dp[i], Math.max(j * (i - j), dp[i - j] * j))
     * 初始化：题目给的限定为n>=2因此我们初始化时，只需要初始dp[2]=1即可
     * @param n
     * @return
     */
    public int integerBreak(int n) {

        int[] dp = new int[n+1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), dp[i - j] * j));
            }
        }
        return dp[n];
    }
}

