package dynamic;

/**
 *
 * 两个字符串的删除操作
 * @author 张烈文
 * @date 2021/7/21 20:11
 */
public class DeleteOperationForTwoStrings {

    /**
     * 1.确定dp数组（dp table）：dp[i][j]:以i-1为结尾的字符串word1，和以j-1为结尾的字符串word2，想要达到相等，所需要删除元素的最少次数
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        for (int i = 0; i <= n1;i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
//                如果相等，则不删除，则dp[i][j]=dp[i-1][j-1]
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
//                若不相等：则可能删除两个字符，也可能删除一个字符，要么删除word1，要么删除word2
                    dp[i][j] = Math.min(dp[i - 1][j - 1]+2, Math.min(dp[i - 1][j]+1, dp[i][j - 1]+1));
                }
            }
        }
        return dp[n1][n2];
    }
}
