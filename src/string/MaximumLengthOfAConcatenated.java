package string;

import java.util.*;

/**
 * 串联字符串和最大长度
 *
 * @author 张烈文
 */
public class MaximumLengthOfAConcatenated {


    /**
     * 时间复杂度o(n^2)
     * 思路：组合，然后开辟hash表在遍历看该字符串是否存在该字符
     * @param arr
     * @return
     */
    public  int maxLength(List<String> arr) {

        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder("");
        int maxLen = 0;
        dfs(0, arr, res, path);
        for (String inner : res) {
            HashMap<Character, Integer> map = new HashMap<>();
//            剪枝，如果长度已经大于26，说明一定有重复元素，因此直接剪枝
            if (inner.length() > 26) {
                continue;
            }
            int curLen = 0;
            for (int i = 0; i < inner.length(); i++) {
                if (map.containsKey(inner.charAt(i))) {
                    break;
                }else{
                    ++curLen;
                    map.put(inner.charAt(i), 1);
                }
            }
            if (curLen == inner.length() && curLen > maxLen) {
                maxLen = curLen;
            }
        }
        return maxLen;
    }

    /**
     * 组合出所有的可能
     * @param begin
     * @param arr
     * @param res
     * @param path
     */
    private  void dfs(int begin, List<String> arr, List<String> res, StringBuilder path) {
        for (int i = begin; i < arr.size(); i++) {
            path.append(arr.get(i));
            res.add(path.toString());
            dfs(i + 1, arr, res, path);
//            StringBuilder类的delete函数
            path.delete(path.length() - arr.get(i).length(), path.length());

        }
    }


}
