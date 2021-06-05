package string;

/**
 * 验证回文串
 * @author 张烈文
 */
public class ValidPalindrome {

    /**
     * 思路一： 将字符串转换为小写，双指针，若不再[0,9]且不在[a,z]区间则++或--，如果不等则直接返回false
     * @param s
     * @return
     */
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        String s1 = s.toLowerCase();
        while (i < j) {
            char si = s1.charAt(i);
            char sj = s1.charAt(j);

            if (!(si>='0'&&si<='9')&&!(si >= 'a' && si <= 'z')) {
                i++;
                continue;
            }
            if (!(sj>='0'&&sj<='9')&&!(sj >= 'a' && sj <= 'z')) {
                j--;
                continue;
            }
            if (si != sj) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    /**
     * 思路二：先将所有在[a,z]或[0,9]的字符取出来放在StringBuilder中在按常规判断回文串
     * @param s
     * @return
     */
    public boolean isPalindrome1(String s) {
             String sL = s.toLowerCase();
             StringBuilder str = new StringBuilder();
             for (char c : sL.toCharArray()) {
                 if((c>='a'&&c<='z')||(c>='0'&&c<='9')){
                     str.append(c);
                 }
             }
             int len = str.length();
             int i = 0, j = len - 1;
             char[] cs = str.toString().toCharArray();
             while(i<=j){
                 if(cs[i]!=cs[j]){
                     return false;
                 }
                 i++;
                 j--;
             }
            return true;
    }
}
