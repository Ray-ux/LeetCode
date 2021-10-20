package math;

/**
 * 计算x的n次幂函数
 * @author 张烈文
 * @date 2021/10/20 21:53
 */
public class PowXN {

    /**
     * 快速幂算法
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
//        特殊处理，这里不做特殊处理的话后面1/0就会出错
        if (x == 0.0) {
            return x;
        }
//        指数小于0的话。需要将x变为1/x，n等于它的相反数
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        int res = 1;
        while (n > 0) {
//            若为奇数则取出相乘
            if ((n & 1) == 1) {
                res *= x;
            }
//           若为偶数，则将底数变为原来数的平方，并将指数除以2
            x *= x;
            n >>= 1;
        }
        return res;
    }
}
