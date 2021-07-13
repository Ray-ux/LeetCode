package dynamic;

import java.util.Arrays;

/**
 * 完全平方数
 *
 * @author 张烈文
 */
public class PerfectSquares {


    /**
     * 首先想到的思路其实和昨天做过的零钱兑换一样
     * 问题转化：题目求返回和为n的完全平方数的最少数量，也就是说我们有物品的重量为1，2，4，9，16....等等这些数
     * 要求我们找出最少的数使它们和为n并返回，每个数(可以想象为一个物品的重量,且物品的价值为1)可以使用无限次，可见为一个完全背包问题
     *
     * 1.确定dp[j] :j代表正整数j，dp[j]代表和为j的完全平方数的最少数量
     * 2.确定递推公式：dp[j]=Math.min(dp[j],dp[j-weight])+1)
     * 3.初始化：由于数字0所需要完全平方数的个数应该为0，因此初始化dp[0]=0
     * 4.确定遍历的顺序：这里由于是求装满背包的最大价值（和为n的完全平方数的最少数量），因此不管是先遍历物品还是先遍历背包都可以
     * @param n
     * @return
     */
    public  int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int s = (int) Math.sqrt(n);
        int[] weight = new int[s + 1];
        for (int i = 0; i <= s; i++) {
            weight[i] = (i + 1) * (i + 1);
        }
        dp[0] = 0;
        for (int i = 0; i < weight.length; i++) {
            for (int j = weight[i]; j <= n; j++) {
                if (dp[j - weight[i]] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - weight[i]] + 1);
                }
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}
