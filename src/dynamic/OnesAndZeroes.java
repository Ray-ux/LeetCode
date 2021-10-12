package dynamic;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 一和零
 * @author 张烈文
 */
public class OnesAndZeroes {

    /**
     * 思路一：动态规划：背包问题0-1
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int oneNums = 0;
            int zeroNums = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeroNums++;
                }else{
                    oneNums++;
                }
            }
            for (int i = m; i >= zeroNums; i--) {
                for (int j = n; j >= oneNums; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNums][j - oneNums] + 1);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 思路二：回溯超时
     * 先找出所有子集在遍历子集找出0和1的数量
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm1(String[] strs, int m, int n) {
        int maxLen = 0;
        List<List<String>> res = new ArrayList<>();
        Deque<String> path = new LinkedList<>();
        dfs(0, strs, res, path);

        for (List<String> inner : res) {
            int one = 0;
            int zero = 0;
            for (String str : inner) {
                for (int i = 0; i < str.length(); i++) {
                    int num = str.charAt(i) - '0';
                    if (num == 0) {
                        zero++;
                    }else{
                        one++;
                    }
                }
            }
            if (zero <= m && one <= n && inner.size() > maxLen) {
                maxLen = inner.size();
            }
        }
        return maxLen;
    }

    private void dfs(int begin, String[] strs, List<List<String>> res, Deque<String> path) {

        for (int i = begin; i < strs.length; i++) {
            path.addLast(strs[i]);
            res.add(new ArrayList<>(path));
            dfs(i + 1, strs, res, path);
            path.removeLast();
        }
    }

}

