package greedy;

/**
 *
 * 买卖股票的最佳时机Ⅲ
 * @author 张烈文
 * @date 2021/7/15 12:33
 */
public class BestTimeToBuyAndSellStockⅢ {


    /**
     * 1.确定dp,
     * 一天一共有五个状态：
     * j,0-没有操作，1-第一次买入，2-第一次卖出，3-第二次买入，4-第二次卖出
     * dp[i][j]表示第i天所处状态j所剩最大现金
     * 2.确定递推公式：
     * 达到dp[i][1]状态，有两个具体操作：
     * 操作一：第i天买入股票了，那么dp[i][1]=dp[i-1][0]-prices[i]
     * 操作二：第i天没有操作，而是沿用前一天买入的状态，即：dp[i][1]=dp[i-1][1]
     * 以此类推可以推出dp[i][2],dp[i][3],dp[i][4]
     * 3。初始化
     * dp[0][0]=0
     * dp[0][1]=-prices[0]
     * dp[0][2]=0
     * dp[0][3]=-prices[0]
     * dp[0][4]=0
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[][] dp = new int[n][5];
        dp[0][0]=0;
        dp[0][1] = -prices[0];
        dp[0][2] = 0;
        dp[0][3] = -prices[0];
        dp[0][4] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
            dp[i][2] = Math.max(dp[i - 1][1] + prices[i], dp[i - 1][2]);
            dp[i][3] = Math.max(dp[i - 1][2] - prices[i], dp[i - 1][3]);
            dp[i][4] = Math.max(dp[i - 1][3] + prices[i], dp[i - 1][4]);
        }
        return dp[n - 1][4];
    }
}
