package offershow.sixday;

/**
 * 最多删除一个字符得到回文
 * @author 张烈文
 * @date 2021/9/23 22:01
 */
public class Offer19 {

    /**
     * 双指针
     * @param s
     * @return
     */
    public   boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return valid(l + 1, r, s) || valid(l, r - 1, s);
            }
            l++;
            r--;

        }
        return true;
    }

    private  boolean valid(int l, int r, String s) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
