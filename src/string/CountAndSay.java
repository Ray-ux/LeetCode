package string;

/**
 * 外观数列
 *
 * @author 张烈文
 */
public class CountAndSay {


    /**
     * 思路：通过一个pre来保存前一项字符串同时设置一个新的字符串tmp和count统计相同字符出现的次数
     * 然从pre字符串的第一位开始统计有多少位一样的数字，当出现当前字符与后一位字符不等的时候则先将当前count放到tmp的末尾，再将当前字符放到tmp末尾
     * 最好再将count重置为1
     * @param n
     * @return
     */
    public  String countAndSay(int n) {
        StringBuilder pre = new StringBuilder("1");

//        这里之所以从1开始，主要是因为我一开以及初始了pre
        for (int i = 1; i < n; i++) {
            StringBuilder tmp = new StringBuilder("");
            int count = 1;
            for (int j = 0; j <pre.length(); j++) {

//                注意边界条件
                if ((j+1)<pre.length()&& pre.charAt(j ) == pre.charAt(j+1)) {
                    ++count;
                }else{
                    tmp.append(count).append(pre.charAt(j));
//                    重置count为1
                    count = 1;
                }
            }
            pre = tmp;
        }
        return pre.toString();
    }

}
