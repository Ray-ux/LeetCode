package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 张烈文
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
//        先将数组升序
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
//            若当前值等于前一个值则直接进行下一次循环，去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
//            若当前值已经大于0了，由于是升序因此不可能三数之和等于0了
            if (nums[i] > 0) {
                break;
            }
            int l = i + 1;
            int r = len-1;
//            开始左右夹逼
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l + 1] == nums[l]) {
                        l++;
                    }
                    while (l < r && nums[r - 1] == nums[r]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum < 0) {
                    l++;
                }else {
                    r++;
                }
            }
        }
        return res;
    }
}
