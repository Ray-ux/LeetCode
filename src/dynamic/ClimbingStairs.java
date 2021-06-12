package dynamic;

/**
 * 爬楼梯
 *
 * @author 张烈文
 */
public class ClimbingStairs {
    /**
     * 动态规划五部曲：
     * 1.确定dp[i]及下标i的含义
     * 2.确定递推公式
     * 3.初始化
     * 4.确定遍历的顺序
     * 5.验证
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {

        if (n <= 1) {
            return n;
        }

//        dp代表当前爬到第i层所需要的方法的数量
//        确定递推公式：dp[i]=dp[i-1]+dp[i-2]
        int[] dp = new int[n + 1];
//      初始化 ：爬到第一层只要一种方法
        dp[1] = 1;
//        爬到第二层需要两种方法
        dp[2] = 2;
//        遍历
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }


    /**
     * 优化空间
     * @param n
     * @return
     */
    public int climbStairs1(int n) {

        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int sum = dp[1] + dp[2];
            dp[1] = dp[2];
            dp[2] = sum;
        }
        return dp[2];
    }
}
