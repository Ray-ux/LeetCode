package dynamic;

import java.util.*;

/**
 * 零钱兑换Ⅱ
 * @author 张烈文
 */
public class CoinChangeⅡ {

    public int change(int amount, int[] coins) {

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
