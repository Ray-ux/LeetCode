package array;

/**
 * 旋转数组的最小数字
 *
 * @author 张烈文
 * @date 2021/10/11 11:59
 */
public class MinNumInRotateArray {

    /**
     * 性质：做排序数组任意元素>=右排序数组任意元素
     * @param numbers
     * @return
     */
    public int minArray(int[] numbers) {

        int l = 0;
        int r = numbers.length - 1;
        while(l<r){
            int mid = l + ((r - l) >> 1);
//            旋转点落在了数组[mid,r]
            if (numbers[mid] > numbers[r]) {
                l=mid+1;
            } else if (numbers[mid] > numbers[r]) {
                r = mid;
            }else{
//                去重
                r--;
            }
        }
        return numbers[l];

    }

}
