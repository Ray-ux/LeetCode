package string;

/**
 * 删除一个字符串中所有出现的字符串
 * @author 张烈文
 */
public class RemoveAllOccurrencesOfASubstring {
    public String removeOccurrences(String s, String part) {

        StringBuilder sub = new StringBuilder(s);
        while (sub.indexOf(part) != -1) {
            int index = sub.indexOf(part);
            sub.delete(index, index + part.length());

        }
        return sub.toString();


    }
}
