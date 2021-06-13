package dynamic;

/**
 * 不同路径
 *
 * @author 张烈文
 */
public class UniquePaths {

    /**
     * 依然动态规划五部曲：
     * 1.确定dp[i]及下标i的含义：本题：dp[i][j]代表机器人走到矩阵[i][j]位置时所需要的路径数量，
     * 2.确定递推公式：由于机器人只有向右走和向下走因此：可推导公式：dp[i][j]=dp[i-1][j]+dp[i][j-1]
     * 3.初始化：dp[i][0]⼀定都是1，因为从(0, 0)的位置到(i, 0)的路径只有⼀条，那么dp[0][j]也同理
     * 4.确定遍历的顺序
     * 5.验证
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<n;j++){
            dp[0][j]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
