package bitoperation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 重复的DNA序列
 *
 * @author 张烈文
 */
public class RepeatedDNASequences {

//    保持窗口大小一直为10，将当前窗口中的字符串加入map中，若map中已存在则++
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> count = new HashMap<>();
//        注意这里的i<=s.length() - 10的情况
        for (int i = 0; i <= s.length() - 10; i++) {
            int j = i + 10;
            String childSq = s.substring(i, j);
            count.put(childSq, count.getOrDefault(childSq, 0) + 1);
        }
        for (String key : count.keySet()) {
            if (count.get(key) > 1) {
                res.add(key);
            }
        }
        return res;
    }
}
