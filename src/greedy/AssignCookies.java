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
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index=0;
        for(int i=0;i<s.length;i++){
            if(index<g.length&&g[index]<=s[i]){
                index++;
            }
        }
        return index;
    }
}
