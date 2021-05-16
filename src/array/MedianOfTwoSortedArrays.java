package array;

/**
 * @author 张烈文
 */
public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int total=n+m;
        //偶数
        if(total%2==0){
            return (findKth(nums1,0,n-1,nums2,0,m-1,total/2)+findKth(nums1,0,n-1,nums2,0,m-1,total/2+1))/2.0;
        }
        //奇数
        return findKth(nums1,0,n-1,nums2,0,m-1,total/2+1);
    }

    private int findKth(int[] nums1,int start1,int end1,int[] nums2,int start2,int end2,int k){
        //计算当前数组还剩余的长度
        int len1=end1-start1+1;
        int len2=end2-start2+1;
        //默认让len1<len2当len1>len2的时候需要交换一下
        if(len1>len2){
            return  findKth(nums2,start2,end2,nums1,start1,end2,k);
        }
        //当len1==0,则直接返回nums2里的中位数即可
        if(len1==0){
            return nums2[start2+k-1];
        }
        //当k==1时，则代表只需要比较当前两个数组的起始位置大小
        if(k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }
        //获取当前数组的中位数的位置，start代表当前数组的起始位置，k/2与len比较防止越界
        int ia=start1+Math.min(k/2,len1),ib=start2=Math.min(k/2,len2);
        //比较两数组的k/2位置的元素大小
        if(nums1[ia-1]<nums2[ib-1]){
            return findKth(nums1,ia,end1,nums2,start2,end2,k-(ia-start1));
        }else{
            return findKth(nums1,start1,end1,nums2,ib,end2,k-(ib-start2));
        }
    }
}
