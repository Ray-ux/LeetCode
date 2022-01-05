package oneday;

/**
 * 替换所有的问号
 *
 * @author 张烈文
 * @date 2022/1/5 20:52
 */
public class ReplaceWhy {
    public static String modifyString(String s) {
        char[] ss=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(ss[i]=='?'){
                char pre = (i == 0 ? 'A' : ss[i - 1]);
                char after = (i == s.length() - 1 ? 'A' : ss[i + 1]);
                ss[i]='a';
                while (pre == ss[i] || after == ss[i]) {
                    ++ss[i];
                }
            }
        }
        return new String(ss);
    }

    public static void main(String[] args) {
        System.out.println(Math.random()*26);
    }
}
