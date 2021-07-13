package dynamic;

import java.util.List;

/**
 *
 * 单词的拆分
 * @author 张烈文
 * @date 2021/7/13 14:26
 */
public class WordBreak {

    /**
     * 1.确定dp[i]:i代表字符串的长度，dp[i]如果为true代表，可以拆分为一个或多个子字典中出现的单词
     * 2.确定递推公式：如果dp[j]是true，却在[j,i]这个区间的子串出现在字典里，那么dp[i]一定是true,(j<i),因此递推公式为if(dp[j]&&[j,i]里的单词出现在字典里)
     * 3.初始化：很明显如果dp[0]=false，那么此后的所有位置都会为false，因此dp[0]=true
     * 4.确定遍历顺序：由于本题的特殊性，因为要求子串，最好先遍历背包再遍历物品
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
