package sort;

/**
 * @author 张烈文
 */
public class SelectionSort {

    public static void selectSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] >nums[i]) {
                    int tmp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = tmp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] nums=new int[]{2, 7, 1, 3, 0};
        selectSort(nums);

        for (int num :nums
        ) {
            System.out.println(num);

        }
    }
}
