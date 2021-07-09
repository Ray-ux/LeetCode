package string;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 *
 * @author 张烈文
 */
public class LongestSubstringWithoutRepeatingCharacters {
    /**
     * 利用HashMap来控制窗口的移动
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap();
        int max = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {

            Character c = s.charAt(end);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            max = Math.max(max, end - start + 1);
            map.put(c, end);
        }
        return max;
    }
}
