package bitoperation;

/**
 * 求1+2+3...+n
 *  要求不能使用乘除法，for，while，if,else,switch,case等关键字
 * @author 张烈文
 * @date 2021/10/19 21:04
 */
public class SumOneToN {

    /**
     * 这是一个等差数列，sum=(a1+an)n/2=>(1+n)n/2=>(n+n^2)/2；Math.pow(a,b)表示a^b；右移一位相当于除以2。
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int sum=(int)Math.pow(n,2)+n;
        return sum>>1;
    }
}
