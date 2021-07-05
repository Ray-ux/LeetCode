package array;

/**
 * 旋转数组
 * @author 张烈文
 *
 */
public class RotateArray {

    /**
     * 思路一：计算数组中每个元素的新的位置，然后遍历写入即可
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int index = (i + k) % n;
            ans[index] = nums[i];
        }
        for (int i = 0; i < n; i++) {
            nums[i] = ans[i];
        }
    }

    /**
     * 思路二：每次只移动一步，一共需要移动k%nums.length次，每次移动时保存首元素，移动完一次后将保存的首元素赋值到nums[1]
     * 时间复杂度:O(n^2) 超时了
     * 空间复杂度：O(1)
     * @param nums
     * @param k
     */
    public void rotate1(int[] nums, int k) {
        int count = k % nums.length;
        for (int i = 0; i < count; i++) {
            int tmp = nums[0];
            for (int j = nums.length; j >0; j--) {
                int index=j%nums.length;
                nums[index] = nums[j - 1];
            }
            nums[1] = tmp;
        }
    }
}
