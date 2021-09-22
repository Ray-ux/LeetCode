package offershow.fourday;

import java.util.HashMap;

/**
 * @author 张烈文
 * @date 2021/9/21 21:12
 */
public class Offer10 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int preSum = 0;
        HashMap<Integer, Integer> ans = new HashMap<>();
        ans.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            count += ans.getOrDefault(preSum - k, 0);
            ans.put(preSum, ans.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }


}
