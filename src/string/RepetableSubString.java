package string;

/**
 * 重复的字符串
 *
 * @author 张烈文
 * @date 2021/10/1 22:56
 */
public class RepetableSubString {

    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int[] next = new int[len];
        getNext(next, s);
//        next[len - 1]+1关于这里之所以要加1的原因在于next数组中的小标是从-1开始（即next数组的值是整体减了1的）
        if (next[len - 1] != -1 && (len % (len - (next[len - 1]+1)) == 0)) {
            return true;
        }
        return false;
    }

    private void getNext(int[] next, String s) {
        int j = -1;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {
            while (j >= 0 && s.charAt(i) != s.charAt(j + 1)) {
                j = next[j];
            }
            if (s.charAt(i) == s.charAt(j + 1)) {
                j++;
            }
            next[i] = j;
        }

    }


}
