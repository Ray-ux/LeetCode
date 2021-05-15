package sort;

/**
 * @author 张烈文
 */
public class InsertSort {

    public static void insertSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
//           通过定义一个copy变量来减少时间复杂度
            int copy=nums[i];
            int j;
//            寻找待插入元素的位置
            for (j = i; j > 0 && nums[j-1] >= copy; j--) {
                nums[j] = nums[j - 1];
            }
//            在待插入的位置插入之前保存的变量值
            nums[j] = copy;
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2, 7, 1, 3, 0};
        insertSort(nums);

        for (int num :nums
        ) {
            System.out.println(num);

        }
    }
}
