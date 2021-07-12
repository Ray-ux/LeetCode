package dynamic;

/**
 *
 * 组合总和Ⅳ
 * @author 张烈文
 * @date 2021/7/12 10:15
 */
public class CombinationSumⅣ {

    /**
     * 此题和零钱兑换Ⅱ这题恰好成对立面
     * 零钱兑换那题相当于是求的组合（不考虑顺序即[1,2]，[2,1]是相同的）因此我们在确定遍历顺序的时候只能先遍历物品在遍历容量
     * 而该题由于求的是排列（考虑顺序[1,2]，[2,1]，不同），因此我们确定遍历顺序是先遍历容量再遍历物品
     *
     * 这两个题都是来求装满背包的几种方式因此遍历顺序至关重要且递推公式一般都为dp[j]+=dp[j-weight[i]]，
     * 但是如果仅仅是求能否装满背包,那么遍历顺序就没那么重要了，且递推公式为：dp[j]=Math.max(dp[j],dp[j-weight[i]+value[i]])
     * @param nums
     * @param target
     * @return
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp=new int[target+1];
        dp[0]=1;
//        先遍历背包背包容量，再遍历物品
        for(int j=0;j<=target;j++){
            for(int i=0;i<nums.length;i++){
                if(j>=nums[i]){
                    dp[j]+=dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }
}
