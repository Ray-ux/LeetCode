package bitoperation;

import java.util.HashMap;

/**
 * 只出现一次的数字Ⅲ
 * 要求：线性时间复杂度，常熟空间复杂度
 * @author 张烈文
 */
public class SingleNumberⅢ {


//    方式一：该方法时间复杂度不满足题目要求

    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int[] res = new int[2];
        int i=0;
        for (int num:nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        for (int key: count.keySet()) {
            if (count.get(key) == 1) {
                res[i++] = key;
            }
        }
        return res;
    }

//    方式二：具体思路，将两个只出现一次的数划分到两个数组中，且成对出现的数必须在同一组中
//
    public int[] singleNumber1(int[] nums) {
        int ret=0;
//        1.把所有的元素进行异或操作，最终得到一个异或值。因为是不同的两个数字，所以这个值必定不为 0；

        for(int num:nums){
            ret^=num;
        }
//        2.取异或值最后一个二进制位为1的数字作为mask，如果是1则表示两个数字在这一位上不同
        int mask = ret & (-ret);

        int a=0,b=0;
//        3.通过与这个 mask 进行与操作，如果为 0 的分为一个数组，为 1 的分为另一个数组。
        for(int num:nums){
//            这里相同的数都会分到同一组中
            if((mask&num)!=0){
                a^=num;
            }else {
                b^=num;
            }
        }
        return new int[]{a,b};
    }
}
