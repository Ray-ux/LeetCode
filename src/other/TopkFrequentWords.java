package other;

import java.util.*;

/**
 * @author 张烈文
 */
public class TopkFrequentWords {

    public  static List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> cnt = new HashMap<>();
//        统计次数
        for (String word : words) {
            cnt.put(word, cnt.getOrDefault(word, 0) + 1);
        }
//        创建一个最小优先队列来实现对
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//        当字符串出现次数相等时，便按字符串的字典序比较进行排序，否则就按照次数排序
                return o1.getValue().equals(o2.getValue()) ? o2.getKey().compareTo(o1.getKey()) : o1.getValue() - o2.getValue();
            }
        });

        for (Map.Entry<String, Integer> entry : cnt.entrySet()) {
//         将当前entry加入队列中
            pq.offer(entry);
//         当队列中的个数大于k时则弹出队首元素，由于是最小堆，每次都是弹出现有队列中的最小元素
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> ret = new ArrayList<>();
        while (!pq.isEmpty()) {
            ret.add(pq.poll().getKey());
        }
        Collections.reverse(ret);
        return ret;
    }




    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        List<String> strings = topKFrequent(words, 4);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
