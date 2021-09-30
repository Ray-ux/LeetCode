package string;

/**
 * 反转字符串里的单词
 * @author 张烈文
 * @date 2021/9/30 22:11
 */
public class ReverseWordInString {


    /**
     * 不使用java内置的方法：split
     * 解法：
     * 1.移除多余空格
     * 2.将整个字符串反转
     * 3.再将每个单词反转即可
     * @param s
     * @return
     */
    public String reverseWords(String s) {
//        1.去除首尾以及中间字符串
        StringBuilder sb = removeSpace(s);
//        2.反转整个字符串
        reverseString(sb, 0, sb.length() - 1);
//        3.对每个单词再进行反转
        reverseEachWord(sb);
        return sb.toString();
    }

    private void reverseEachWord(StringBuilder array) {
        int start = 0, n = array.length();
        int end = 1;
        while (start < n) {
//            找到[start,end]区间内的单词，end<n防止越界
            while (end < n && array.charAt(end) != ' ') {
                end++;
            }
//            反转单词
            reverseString(array, start, end-1);
            start = end + 1;
            end = start + 1;
        }
    }

    private void reverseString(StringBuilder array, int start, int end) {
        while (start < end) {
            char c = array.charAt(start);
            array.setCharAt(start, array.charAt(end));
            array.setCharAt(end, c);
            start++;
            end--;
        }
    }

    private StringBuilder removeSpace(String s) {
        int start = 0;
        int end = s.length() - 1;
//        去除首部空格
        while (s.charAt(start)==' ') {
            start++;
        }
//        去除尾部空格
        while (s.charAt(end)==' '){
            end--;
        }
        StringBuilder sb = new StringBuilder();

        while (start <= end) {
            char c = s.charAt(start);
//        若当前字符不等于空格则添加到sb中，
//        若sb中的最后一个字符不是空格，而c是空格，则向sb结尾添加一个空格
            if (c != ' ' || sb.charAt(sb.length() - 1) != ' ') {
                sb.append(c);
            }
            start++;
        }
        return sb;

    }
}
