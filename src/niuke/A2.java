package niuke;

/**
 * 替换空格
 * @author 张烈文
 * @date 2021/9/19 14:38
 */
public class A2 {

    /**
     * 思路一
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c==' '){
                res.append("%20");
            }else{
                res.append(c);
            }
        }
        return res.toString();
    }

    /**
     * 思路二
     * @param s
     * @return
     */
    public String replaceSpace1(String s) {
        return s.replaceAll(" ", "%20");
    }

}
