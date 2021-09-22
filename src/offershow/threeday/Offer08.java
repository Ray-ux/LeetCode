package offershow.threeday;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 和大于等于target的最短子数组
 *
 * @author 张烈文
 * @date 2021/9/20 13:17
 */
public class Offer08 {

    /**
     * 前缀+二分
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int[] dp = new int[len+1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= len; i++) {
            dp[i] = dp[i - 1] + nums[i-1];
        }
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i <= len; i++) {
            int find = dp[i] + target;
            /*
            注意这里的函数 int index = Arrays.binarySearch(sums, target);如果找到就会返回值的下标，如果没找到就会返回一个负数，
            这个负数取反之后就是查找的值应该在数组中的位置举个例子，比如排序数组 [2，5，7，10，15，18，20] 如果我们查找 18，因为有
            这个数会返回 18 的下标 5，如果我们查找 9，因为没这个数会返回 -4（至于这个是怎么得到的，大家可以看下源码，这里不再过多展
            开讨论），我们对他取反之后就是3，也就是说如果我们在数组中添加一个 9，他在数组的下标是 3，也就是第 4 个位置（也可以这么理
            解，只要取反之后不是数组的长度，那么他就是原数组中第一个比他大的值的下标）
             */
            int index = Arrays.binarySearch(dp, find);
            if(index<0){
                index = ~index;
            }
            if (index <= len) {
                minLen = Math.min(minLen, index - i);
            }
        }
            return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }


    public int minSubArrayLen1(int target, int[] nums) {
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;

    }


}
