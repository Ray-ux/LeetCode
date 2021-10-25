package math;

/**
 *
 * 调整数组顺序使奇数位于偶数前面   这里可以不考虑移动后的相对顺序
 * @author 张烈文
 * @date 2021/10/25 10:25
 */
public class ChangeArrayPosition {

    /**
     * 双指针法
     * 遇到奇数l++，遇到偶数将r与l所指元素交换，r--，
     * @param nums
     * @return
     */
    public int[] exchange(int[] nums) {
        int l=0,r=nums.length-1;
        while(l<r){
            if(nums[l]%2==1){
                l++;
            }else{
                int temp=nums[l];
                nums[l]=nums[r];
                nums[r--]=temp;
            }
        }
        return nums;
    }

    /**
     * 双指针法，i代表奇数的个数，j向后遍历数组，若遍历的当前数字为偶数则j++，若为奇数则需要先保存当前奇数，然后再将
     * [i,j-1]整体向后移动一位，最后再将之前保存的奇数插入到i所指向位置
     * @param array
     * @return
     */
    public int[] reOrderArray (int[] array) {
        int i=0;
        for (int j = 0; j < array.length; j++) {
            if (array[j] % 2 == 1) {
                int temp = array[j];
//                [i,j-1]整体向后移动一位，最后再将之前保存的奇数插入到i所指向位置
                for (int k = j - 1; k >= i; k--) {
                    array[k + 1] = array[k];
                }
                array[i++] = temp;
            }
        }
        return array;
    }
}
