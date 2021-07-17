package dynamic;

/**
 *
 * 最佳买卖股票的时机含冷冻期
 * @author 张烈文
 * @date 2021/7/16 21:57
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * 1.确定dp[i][j],第i天状态为j，所剩的最多现金为dp[i][j]
     * 0--买入股票状态（今天买入股票或者保持买入股票）
     * 1--前两天就卖出股票。度过了冷冻器，今天保持卖出股票状态
     * 2--今天卖出股票
     * 3--今天为冷冻期
     * 2.递推公式：可根据代码分析一次确定哥哥状态的推到过程
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n==0) {
            return 0;
        }
        int[][] dp = new int[n][4];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3]-prices[i], dp[i - 1][1]-prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }
        return Math.max(dp[n - 1][3], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }
}
