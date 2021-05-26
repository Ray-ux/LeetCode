package recall;

import java.util.*;

/**
 * @author 张烈文
 */
public class PermutationsⅡ {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList();
        int len=nums.length;
        if(len==0){
            return res;
        }
        Deque<Integer> path=new LinkedList();
        boolean[] used=new boolean[len];
//        排序，从小到大
        Arrays.sort(nums);
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
//                如果当前的数等于前一个数，且前一个数没有被用过，那么说明当前分支将与前一分支重复，则进行剪枝
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {continue;}
                path.addLast(nums[i]);
                used[i] = true;
                dfs(res, nums, len, used, path);
                used[i] = false;
                path.removeLast();

            }
        }
    }
}
