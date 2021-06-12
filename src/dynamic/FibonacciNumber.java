package dynamic;

/**
 * 斐波拉契数
 * @author 张烈文
 */
public class FibonacciNumber {

    /**
     * 递归解法
     * @param n
     * @return
     */
    public int fib(int n) {
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        return fib(n-1)+fib(n-2);
    }

    /**
     * 动态规划五部曲：
     * 1.确定dp[i]和下标的含义
     * 2.确定递推公式
     * 3.初始化dp数组
     * 4.确定遍历的顺序
     * 5.验证自己的思路和代码运行出来的结果是否一致
     * @param n
     * @return
     */
    public int fib1(int n) {
        if (n == 0) {
            return 0;
        }
//        1.dp[i]表实第i个斐波拉契数
        int[] dp = new int[n + 1];
//        2.确定递推公式dp[n]=dp[n-1]+dp[n-2];
//        3.初始化dp
        dp[0] = 0;
        dp[1] = 1;
//        4.确定遍历顺序
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
