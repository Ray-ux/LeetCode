package dynamic;

import java.util.Locale;

/**
 * 判断子序列
 * @author 张烈文
 * @date 2021/7/20 13:58
 */
public class IsSubSequence {


    /**
     * 思路1：
     * 此题和最长公共序列类似
     * 只不过是多了最后一个条件判断：即如果最后最长公共序列等于s.length()，则证明字符串t中存在s序列因此返回true
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {

        int n1 = s.length();
        int n2 = t.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n1][n2] == n1 ? true : false;
    }

    /**
     * 思路2：
     * 不断向后查找s的当前字符，并更新当前字符在t中的位置index，接下来继续从index+1位置出继续向后查找是否存在s的下一个字符不断循环直接结束
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence1(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) {
                return false;
            }
        }
        return true;
    }

}
