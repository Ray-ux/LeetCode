package offershow.fourday;

/**
 * 左右两边子数组的和相等
 *
 * @author 张烈文
 * @date 2021/9/22 12:02
 */
public class Offer12 {

    public int pivotIndex(int[] nums) {
        int sum = 0;
        int preSum = 0;
        for (int num : nums) {
            sum += num;
        }
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            if ((preSum - nums[i]) == (sum - preSum)) {
                return i;
            }
        }
        return -1;
    }
}
