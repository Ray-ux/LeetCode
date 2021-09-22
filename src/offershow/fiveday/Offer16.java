package offershow.fiveday;

import java.util.HashMap;

/**
 * 不含重复字符的最长字符串
 *
 * @author 张烈文
 * @date 2021/9/22 16:38
 */
public class Offer16 {
    public  int lengthOfLongestSubstring(String s) {

        int maxLen = 0;
        HashMap<Character, Integer> ans = new HashMap<>();
        for (int start = 0, end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (ans.containsKey(c)) {
//                abba防止start由大变小因此需要取大值
                start = Math.max(ans.get(c) + 1, start);
            }
            maxLen = Math.max(maxLen, end - start + 1);
            ans.put(c, end);
        }
        return maxLen;
    }


}
