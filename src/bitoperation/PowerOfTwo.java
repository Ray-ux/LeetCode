package bitoperation;

/**
 * 2的幂
 *
 * @author 张烈文
 */
public class PowerOfTwo {

//   思路1：若n<=0时直接返回false,若n>=1则统计1的个数，因为如果该数是2的幂次，那么将其转为2进制后，仅有一位是1

    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                ++count;
            }
            n >>= 1;
        }
        return count == 1 ? true : false;
    }

    //    思路2：
    public boolean isPowerOfTwo1(int n) {

        return n > 0 && (n & (n - 1)) == 0;
    }
}
