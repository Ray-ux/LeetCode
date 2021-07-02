package greedy;

import java.util.Arrays;

/**
 * 雪糕的最大数量
 * @author 张烈文
 */
public class MaxIceCreamBars {

    /**
     * 咋一看是0-1背包问题，但是由于给的数据量太大会超时
     * 因此考虑使用贪心，先排序，我们一次从最小价格的开始购买雪糕，如果当前剩余的钱还大于雪糕的钱，则可购买，并且数量加一
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);

        int ans = 0;
        for (int i = 0; i < costs.length; i++) {
            if (coins >= costs[i]) {
                ans++;
                coins -= costs[i];
            }
        }

        return ans;
    }

    /**
     * 使用0-1背包问题求解
     *
     * 价值都为1，重量为costs[i],背包容量为coins
     * 先遍历物品，在遍历背包
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream1(int[] costs, int coins) {

        int[] dp = new int[coins + 1];

        dp[0] = 0;

        for (int i = 0; i < costs.length; i++) {
            for (int j = coins; j >= costs[i]; j--) {
                    dp[j] = Math.max(dp[j], dp[j - costs[i]] + 1);
            }
        }

        return dp[coins];

    }

}
