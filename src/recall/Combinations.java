package recall;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张烈文
 */
public class Combinations {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res=new ArrayList();
        if(k<=0||n<k){
            return res;
        }
        List<Integer> path=new ArrayList();
        dfs(1,n,k,path,res);
        return res;
    }
    private void dfs(int begin,int n,int k,List<Integer> path,List<List<Integer>> res){
        if(path.size()==k){
        // 如果直接res.add(path),将会出现结果集为空，因为每次都要对path进行回溯操作，到最后回溯完path为空
            res.add(new ArrayList(path));
            return;
        }
        // 重点是对剪枝的处理，剪去了不必要的搜索：搜索上界+接下来要选择的数的个数+1=n
        // 接下来要选择的数的个数=k-path.size()
        for(int i=begin;i<=n-(k-path.size())+1;i++){
            path.add(i);
            dfs(i+1,n,k,path,res);
            // 回溯，需要移除掉上一步所选值
            path.remove(path.size()-1);
        }
    }
}
