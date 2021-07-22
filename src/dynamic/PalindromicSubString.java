package dynamic;

import java.util.Arrays;

/**
 * 回文子串
 *
 * @author 张烈文
 * @date 2021/7/22 21:36
 */
public class PalindromicSubString {
    /**
     * 1.确定dp[i][j]：表示区间范围[i,j]，左闭右闭的子串是否回文子串，如果是dp[i][j]为true，否则为false
     *
     * 3.初始化因全为false
     * 4.确定遍历顺序：由于在确定dp[i][j]的时候会用到dp[i+1][j-1],因此遍历顺序应该为从下到上从左到右
     * @param s
     * @return
     */
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];

        int result = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i)==s.charAt(j)&&(j-i<=1||dp[i+1][j-1])){
                    result++;
                    dp[i][j] = true;
                }
            }
        }
        return result;
    }
}
