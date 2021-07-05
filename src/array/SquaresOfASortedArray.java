package array;

/**
 *
 * 有序数组的平方
 * @author 张烈文
 */
public class SquaresOfASortedArray {
    /**
     * 双指针
     * 优化时间时，我们首先应该想到的是利用空间换时间的方法
     *
     * 一开始我只想着原地修改数组元素，导致出错
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        int[] ans=new int[nums.length];
        int l=0;
        int r=nums.length-1;
        int index=nums.length-1;
        while(l<=r){
            if(nums[l]*nums[l]>nums[r]*nums[r]){
                ans[index]=nums[l]*nums[l];
                l++;
            }else{
                ans[index]=nums[r]*nums[r];
                r--;
            }
            index--;
        }
        return ans;
    }
}
