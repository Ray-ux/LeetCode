package recall;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 全排列
 * @author 张烈文
 */
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        int len=nums.length;
        if(len==0){
            return res;
        }
        Deque<Integer> path=new LinkedList();
        boolean[] used=new boolean[len];
        dfs(res,nums,len,used,path);
        return res;
    }

    private void dfs(List<List<Integer>> res,int[] nums,int len,boolean[] used,Deque<Integer> path){
        if(path.size()==len){
            res.add(new ArrayList(path));
            return;
        }
        for(int i=0;i<len;i++) {
            if (!used[i]) {
                path.addLast(nums[i]);
                used[i] = true;
                dfs(res, nums, len, used, path);
                used[i] = false;
                path.removeLast();

            }
        }
    }
}
