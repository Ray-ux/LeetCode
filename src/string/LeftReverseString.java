package string;

/**
 * 左旋转字符串
 *
 * @author 张烈文
 * @date 2021/10/1 21:01
 */
public class LeftReverseString {
    public  static String reverseLeftWords(String s, int n) {
        int len = s.length();
        char[] array = s.toCharArray();
        String substring = s.substring(0, n);
        int start = 0;
        for (int i = n; i < len; i++) {
            array[start++] = array[i];
        }
        for (int i = 0; i < substring.length(); i++) {
            array[start++] = substring.charAt(i);
        }
        return array.toString();
    }

    public static void main(String[] args) {
        reverseLeftWords("abcdefg", 2);
    }
}
