package sort;

import java.util.Arrays;

/**
 * @author 张烈文
 */
public class MergeSort {


    public static void mergeSort(int[] nums) {

        sort(nums, 0, nums.length - 1);
    }

//  左闭右闭
    private static void sort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (r + l) / 2;
        sort(nums, l, mid);
        sort(nums, mid + 1, r);
        merge(nums,l,mid,r);
    }

//    合并两个数组
    private static void merge(int[] nums, int l, int mid, int r) {
//       拷贝一份新的数组
        int[] temp = Arrays.copyOfRange(nums, l, r + 1);
//        左边一半的起始下标
        int i = l;
//        右边一半的起使下标
        int j = mid + 1;
        for (int k = l; k <= r; k++) {

//            当i>mid时，代表左边的一半数组已经遍历完了
            if (i > mid) {
                nums[k] = temp[j - l];
                j++;
//            当j>r时，右边数组已经遍历完
            } else if (j > r) {
                nums[k] = temp[i - l];
                i++;
            } else if (temp[i - l] > temp[j - l]) {
                nums[k] = temp[j - l];
                j++;
            }else{
                nums[k] = temp[i - l];
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2, 7, 1, 3, 0};
        mergeSort(nums);

        for (int num :nums
        ) {
            System.out.println(num);

        }
    }
}
