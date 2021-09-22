package offershow.fourday;

import java.util.HashMap;

/**
 * 0和1个数相同的子数组
 * @author 张烈文
 * @date 2021/9/22 10:35
 */
public class Offer11 {

    /**
     * 这里我们考虑：由于要求相同数量的0和1，那么我们是不是可以直接将0变为-1呢？
     * 若两者的个数相同，那么它们的和就为0
     *
     * @param nums
     * @return
     */
    public static int findMaxLength(int[] nums) {
        int maxLen = 0;
//        key
        HashMap<Integer, Integer> ans = new HashMap<>();
        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        ans.put(0, 0);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if (ans.containsKey(preSum)) {
                maxLen = Math.max(maxLen, (i+1)-ans.get(preSum) );
            }
            ans.put(preSum, Math.min(ans.getOrDefault(preSum, i+1), i+1));
        }
        return maxLen;
    }

    public static void main(String[] args) {
        findMaxLength(new int[]{0, 1,0});
    }
}
