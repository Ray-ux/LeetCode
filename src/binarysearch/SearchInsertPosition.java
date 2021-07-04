package binarysearch;

/**
 * 搜索插入位置
 * @author 张烈文
 */
public class SearchInsertPosition {
    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public int searchInsert(int[] nums, int target) {
        int l=0;
        int r=nums.length;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                return mid;
            }else if(target<nums[mid]){
                r=mid;
            }else {
                l=mid+1;
            }
        }
        return r;
    }
}
