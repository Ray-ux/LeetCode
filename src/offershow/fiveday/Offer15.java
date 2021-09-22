package offershow.fiveday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * 字符串中的所有变位词
 * @author 张烈文
 * @date 2021/9/22 16:25
 */
public class Offer15 {


    /**
     * 参考上一题就可以啦
     * @param s
     * @param p
     * @return
     */
    public  List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();
        int n = s.length(), m = p.length();
        if (m > n) {
            return ans;
        }
        int[] cntS = new int[26];
        int[] cntP = new int[26];
        for (int i = 0; i < m; i++) {
            cntS[s.charAt(i) - 'a']++;
            cntP[p.charAt(i) - 'a']++;
        }
        if (Arrays.equals(cntP, cntS)) {
            ans.add(0);
        }
        for (int i = n; i < n; i++) {
            cntS[s.charAt(i) - 'a']++;
            cntP[s.charAt(i - m) - 'a']--;
            if (Arrays.equals(cntP, cntS)) {
                ans.add(i - n);
            }
        }
        return ans;
    }


}
