package offershow.threeday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组中和为0的三个数
 *
 * 三数之和
 * @author 张烈文
 * @date 2021/9/20 12:35
 */
public class Offer07 {

    /**
     * 思路：先排序
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i] >0) {
                break;
            }
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int r = len;
            int l = i + 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    while(l<r&&nums[r-1]==nums[r]) r--;
                    while(l<r&&nums[l]==nums[l+1]) l++;
                    res.add(Arrays.asList(nums[i], nums[l], nums[r--]));
                }else if (sum>0){
                    r--;
                }else{
                    l++;
                }
            }
        }
        return res;

    }
}
