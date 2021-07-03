package string;

import java.util.*;

/**
 * 根据字符出现的频率排序
 *
 * @author 张烈文
 */
public class SortCharactersByFrequency {

    /**
     * 先用HashMap统计次数，然后变为List，按照value值排序即可
     * @param s
     * @return
     */
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder res = new StringBuilder();

        for (Character c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, ((o1, o2) -> o2.getValue() - o1.getValue()));
        for (Map.Entry<Character,Integer> entry:list) {
            for (int i = 1; i <= entry.getValue(); i++) {
                res.append(entry.getKey());
            }
        }

        return res.toString();
    }

}
