package other;

/**
 * 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 * @author 张烈文
 */
public class EatCandies {


    /**
     * 此题一定要注意整形溢出的问题
     * @param candiesCount
     * @param queries
     * @return
     */
    public boolean[] canEat(int[] candiesCount, int[][] queries) {

        int len=candiesCount.length;
        // 开辟sum数组来记录前缀和
        long[] sum=new long[len];
        sum[0]=candiesCount[0];
        for(int i=1;i<len;i++){
            sum[i]=sum[i-1]+candiesCount[i];
        }
        int q=queries.length;
        boolean[] res=new boolean[q];
        for(int i=0;i<q;i++){
            int[] query=queries[i];
            int favoriteType=query[0],favoriteDay=query[1],dailyCap=query[2];

            // 计算最少要吃的糖的数量,由于时从第0天开始，因此最少每天吃一颗，总共最少就要吃favorateDay+1颗糖
            long x1=favoriteDay+1;
            // 计算最多要吃的糖的数量，每天吃dailyCap个糖要吃favoriteDay+1天
            long y1=dailyCap*(long)(favoriteDay+1);
            // 找到最少应该要吃favoriteType之前的糖的总和并加1代表还要吃1颗favoriteType类型的糖
            long x2=favoriteType==0?1:sum[favoriteType-1]+1;
            // 找到最多可以吃糖的数量
            long y2=sum[favoriteType];
            // 若最少要吃的糖的数量比最多可以吃糖的数量还多，证明，无法迟到favoriteType的糖
            // 若最多吃的糖的数量，比最少应该吃的糖的数量少，证明，无法吃到favoriteType的糖
            res[i]=!(x1>y2||y1<x2);
        }
        return res;
    }
}
