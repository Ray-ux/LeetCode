package offershow.fiveday;

import java.util.Arrays;

/**
 * 字符串中的变位词
 * @author 张烈文
 * @date 2021/9/22 19:15
 */
public class Offer14 {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) {
            return false;
        }
//        创建两个数组
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];

//        先将两个数组都初始化数组长度为n
        for (int i = 0; i < n; i++) {
            cnt1[s1.charAt(i) - 'a']++;
            cnt2[s2.charAt(i) - 'a']++;
        }
//        若在s2的前n的字符中已经出现了s1，则直接返回，否则需要移动窗口
        if (Arrays.equals(cnt1, cnt2)) {
            return true;
        }

//        移动窗口
        for (int i = n; i < m; i++) {
//            窗口向右移动
            cnt2[s2.charAt(i) - 'a']++;
//            为了保持窗口大小，我们应该将起始点向右移
            cnt2[s2.charAt(i - n) - 'a']--;
            if (Arrays.equals(cnt1, cnt2)) {
                return true;
            }
        }
        return false;


    }
}
