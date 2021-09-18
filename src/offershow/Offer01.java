package offershow;

/**
 *
 * 整数除法
 * @author 张烈文
 * @date 2021/9/18 11:44
 */
public class Offer01 {
        public  int divide(int a, int b) {
//            处理边界情况：由于java对Integer.MIN_VALUE的绝对值的处理，因此需要做特殊处理
            if (a == Integer.MIN_VALUE && b == -1) {
                return Integer.MAX_VALUE;
            }

        /*
            判断是否同号，同号则 结果为正数
         */
            boolean flag = false;
            if ((a<0 && b<0) || (a>0 && b>0)) {
                flag = true;
            }

            long dividend = Math.abs((long) a);
            long divisor = Math.abs((long) b);
            if (dividend < divisor) {
                return 0;
            }
        /*
            计算 结果的绝对值
         */
            int result = 0;
            int shift = 31;
            while (dividend >= divisor) {
                while (dividend < divisor << shift) {
                    shift--;
                }
                dividend -= divisor << shift;
                result += 1 << shift;
            }

            return flag ? result : -result;
        }



}
