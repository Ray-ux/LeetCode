package math;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;

/**
 * @author 张烈文
 * 第一个只出现一次的字符
 * @date 2021/10/22 19:15
 */
public class FirstChar {

    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> ans = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            ans.put(c, ans.getOrDefault(c, 0) + 1);
        }
        for (char key : ans.keySet()) {
            if (ans.get(key) == 1) {
                return key;
            }
        }
        return ' ';
    }
}
