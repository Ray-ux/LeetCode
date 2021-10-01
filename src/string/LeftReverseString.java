package string;

/**
 * 左旋转字符串
 *
 * @author 张烈文
 * @date 2021/10/1 21:01
 */
public class LeftReverseString {


    /**
     * 自己的思路：
     * 1.先截取0-n的字符串
     * 2.然后将n之后字符串向前移
     * 3.最后再将之前截取的字符串添加到结尾即可
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords1(String s, int n) {
        int len=s.length();
        StringBuilder temp=new StringBuilder(s);
        String str=s.substring(0,n);
        int start=0;
        for(int end=n;end<len;end++,start++){
            temp.setCharAt(start,temp.charAt(end));
        }
        for(int i=0;start<len;i++){
            temp.setCharAt(start,str.charAt(i));
            start++;
        }
        return temp.toString();

    }
    /**
     * 反转区间为0-n的字符串
     * 反转区间n-len-1的字符串
     * 反转整个字符串
     *
     * @param s
     * @param n
     * @return
     */
    public String reverseLeftWords(String s, int n) {
        StringBuilder str = new StringBuilder(s);
        reverse(str, 0, n - 1);
        reverse(str, n, s.length() - 1);
        return str.reverse().toString();
    }

    private void reverse(StringBuilder str, int start, int end) {
        while (start < end) {
            char c = str.charAt(start);
            str.setCharAt(start, str.charAt(end));
            str.setCharAt(end, c);
            start++;
            end++;
        }
    }


}
