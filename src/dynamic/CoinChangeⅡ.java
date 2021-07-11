package dynamic;

import java.util.*;

/**
 * 零钱兑换Ⅱ
 * @author 张烈文
 */
public class CoinChangeⅡ {

    /**
     * 根据题目描述，可知硬币的数量是无限的，因此很明显是完全背包问题
     *
     * 然而此题是求的装满背包有几种方式，在0-1背包问题中，我们总结出若是求装满背包的方式有几种
     * 那么递推公式就是：dp[j]+=dp[j-weight[i]]
     *
     *
     * 动规五部曲：
     * 1.确定dp数组即下标的含义：dp[j]：凑成总金额j的货币组合数dp[j]
     * 2.确定递推公式：dp[j]+=dp[j-coins[i]]
     * 3.初始化：dp[0]=1
     * 4.确定遍历顺序：先遍历物品（硬币）再遍历背包容量（金钱总额）
     * 5.举例验证
     * @param amount
     * @param coins
     * @return
     */
    public static int change(int amount, int[] coins) {

        int[] dp = new int[amount+1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
//
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }


}
