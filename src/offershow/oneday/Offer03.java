package offershow.oneday;

/**
 *
 * 前n个数字二进制中1的个数
 * @author 张烈文
 * @date 2021/9/18 20:07
 */
public class Offer03 {


    /**
     * 解法一：遍历一次求出每个数字中二进制的个数
     * @param n
     * @return
     */
    public  int[] countBits(int n) {
        int[] res = new int[n + 1];
        for (int i=n;i>=1;i--) {
            int count = 0;
            int temp = i;
            while (temp != 0) {
                if ((temp & 1) == 1) {
                    count++;
                }
                temp >>= 1;
            }
            res[i] = count;
        }
        return res;
    }

    /**
     * 解法二：利用二进制数字i中1的个数比i&(i-1)多1
     * @param n
     * @return
     */
    public  int[] countBits1(int n) {
        int[] res = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            res[i] = res[i & (i - 1)] + 1;
        }
        return res;
    }



}
