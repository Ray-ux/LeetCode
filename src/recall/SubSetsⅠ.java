package recall;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 子集
 * @author 张烈文
 */
public class SubSetsⅠ {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        int len=nums.length;
        if(len==0){
            return res;
        }
        Deque<Integer> path=new ArrayDeque();
        dfs(0,len,nums,path,res);
        res.add(new ArrayList<>());
        return res;
    }

    private void dfs(int begin,int len,int[] nums,Deque<Integer> path,List<List<Integer>> res){
        // 这里不加也可以，因为当begin==len时是不会去执行下面的for循环的
        if(begin==len){
            return;
        }
        for(int i=begin;i<len;i++){
            path.addLast(nums[i]);
            //每当向path中添加时，res中也要添加
            res.add(new ArrayList(path));
            dfs(i+1,len,nums,path,res);
            path.removeLast();
        }
    }

}
