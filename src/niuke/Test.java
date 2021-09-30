package niuke;

import java.util.HashMap;

/**
 * @author 张烈文
 * @date 2021/9/27 10:07
 */
public class Test {
    public int subarraySum(int[] nums, int k) {
//        记录前缀和
        int preSum = 0;
//        key：前缀和，value：当前前缀和出现的次数
        int count = 0;
        HashMap<Integer, Integer> ans = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            count += ans.getOrDefault(preSum - k, 0);
            ans.put(preSum, ans.getOrDefault(preSum, 0) + 1);
        }
        return count;

    }
}
