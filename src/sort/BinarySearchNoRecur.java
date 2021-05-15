package sort;

/**
 * @author 张烈文
 */
public class BinarySearchNoRecur {


    public static int binarySearch(int[] nums, int target) {
//        左闭右开
        int l=0;
        int r = nums.length;
        while(l<r){
//          向右移一位处理边界，另一种方式mid=l+(r-l)/2;
            int mid=(l+r)>>1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
//                由于是左闭因此l等于mid+1
                l=mid+1;
            }else{
//                由于右开因此r=mid
                r=mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{2, 4, 5, 7, 8}, 0));
    }

}
