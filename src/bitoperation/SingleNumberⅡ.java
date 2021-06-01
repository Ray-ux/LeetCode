package bitoperation;

/**
 * 只出现一次的数字Ⅱ
 * @author 张烈文
 */
public class SingleNumberⅡ {

    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
//                统计每个位置上出现的1的个数
                counts[j] += num & 1;
                num >>>= 1;
            }
        }

        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            //左移一位
            res <<= 1;
            //恢复第i位的值到res
            res |= counts[31 - i] % m;
        }
        return res;
    }
}
