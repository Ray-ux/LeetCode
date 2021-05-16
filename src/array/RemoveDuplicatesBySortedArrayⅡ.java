package array;

/**
 * @author 张烈文
 */
public class RemoveDuplicatesBySortedArrayⅡ {

//    方法一
    public int removeDuplicates1(int[] nums){
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i] && nums[i] == nums[i + 1]) {
                continue;
            }
            nums[index++] = nums[i];
        }
        return index;
    }

//    方法二
    public int removeDuplicates2(int[] nums){
        //通过维持一个index保持2的距离来实现
        int index=2;
        //i指针一直向后移动，当i所指向元素不等于index-2（为什么是index-2，主要就是为了当有两个元素已经相同的情况）位置所指向元素时
        for(int i=2;i<nums.length;i++){
            if(nums[i]!=nums[index-2]){
                nums[index++]=nums[i];
            }
        }
        return index;
    }
}
