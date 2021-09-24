package offershow.sixday;

/**
 * 回文字符串的个数
 * @author 张烈文
 * @date 2021/9/24 10:07
 */
public class Offer20 {

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int result = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if ((s.charAt(i) == s.charAt(j) && (j - i <= 1 || dp[i + 1][j - 1]))) {
                    dp[i][j] = true;
                    result ++;
                }
            }
        }
        return result;
    }
}
