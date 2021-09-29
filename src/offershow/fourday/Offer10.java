package offershow.fourday;

import java.util.HashMap;

/**
 * @author 张烈文
 * @date 2021/9/21 21:12
 */
public class Offer10 {


    /**
     * 很明显我们如果要找出子数组内0和1数量相同，只需求和为0即可
     * @param nums
     * @return
     */
    public  int findMaxLength(int[] nums) {
        /*
         *将数组中的0全变为-1
         */
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
//        这里直接参考上一题思路
        int preSum = 0;
//        key：前缀和，value：下标
        HashMap<Integer, Integer> ans = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
//            ans.get()
        }

        return 0;
    }

}
