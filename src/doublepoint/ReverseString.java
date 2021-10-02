package doublepoint;

/**
 * 反转字符串
 *
 * @author 张烈文
 * @date 2021/10/2 14:35
 */
public class ReverseString {
    public String reverse(String s) {
        StringBuilder res = new StringBuilder(s);
        int l = 0, r = res.length() - 1;
        while (l < r) {
            char c = res.charAt(l);
            res.setCharAt(l, res.charAt(r));
            res.setCharAt(r, c);
        }
        return res.toString();
    }
}
