package offershow.oneday;

/**
 * 二进制加法(类似于字符串相加)
 *
 * @author 张烈文
 * @date 2021/9/18 13:40
 */
public class Offer02 {
    public static String addBinary(String a, String b) {
        char[] arrayA = a.toCharArray();
        char[] arrayB = b.toCharArray();
        int A = arrayA.length - 1;
        int B = arrayB.length - 1;
        StringBuilder res = new StringBuilder();
        int s1 = 0;
        while (A >= 0 || B >= 0) {
            int aa = A < 0 ? 0 : arrayA[A]-'0';
            int bb = B < 0 ? 0 : arrayB[B]-'0';
            int sum = aa + bb+s1;
            int div = sum % 2;
            s1 = sum / 2;
            res.append(div);
            A--;
            B--;
        }
        if (s1 == 1) {
            res.append("1");
        }
        return res.reverse().toString();
    }

}
