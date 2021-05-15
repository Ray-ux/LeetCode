package sort;

/**
 * 三路快排
 * @author 张烈文
 */
public class ThreeWaysQuickSort {

//   以当前数组的第一个元素作为标定值，同时以左闭右闭
    public static void quickSort(int[] nums, int l, int r) {
//        递归终止条件
        if(l>=r){
            return;
        }
        int lt=l;
        int i = l + 1;
        int gt=r+1;
        while (i<gt) {
            if (nums[i] < nums[l]) {
                swap(nums, i++, ++lt);
            } else if (nums[i] > nums[l]) {
                swap(nums, i, --gt);
            }else{
                i++;
            }
        }
        swap(nums, l, lt);
        quickSort(nums, l, lt - 1);
        quickSort(nums, gt, r);
    }

    private  static void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2, 7, 1, 3, 0};
        quickSort(nums, 0, 4);
        for (int num : nums
        ) {
            System.out.println(num);

        }
    }

}
