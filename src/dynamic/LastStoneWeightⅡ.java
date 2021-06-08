package dynamic;

/**
 * 最后一块石头的重量
 *
 * @author 张烈文
 */
public class LastStoneWeightⅡ {
//    动态规划：转化为背包问题
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        int t = sum / 2;
        int[][] f = new int[n + 1][t + 1];
        for (int i = 1; i <= n; i++) {
            int x = stones[i - 1];
            for (int j = 0; j <= t; j++) {
                f[i][j] = f[i - 1][j];
                if (j >= x) {
                    f[i][j] = Math.max(f[i][j], f[i - 1][j - x] + x);
                }
            }
        }
        return Math.abs(sum - f[n][t] - f[n][t]);
    }
}
