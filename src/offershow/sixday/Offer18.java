package offershow.sixday;

/**
 * 有效的回文
 * @author 张烈文
 * @date 2021/9/23 21:50
 */
public class Offer18 {

    public boolean isPalindrome(String s) {
        String lowerCase = s.toLowerCase();
        StringBuilder res = new StringBuilder();
        for (char c : lowerCase.toCharArray()) {
            if ((c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')) {
                res.append(c);
            }
        }
        int l = 0, r = res.length()-1;
        while (l <= r) {
            if (res.charAt(l)==res.charAt(r)){
                l++;
                r--;
            }else{
                return false;
            }
        }
        return true;
    }
}
