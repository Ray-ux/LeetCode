package dynamic;

/**
 * 不同路径Ⅱ
 *
 * @author 张烈文
 */
public class UniquePathsⅡ {

    /**
     * 该题和不同路径有异曲同工之处：只不过多了障碍物，我们只需要保证在有障碍物的位置dp[i][j]=0就可以啦
     * 该题容易忽略的一点：障碍之后应该都是0的情况
     * @param obstacleGrid
     * @return
     */
    public  int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

//        初始化：首行，遇到障碍物时，障碍物之处和首行之后的位置都为0
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            dp[i][0] = 1;
        }
//        初始化：首列，遇到障碍物时，障碍物之处和首列之后的位置都为0
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
//                只有在没有障碍物时，才保存状态，有障碍的位置处为0
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
            return dp[m - 1][n - 1];
    }


}
