package offershow.threeday;

/**
 * 乘积小于K的子数组
 *
 * @author 张烈文
 * @date 2021/9/20 14:26
 */
public class Offer09 {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int len = nums.length;
        int count = 0;
        int right = len - 1;
        int prod = 1;
        for (int left = len - 1; left >= 0; left--) {
            prod *= nums[left];
            while (prod >= k) {
                prod /= nums[right];
                right--;
            }
            count += right - left + 1;
        }
        return count;
    }

    public int numSubarrayProductLessThanK1(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        }
        int left = 0;
        int count = 0;
        int prod = 1;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) {
                prod /= nums[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }
}
