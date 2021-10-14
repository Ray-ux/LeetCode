package binarysearch;

/**
 * 山脉数组的封顶索引
 * @author 张烈文
 * @date 2021/10/14 20:35
 */
public class SearchMountIndex {

    /**
     * 二分
     * arr[i-1]<arr[i]
     * [1,n-1]中查找
     * @param arr
     * @return
     */
    public  int peakIndexInMountainArray(int[] arr) {
        int l=1;
        int r=arr.length-1;
        while(l<r){
            int mid = l + r + 1 >> 1;
            if(arr[mid-1]<arr[mid]){
                l=mid;
            }else{
                r=mid-1;
            }
        }
        return r;
    }

    /**
     * 暴力解法 O(n)
     * @param arr
     * @return
     */
    public  int peakIndexInMountainArray1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return i;
            }
        }
        return -1;
    }


}
