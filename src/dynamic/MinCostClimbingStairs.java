package dynamic;

/**
 *
 * 使用最小花费爬楼梯
 * @author 张烈文
 */
public class MinCostClimbingStairs {

    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        if(n<=1){
            return  cost[0];
        }
//        1.确定dp数组，dp[i]：代表爬上第i级台阶所花费的最小体力
//        2.确定递推公式：dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i],第i级所花费的最小体力等于i-1级和i-2级的台阶花费体力的最小值+第i级需要花费的体力
        int[] dp=new int[n];
//        3.初始化
        dp[0]=cost[0];
        dp[1]=cost[1];
//        4.确定遍历顺序
        for(int i=2;i<n;i++){
            dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
        }
//        5.最后一步可以理解为不用花费，所以取倒数第一步，第二步的最小值
        return Math.min(dp[n-1],dp[n-2]);
    }
}
