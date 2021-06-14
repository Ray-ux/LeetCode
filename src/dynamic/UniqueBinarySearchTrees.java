package dynamic;

/**
 * 不同的二叉搜索树
 *
 * @author 张烈文
 */
public class UniqueBinarySearchTrees {
    /**
     *
     * 1.dp[i]:代表节点数量为i所构造出的二叉搜索树的种数
     * 2.递推公式：dp[i]+=dp[j-1]+dp[i-j],j-1为以j为头结点左⼦树节点数量，i-j为以j为头结点右⼦树节点数量
     * 3.初始化：dp[0]=1，从定义上讲，空节点也是一颗二叉树
     * 4.⾸先⼀定是遍历节点数，从递归公式：dp[i] += dp[j - 1] * dp[i - j]可以看出，节点数为i的状态是依靠 i之
     * 前节点数的状态。那么遍历i⾥⾯每⼀个数作为头结点的状态，⽤j来遍历。
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
