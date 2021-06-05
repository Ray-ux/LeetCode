package prefixsum;

import java.util.*;

/**
 * 连续的子数组和
 *
 * @author 张烈文
 */
public class ContinuousSubarraySum {


    //    最简单的思路：算出所有大于2的子数组和并求余，若等于0直接返回true
    //    但是时间复杂度O(n^2)不满足题目

    public boolean checkSubarraySum(int[] nums, int k) {

        if (nums.length < 2) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int sum = nums[i];
            while (j < nums.length) {
                sum += nums[j++];
                if (sum % k == 0) {
                    return true;
                }
            }
        }
        return false;

    }

//    一般我们可以采用hash表来优化一层循环
//    同余定理：（a-b）/k==0,则说明a%k==b%k
//    计算前缀和:若出现两个pre[i],pre[j]前缀和的余数相同，且下标差>=2的则说明存在区间[i,j]和是k的倍数

    public boolean checkSubarraySum1(int[] nums, int k) {
        if (nums.length < 2) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
//        空的前缀和为0规定其下标为-1
        map.put(0, -1);
        int remainder = 0;
        for (int i = 0; i < nums.length; i++) {
//        （pre[i-1]-remainder）/k==0，所以我们只需要用余数remainder+nums[i]来求出当前前缀和的余数
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)) {
                int prevIndex = map.get(remainder);
                if (i-prevIndex>= 2) {
                    return true;
                }
            }else{
//                若map中没有该余数，则存入map,并记录下标
                map.put(remainder, i);
            }
        }
        return false;

    }




    }



