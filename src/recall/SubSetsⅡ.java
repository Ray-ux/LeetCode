package recall;

import java.util.*;

/**
 * @author 张烈文
 */
public class SubSetsⅡ {

    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len == 0) {
            return res;
        }
//        先排序
        Arrays.sort(nums);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(len, nums, 0, res, path);
        return res;
    }
    private void dfs(int len, int[] nums, int begin, List<List<Integer>> res, Deque<Integer> path) {
        for (int i = begin; i < len; i++) {
//           这里实际上和组合总和Ⅱ中去重是一样的，当i>begin&&nums[i] == nums[i - 1]这个条件去除了同层
            if (i > begin && nums[i] == nums[i - 1]) {
                continue;
            }
            path.addLast(nums[i]);
            res.add(new ArrayList<>(path));
            dfs(len, nums, i + 1, res, path);
            path.removeLast();
        }
    }
}
