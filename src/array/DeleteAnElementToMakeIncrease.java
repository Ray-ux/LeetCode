package array;

/**
 * 删除一个元素使数组严格递增
 *
 * @author 张烈文
 */
public class DeleteAnElementToMakeIncrease {

    /**
     * 一次枚举要删除的元素，然后判断删除之后的数组是否是严格递增函数
     * @param nums
     * @return
     */
    public boolean canBeIncreasing(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (check(nums, i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查删除一个元素后的数组是否是严格递增数组
     * 通过pre来保存上一个元素
     *
     * @param nums
     * @param x 代表要删除元素的位置
     * @return
     */
    private boolean check(int[] nums, int x) {

        int pre = -1;
        for (int i = 0; i < nums.length; i++) {
            if (i != x) {
                if (nums[i] <= pre) {
                    return false;
                }
                pre = nums[i];
            }
        }
        return true;
    }
}
