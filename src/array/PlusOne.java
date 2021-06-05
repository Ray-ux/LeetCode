package array;

/**
 * 加一
 *
 * @author 张烈文
 */
public class PlusOne {
    /**
     * 思路一：模仿两数相加
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {

        int[] num = {1};
        int dend = digits.length - 1;
        int nend = 0;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (dend >= 0 || nend >= 0) {
            int x = dend >= 0 ? digits[dend--] : 0;
            int y = nend >= 0 ? num[nend--] : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            sum = sum % 10;
            builder.append(sum);
        }
        if (carry == 1) {
            builder.append("1");
        }
        int[] res = new int[builder.length()];
        for (int i = builder.length() - 1, j = 0; i >= 0; i--, j++) {
            res[j] = builder.charAt(i) - '0';
        }
        return res;
    }

    /**
     * leetcode精选题解
     * @param digits
     * @return
     */
    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
