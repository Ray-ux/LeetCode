package recall;

import java.util.*;

/**
 * 组合总和Ⅰ
 *
 * @author 张烈文
 */
public class CombinationSumⅠ {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new LinkedList<>();
        //升序
        Arrays.sort(candidates);
        dfs(0, candidates, res, path, candidates.length, target);
        return res;
    }

    private void dfs(int begin, int[] candidates, List<List<Integer>> res, Deque<Integer> path, int len, int target) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        //通过begin变量来进行了剪枝
        for (int i = begin; i < len; i++) {
            //由于数组已经升序，因此target-数组当前值小于0时则没必要在循环了，直接终止
            if (target - candidates[i] < 0) {
                break;
            }
            path.addLast(candidates[i]);
            dfs(i, candidates, res, path, len, target - candidates[i]);
            path.removeLast();
        }

    }
}
