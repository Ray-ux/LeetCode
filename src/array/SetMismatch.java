package array;

import java.util.Arrays;

/**
 * 错误的集合
 *
 * @author 张烈文
 */
public class SetMismatch {
    /**
     * 使用哈希表统计每个元素出现次数，然后在 [1, n] 查询每个元素的出现次数。
     * 在哈希表中出现 2 次的为重复元素，未在哈希表中出现的元素为缺失元素
     * @param nums
     * @return
     */
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        for (int num:nums) {
            cnt[num]++;
        }
        int[] res = new int[2];
        for (int i = 1; i <=n; i++) {
            if (cnt[i] == 0) {
                res[1] = i;
            }
            if (cnt[i] == 2) {
                res[0] = i;
            }
        }
        return res;
    }
}
