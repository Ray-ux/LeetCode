package array;

/**
 *
 * @author 张烈文
 */
public class RemoveDuplicatesBySortedArrayⅠ {
    public int removeDuplicates(int[] nums) {
//        双指针
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
