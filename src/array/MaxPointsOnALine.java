package array;

/**
 * 直线上最多的点数
 * @author 张烈文
 */
public class MaxPointsOnALine {

    /**
     *
     * 思路：尝试先将两个点构成一条直线，然后检查其余点是否落在该直线中
     * 时间复杂度：O(n^3)
     * 每层循环确定一个点
     * @param ps
     * @return
     */
    public int maxPoints(int[][] ps) {
        int n = ps.length;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int[] x = ps[i];
            for (int j = i + 1; j < n; j++) {
                int[] y = ps[j];
                int cnt = 2;
                for (int k = j + 1; k < n; k++) {
                    int[] p = ps[k];
//                    这里实际采用了相似直线的两点公式来确两个点是否在同一条直线上，然后在对角相乘即可
//                    具体推到可以考虑使用相似三角形：画图分析即可，
                    int s1 = (y[1] - x[1]) * (p[0] - y[0]);
                    int s2 = (p[1] - y[1]) * (y[0 ] - x[0]);
                    if (s1 == s2) {
                        cnt++;
                    }
                }
                ans = Math.max(ans, cnt);
            }
        }
        return ans;
    }
}
