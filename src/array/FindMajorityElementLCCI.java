package array;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * 主要元素
 * @author 张烈文
 */
public class FindMajorityElementLCCI {
    public int majorityElement(int[] nums) {
        int n = nums.length / 2;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry e : map.entrySet()) {
            if ((int) e.getValue() > n) {
                return (int) e.getKey();
            }
        }

        return -1;

    }
}
