package dynamic;

/**
 *
 * 买卖股票的最佳时机Ⅳ
 * @author 张烈文
 * @date 2021/7/15 13:12
 */
public class BestTimeToBuyAndSellStockⅣ {

    /**
     * 该题思路来源于买卖股票的最佳时机Ⅲ，也就相当于把Ⅲ中的只能完成2笔交易，改为了k笔交易，其它思路都一样
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if(n<2){
            return 0;
        }
        int count = 2 * k + 1;
        int[][] dp = new int[n][count];
        for (int i = 1; i < count; i += 2) {
            dp[0][i] = -prices[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < count; j++) {
//                利用余数来判断当前是卖出还是买入，买入则-prices[i]，卖出则+prices[i]
                int div=(j-1)%2;
                if(div==0){
                    dp[i][j] = Math.max(dp[i-1][j - 1] - prices[i], dp[i-1][j]);
                }else{
                    dp[i][j] = Math.max(dp[i-1][j - 1] + prices[i], dp[i-1][j]);
                }
            }
        }
        return dp[n - 1][count-1];
    }
}
