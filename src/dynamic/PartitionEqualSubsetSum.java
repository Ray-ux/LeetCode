package dynamic;

/**
 *
 *
 * 分割等和子集
 * @author 张烈文
 */
public class PartitionEqualSubsetSum {
    /**
     * 背包体积为sum/2
     * 背包要放入的商品重量为元素的数值，价值也为元素的数值
     * 背包如果正好装满，说明找到了总和为sum/2的子集
     * 背包中的每一个元素是不可重复放入的
     * @param nums
     * @return
     */
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%2==1){
            return false;
        }
//        背包容量
        int target = sum / 2;
//        确定dp[i][j]代表：在容量为j的时候，从0-i中产品中选的最大价值总和
        int[][] dp = new int[nums.length][target + 1];

//        初始化
        for (int j = target; j >= nums[0]; j--) {
            dp[0][j] = Math.max(dp[0][j], dp[0][j - nums[0]] + nums[0]);
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <= target; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - nums[i]] + nums[i]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        if (dp[nums.length - 1][target] == target) {
            return true;
        }
        return false;
    }

    public static boolean canPartition1(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum%2==1){
            return false;
        }
//        背包容量
        int target = sum / 2;
//        确定dp[j]代表背包容量为j时，所能装的最大价值
        int[] dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }

        if (dp[target] == target) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        canPartition(new int[]{1, 5, 11, 5});
    }
}
