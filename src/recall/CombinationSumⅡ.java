package recall;

import java.util.*;

/**
 * @author 张烈文
 */
public class CombinationSumⅡ {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        //升序
        Arrays.sort(candidates);
        Deque<Integer> path=new LinkedList<>();
        dfs(0, candidates, candidates.length,res,path,target);
        return res;
    }

    private void dfs(int begin, int[] candidates,int len, List<List<Integer>> res, Deque<Integer> path, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
        }
        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }
            //上一题的基础上加了这一句代码，i>begin旨在避免同一层的重复数字，但可以使不同层相同
            if (i > begin && candidates[i - 1] == candidates[i]) {
                continue;
            }
            path.addLast(candidates[i]);
            //由于元素不可以重复使用，这里递归下去的是i+1
            dfs(i + 1, candidates, len, res, path, target - candidates[i]);
            path.removeLast();
        }
    }
}
