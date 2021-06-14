package dynamic;

/**
 * 01背包问题 二维数组
 *
 * @author 张烈文
 */
public class DynamicBasic {

    /**
     * 一个背包容量为4，现有
     * 物品0重量为1，价值15
     * 物品1重量为3，价值20
     * 物品2重量为4，价值30
     * 求背包能装的最大价值？
     *
     * 二维数组
     */
    int[] weight = {1, 3, 4};
    int[] value = {15, 20, 30};
    public void learn() {

//        1.确定dp[i][j]：
        int[][] dp = new int[3][5];
//        2.递推公式：dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i])

//        3.倒叙初始化：若容量
        for (int j = 4; j >= weight[0]; j--) {
            dp[0][j] = dp[0][j - weight[0]] + value[0];
        }

        for (int i = 1; i <= 2; i++) {
            for (int j = 1; j <= 4; j++) {
                if (j < weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
    }

    /**
     * 滚动数组：
     * dp[j]代表容量为j背包是所能装的最大价值
     */
    public void learn1() {
        int[] dp = new int[5];

        for (int i = 0; i < 3; i++) {
            for (int j = 4; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
    }
}
