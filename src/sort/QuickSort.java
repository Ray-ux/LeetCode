package sort;

/**
 * @author 张烈文
 */
public class QuickSort {

//    左闭右闭
    private static int partition(int[] nums, int l, int r) {

//        随机在[l...r]之间随机选择一个数值作为标定点pivot
        swap(nums, l, (int) (Math.random() * (r - l + 1)) + l);
        int v = nums[l];

        int j = l;
//        [l+1,j]<v,[j+1,i-1]>v
        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < v) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, l, j);
        return j;
    }

    //    递归使用快速排序对[l..r]的范围进行排序
    private static void sort(int[] nums, int l, int r) {
        if (l>=r) {
            return;
        }
        int p = partition(nums, l, r);
        sort(nums, l, p - 1);
        sort(nums, p + 1, r);
    }

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 2, 3, 7};
        sort(nums);

        for (int num:nums
             ) {
            System.out.println(num);

        }

    }
}
