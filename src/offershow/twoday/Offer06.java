package offershow.twoday;

import java.util.HashMap;

/**
 * 排序数组中的两个数字之和
 * @author 张烈文
 * @date 2021/9/19 11:30
 */
public class Offer06 {

    /**
     * 方法一：借助hashmap
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> temp = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if (temp.containsKey(target - numbers[i])) {
                if (i > temp.get(target - numbers[i])) {
                    res[0] = i;
                    res[1] = temp.get(target - numbers[i]);
                } else {
                    res[0] = temp.get(target - numbers[i]);
                    res[1] = i;
                }
            }
            temp.put(numbers[i], i);
        }
        return res;
    }

    /**
     * 由于题目已经告诉了是已经排好序的数组，因此我们合不考虑一下二分
     *
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum1(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l <= r) {
            int val = numbers[l] + numbers[r];
            if (val == target) {
                return new int[]{l, r};
            } else if (val > target) {
                r--;
            } else {
                l++;
            }
        }
        return new int[]{0, 0};

    }


}
