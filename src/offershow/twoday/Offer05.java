package offershow.twoday;

/**
 * 单词长度的最大乘积
 *
 * @author 张烈文
 * @date 2021/9/19 10:42
 */
public class Offer05 {

    /**
     * 暴力解法
     *
     * @param words
     * @return
     */
    public static int maxProduct(String[] words) {
        int maxLen = 0;
        for (int i = 0; i < words.length-1; i++) {
            for (int j = i + 1; j < words.length; j++) {
                String s1 = words[i];
                String s2 = words[j];
                int flag = -1;
                for (char c : s1.toCharArray()) {
                    flag = s2.indexOf(c);
                    if (flag != -1) {
                        break;

                    }
                }
                if (flag==-1) {
                    int curLen = s1.length() * s2.length();
                    maxLen = curLen > maxLen ? curLen : maxLen;
                }
            }
        }
        return maxLen;
    }


    /**
     * 利用位运算。
     * 此题我们巧妙的将每个字符串转换为了一个整型数字，并通过位运算来记录整型数字
     * @param words
     * @return
     */
    public static int maxProduct1(String[] words) {

        int len = words.length;
//        利用数字来代表每一个字符串
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
//           遍历每个字符串中的字符，并移位记录该字符串中的每一个字符到nums
            for (char c : words[i].toCharArray()) {
//                进行或运算记录
                nums[i] |= (1 << (c - 'a'));
            }
        }
//        记录两个字符串乘积的最大值
        int maxLen = 0;
        for (int i = 0; i < len - 1;i++) {
            for (int j = i + 1; j < len; j++) {
//                如果两个字符没有重复的字符，那么他们的与&运算就应该为0
                if ((nums[i] & nums[j]) == 0) {
                    int curRes = words[i].length() * words[j].length();
                    maxLen = curRes > maxLen ? curRes : maxLen;
                }
            }
        }
        return maxLen;
    }



}
