package recall;

import java.util.Arrays;

/**
 * 排列序列
 *
 * @author 张烈文
 */
public class PermutationSequence {
    private boolean[] used;
    private int[] factorial;
    int n,m;
    public String getPermutation(int n,int k){
        this.n=n;
        this.m=k;
        used=new boolean[n+1];
        getFactorial(n);
        Arrays.fill(used,false);
        StringBuilder path=new StringBuilder();
        dfs(0,path);
        return path.toString();
    }
    private void dfs(int index,StringBuilder path){
        //递归结束条件当index深度等于n时结束
        if(index==n){
            return;
        }
        //这里是获取到当前剩余元素（n-1）的阶乘数，
        int cnt=factorial[n-index-1];
        for(int i=1;i<=n;i++){
            //如果当前元素已经被占用了则直接i++
            if(used[i]) continue;
            //如果当前剩余元素阶乘数<m(k)则代表我们所需要的序列不在以i开头的序列中，可直接跳过,并将我们所需要的序列的位置减去以i开头的元素个数
            if(cnt<m){
                m-=cnt;
                continue;
            }
            //当我们找到以i开头的元素时，则占用当前元素，并将index+1
            path.append(i);
            used[i]=true;
            dfs(index+1,path);
        }
    }
    private void getFactorial(int n){
        factorial=new int[n+1];
        factorial[0]=1;
        for(int i=1;i<=n;i++){
            factorial[i]=factorial[i-1]*i;
        }
    }
}
