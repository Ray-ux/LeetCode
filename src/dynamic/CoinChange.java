package dynamic;

import java.util.Arrays;

/**
 * 硬币兑换
 * @author 张烈文
 * @date 2021/7/12 12:38
 */
public class CoinChange {

    /**
     * 此题由于每种硬币数量是无限的，因此为完全背包问题
     * 该题求的是装满背包所需的最小硬币数量，那么物品的价值就为1，重量就为coins[i]
     * 1.确定dp[j]:j代表金额，dp[j]代表装满j所需要的最少硬币数量
     * 2.确定地推公式：dp[j]=Math.min(dp[j],dp[j-coins[i]]+1)
     * 3.初始化：由于金额为0，装满金额0所需的硬币数量为0。因此dp[0]=0,注意这里由于递推公式的特殊性(求的是最小数量)，因此我们还应把创建的dp数组全部初始化为最大值
     * 4.确定遍历顺序：此题不是求组合（先遍历物品再遍历容量）或者排列（先遍历容量再遍历物品），因此遍历顺序两种都可以，我们这里选择的是先遍历物品再遍历容量
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
//        先遍历物品再遍历容量
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
//                如果dp[j - coins[i]]是初始值则跳过
                if (dp[j - coins[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
