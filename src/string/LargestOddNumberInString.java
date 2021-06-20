package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串中的最大奇数
 * @author 张烈文
 */
public class LargestOddNumberInString {

    /**
     * 贪心:找末位的奇数
     * @param num
     * @return
     */
    public  String largestOddNumber(String num) {
        int n = num.length();
        int i = n - 1;
        while (i >= 0 && (num.charAt(i) - '0') % 2 == 0) {
            i--;
        }
        if (i == -1) {
            return "";
        }
        return num.substring(0, i + 1);
    }


}
