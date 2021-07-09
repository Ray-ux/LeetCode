package prefixsum;

import java.util.HashMap;

/**
 * 和相同的二元子数组
 *
 * @author 张烈文
 */
public class BinarySubarraysWithSum {

    /**
     * 思路：使用数组sum记录前缀和，然后一次遍历，判断该hash表是否存在sum[i]-goal的值
     * hash表的value记录hash前缀和中出现的
     * @param nums
     * @param goal
     * @return
     */
    public  static int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] sum = new int[n+1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }

        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int r = sum[i + 1];
            int l = r - goal;
            ans += map.getOrDefault(l, 0);
            map.put(r, map.getOrDefault(r, 0) + 1);
        }
        return ans;
    }


}
