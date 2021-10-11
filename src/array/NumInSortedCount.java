package array;

import java.util.Arrays;

/**
 * 数字在升序数组中出现的次数
 *
 * @author 张烈文
 * @date 2021/10/11 11:10
 */
public class NumInSortedCount {


    public int GetNumberOfK(int [] array , int k) {
//        1.找到数组中出现k的下标，若不存在index<0
        int index= Arrays.binarySearch(array,k);
        if(index<0) {
            return 0;
        }
        int cnt=1;
//        2.再从index位置向两边直接遍历
        for(int i=index+1;i<array.length;i++){
            if(array[i]==k) {
                cnt++;
            }
        }
        for(int i=index-1;i>=0;i--){
            if(array[i]==k) {
                cnt++;
            }
        }
        return cnt;
    }
}
