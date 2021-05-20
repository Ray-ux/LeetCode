package heap;

import java.util.*;

/**
 * @author 张烈文
 */
public class TopkFrequentWords {

    //    方法一小根堆
    public static List<String> topKFrequent1(String[] words, int k) {

        // 1.先用哈希表统计单词出现的频率
        Map<String, Integer> count = new HashMap();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        // 2.构建小根堆 这里需要自己构建比较规则 此处为 lambda 写法 Java 的优先队列默认实现就是小根堆
        PriorityQueue<String> minHeap = new PriorityQueue<>((s1, s2) -> {
            if (count.get(s1).equals(count.get(s2))) {
                return s2.compareTo(s1);
            } else {
                return count.get(s1) - count.get(s2);
            }
        });
        // 3.依次向堆加入元素。
        for (String s : count.keySet()) {
            minHeap.offer(s);
            // 当堆中元素个数大于 k 个的时候，需要弹出堆顶最小的元素。
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        // 4.依次弹出堆中的 K 个元素，放入结果集合中。
        List<String> res = new ArrayList<String>(k);
        while (minHeap.size() > 0) {
            res.add(minHeap.poll());
        }
        // 5.注意最后需要反转元素的顺序。
        Collections.reverse(res);
        return res;
    }

        //  方法二利用哈希表排序然后返回前K个元素


    public List<String> topKFrequent2(String[] words, int k) {

        // 1.初始化 哈希表 key -> 字符串 value -> 出现的次数。
        Map<String, Integer> count = new HashMap<>();
        for (String word : words) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        // 2.用 list 存储字符 key 然后自定义 Comparator 比较器对 value 进行排序。
        List<String> candidates = new ArrayList<>(count.keySet());
        // 此处为使用 lambda 写法
        candidates.sort((a, b) -> {
            // 字符串频率相等按照字典序比较使得大的在堆顶,Java 可以直接使用 compareTo 方法即可。
            if (count.get(a).equals(count.get(b))) {
                return a.compareTo(b);
            } else {
                // 字符串频率不等则按照频率排列。
                return count.get(b) - count.get(a);
            }
        });
        // 3.截取前 K 大个高频单词返回结果。
        return candidates.subList(0, k);
    }


    public static void main(String[] args) {
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};

        List<String> strings = topKFrequent1(words, 4);
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
