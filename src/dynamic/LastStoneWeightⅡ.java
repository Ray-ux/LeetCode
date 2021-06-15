package dynamic;

/**
 * 最后一块石头的重量
 *
 * @author 张烈文
 */
public class LastStoneWeightⅡ {
//    动态规划：转化为背包问题01背包问题
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        int target = sum / 2;
//        确定dp[j]：容量为j的背包,最多可以背dp[j]这么重的石头
        int[] dp=new int[target+1];

//        递推公式：dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i])
//        由于使用滚动数组，因此可以考虑在遍历的直接初始化，我们就不用自己初始化了
        for(int i=0;i<stones.length;i++){
            for(int j=target;j>=stones[i];j--){
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }

//        最后dp[target]⾥是容量为target的背包所能背的最⼤重量。
//        那么分成两堆⽯头，⼀堆⽯头的总重量是dp[target]，另⼀堆就是sum - dp[target]
//        在计算target的时候，target = sum / 2 因为是向下取整，所以sum - dp[target] ⼀定是⼤于等于
//        dp[target]的。那么相撞后的最小重量为sum-dp[target]-dp[target]
        return sum-dp[target]-dp[target];

    }
}
