package sort;

/**
 * 三路快排
 * @author 张烈文
 */
public class ThreeWaysQuickSort {

//   以当前数组的第一个元素作为标定值，同时以左闭右闭
//    这里可以随机选订一个标定值然后和数组的第一个元素进行交换这样可以提高效率，但我并没有写

    public static void quickSort(int[] nums, int l, int r) {
//        递归终止条件
        if(l>=r){
            return;
        }
//         随机在nums[l...r]的范围中，选择一个数值作为标定点pivot
        swap(nums, l, (int) (Math.random() * (r - l + 1)) + l);
        int v = nums[l];
        int lt=l;    //nums[l+1...l2]<v
        int i = l + 1;  //nums[lt+1...i]==v
        int gt=r+1;    //nums[gt...r]>v
        while (i<gt) {
            if (nums[i] < v) {
                swap(nums, i++, ++lt);
            } else if (nums[i] > v) {
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
