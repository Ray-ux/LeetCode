package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 字符串的排列
 *
 * @author 张烈文
 */
public class PermutationString {

    /**
     * 滑动窗口，通过cnt1来记录s1中字符每个字符出现的次数，cnt2来记录长度为s1.length()的s2子字符串中各个字符的出现次数
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        /*
        初始化：窗口长度为n
        记录s1中的各个字符出现的次数
        记录长度为n的s2的各个字符出现的次数
         */
        for (int i = 0; i < n; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }

        /*
        窗口开始移动
         */
        for (int i = n; i < m; i++) {
            cnt2[s2.charAt(i) - 'a']++;
            cnt2[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;


    }

}
