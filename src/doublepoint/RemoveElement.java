package doublepoint;

/**
 * 移除元素
 *
 * @author 张烈文
 * @date 2021/10/2 14:31
 */
public class RemoveElement {
    public int remove(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
