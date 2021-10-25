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
}
