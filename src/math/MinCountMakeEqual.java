package math;

/**
 * 最小操作次数使数组元素相等
 * @author 张烈文
 * @date 2021/10/20 10:55
 */
public class MinCountMakeEqual {

    /**
     * t:最终元素值,min:最小值，ans：最小操作次数,n：数组大小,sum：原数组的总和
     * 存在关系：ans=(t*n-sum)/(n-1)
     * 数学推导：t=min+ans
     * 最终：ans=sum-min*n
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int n=nums.length;
        int min=nums[0];
        int sum=0;
        for(int num:nums){
            min=Math.min(min,num);
            sum+=num;
        }
        return sum-min*n;
    }
}
