package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 大餐计数
 *
 * @author 张烈文
 */
public class CountGoodMeals {

    /**
     * 思路一：一个朴素的想法是，从前往后遍历数组中的所有数，当遍历到下标 i 的时候，回头检查下标小于 i 的数是否能够与 deliciousness[i] 相加形成 2 的幂。
     * 该种方式O(n^2)超出时间了
     * @param deliciousness
     * @return
     */
    public int countPairs(int[] deliciousness) {
        int n = deliciousness.length;
        int mod = 1000000007;
        int ans = 0;
        HashMap<Long, Integer> map = new HashMap();
        for (int i = 0; i < n; i++) {
            long x = deliciousness[i];
            for (Map.Entry e: map.entrySet()) {
                long value = x + (Long) e.getKey();
                if (check(value)){
                    ans += (Integer)e.getValue();
                }
            }
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return (int) (ans % mod);
    }

    private boolean check(long value) {
        return (value > 0) && (value & (value - 1)) == 0;
    }
}
