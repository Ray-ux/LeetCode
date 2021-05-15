package sort;

/**
 * @author 张烈文
 */
public class BubbleSort {


    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (nums[j] <nums[j-1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j -1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2, 7, 1, 3, 0};
        bubbleSort(nums);

        for (int num :nums
        ) {
            System.out.println(num);

        }
    }
}
