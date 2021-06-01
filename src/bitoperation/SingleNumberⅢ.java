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
        //               1.先将所有数进行与运算，结果为两个出现一次的数的与值

        for(int num:nums){
            ret^=num;
        }
        int div=1;
//        找到结果与中，位为1的位置
        while((div&ret)==0){
            div<<=1;
        }

        int a=0,b=0;
//        将数组分为两组，每组中均有一个仅出现一次的数，其余都是出现两次的数
        for(int num:nums){
            if((div&num)!=0){
                a^=num;
            }else {
                b^=num;
            }
        }
        return new int[]{a,b};
    }
}
