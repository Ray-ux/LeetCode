package dynamic;

import java.util.Arrays;

/**
 *
 * 打家劫舍Ⅱ
 * @author 张烈文
 * @date 2021/7/14 9:20
 */
public class HouseRobberⅡ {

    /**
     * 第一想到的思路是：要么偷第一间，要么偷最后一间，将两个结果进行比较，剩下的就和打家劫舍一样的逻辑
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {

//        三个if的判断旨在使robber中的数组的数量大于等于2
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] first = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] end = Arrays.copyOfRange(nums, 1, nums.length);
        int ansF = robber(first);
        int ansE = robber(end);
        return ansF >= ansE ? ansF : ansE;

    }

    private int robber(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }

}
