package dynamic;

/**
 *
 * 买卖股票的最佳时机含手续费
 * @author 张烈文
 * @date 2021/7/16 22:17
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    /**
     * 该题只是比买卖股票的最佳时机Ⅱ多了一个手续费
     *
     * 1.确定dp:dp[i][0]表示第i天持有股票所剩的最大现金。dp[i][1]表示第i天不持有股票所剩的最大现金
     * 2.递推公式：
     * dp[i][0]怎么来的呢？dp[i-1][0]前一天持有股票或前一天不持有股票在今天买股票dp[i-1][1]-prices[i]
     * dp[i][1],dp[i-1][1]前一天不持有股票或前一天持有股票然后卖出且减去手续费，dp[i-1][0]+prices[i]-fee
     * 3.初始化
     * dp[0][0]=-prices[0]
     * dp[0][1]=0
     * 4.遍历顺序：很明显是从前到后
     * @param prices
     * @param fee
     * @return
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i] - fee);
        }
        return Math.max(dp[n - 1][1], dp[n - 1][0]);
    }
}
