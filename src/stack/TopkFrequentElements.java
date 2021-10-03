package stack;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 前K个高频元素
 * @author 张烈文
 */
public class TopkFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
//        统计数组元素出现的次数
        for (int num:nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
//        构建大根堆,根据我们统计元素的次数来构建大根堆
        PriorityQueue<Integer> queue = new PriorityQueue((num1, num2) -> map.get(num2) - map.get(num1));
//        将数组元素添加进堆中
        for (int num:map.keySet()) {
            queue.add(num);
        }
//        弹出前K个堆顶元素
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
