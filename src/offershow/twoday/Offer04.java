package offershow.twoday;

/**
 *
 * 只出现一次的数字
 * @author 张烈文
 * @date 2021/9/19 10:01
 */
public class Offer04 {

    /**
     * 通过计算每个位置上出现1的个数，每个位置
     * @param nums
     * @return
     */
    public static int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
//                统计该位置上的1出现的次数，这里统计的是倒置
                counts[j] += num & 1;
//                统计完最右边一位，然后右移
                num >>= 1;
            }
        }

        int res = 0;
        for (int j = 0; j < 32; j++) {
//            先移位，后运算，如果先运算后移位，可能导致得到结果后在往做移动一位，导致结果不对
            res <<= 1;
//            先对该位置的次数%3然后倒置还原数字
            res |= counts[31 - j] % 3;
        }

        return res;
    }

}
