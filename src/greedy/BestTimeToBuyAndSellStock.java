package greedy;

/**
 * 买卖股票的最佳时机
 *
 * @author 张烈文
 * @date 2021/7/15 11:14
 */
public class BestTimeToBuyAndSellStock {


    /**
     * 首先想到的思路：用一个min变量来保存当前遍历的[0,i]区间内的最小值，然后用max来记录一次向后遍历
     * 如果出现大于min的则比较大小max=Math.max(max,prices[i]-min);否则min=price[i]
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
//        假设初始化购买第一支股票
        int min=prices[0];
        int max=0;
//        向后遍历，遇到小于min则赋值，否则prices[i]-min与当前max比较，最后返回max即可
        for(int i=1;i<prices.length;i++){
            if(prices[i]<=min){
                min=prices[i];
            }else{
                max=Math.max(max,prices[i]-min);
            }
        }
        return max;
    }
}
