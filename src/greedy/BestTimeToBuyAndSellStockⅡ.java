package greedy;

/**
 *
 * 买卖股票的最佳时机Ⅱ
 * @author 张烈文
 * @date 2021/7/15 12:02
 */
public class BestTimeToBuyAndSellStockⅡ {

    /**
     * 贪心：相当于就是把最终利润分解
     * 如第0天买入，第3天卖出，那么利润为：price[3]-price[0]
     * 可分解为：（price[3]-price[2]）+（price[2]-price[1]）+(price[1]-price[0])
     * 相当于把利润分解为每天单位的维度
     *
     *
     * 最终我们只收集每天正利润
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            result += Math.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }
}
