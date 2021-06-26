package recall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字符串的排列
 * @author 张烈文
 */
public class StringPrermutation {

    public String[] permutation(String s) {
        int length = s.length();
        boolean[] used = new boolean[length];
        List<String> tmp = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        StringBuilder path = new StringBuilder();
        dfs(chars, tmp, path, used);
//        根据阿里巴巴编码规范，用集合类转化为数组时建议将参数的空间置为0
        return tmp.toArray(new String[0]);
    }

    private void dfs(char[] s, List<String> res, StringBuilder path,boolean[] used) {
        if (path.length() == s.length) {
            res.add(path.toString());
        }

        for (int i = 0; i < s.length; i++) {
            if (i>0&&s[i-1]==s[i]&&!used[i-1]) {
                continue;
            }
            if (used[i]) {
               continue;
            }
            path.append(s[i]);
            used[i] = true;
            dfs(s, res, path, used);
            path.delete(path.length() - 1, path.length());
            used[i] = false;
        }
    }

}
