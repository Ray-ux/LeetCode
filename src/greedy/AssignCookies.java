package greedy;

import java.util.Arrays;

/**
 * 分发饼干
 * @author 张烈文
 * @date 2021/7/23 21:46
 */
public class AssignCookies {


    /**
     * 小饼干先喂饱小胃口
     * 贪心：将最大的饼干喂给胃口最大的孩子（局部最优），
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int start = s.length - 1;
        for (int i = g.length - 1; i >= 0; i--) {
            if (start >= 0 && s[start] >= g[i]) {
                start--;
                count++;
            }
        }
        return count;
    }
}
