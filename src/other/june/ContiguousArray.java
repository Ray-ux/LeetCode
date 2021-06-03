package other.june;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 连续数组
 * @author 张烈文
 */
public class ContiguousArray {
    /**
     * 此题由于要求子数组的0的个数和1的个数相等,那么我们只需将0转换为-1,如果当前子数组的和为0,则代表当前子数组的0和1的个数相等
     * 1.我们设置一个counter=0变量,遍历数组当遇到1时counter++,遇到0则counter--
     * 2.用map来记录当前下标得前缀和,初始值为map.put(0,-1)
     * 3.当我们遇到counter值并且map中与存在,那么我们就可以计算下标差,求最大值
     * @param nums
     * @return
     */
    public static int findMaxLength(int[] nums) {

        int maxLen = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int counter = 0;
        for (int i = 0; i < nums.length; i ++) {
            if (nums[i] == 1) {
                counter++;
            } else {
                counter--;
            }
            if (map.containsKey(counter)) {
                int preIndex = map.get(counter);
                maxLen = Math.max(maxLen, i - preIndex);
            } else {
                map.put(counter, i);
            }
        }
        return maxLen;
    }

}
