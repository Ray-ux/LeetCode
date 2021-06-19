package stack;

/**
 * 柱状图中最大的矩形
 *
 * @author 张烈文
 */
public class LargestRectangleInHistogram {

    /**
     * 暴力解法：O(n^2)
     * 枚举所有可能
     *
     * 枚举宽，使用两重循环枚举矩形的左右边界以固定宽度w，矩形的高为该区域内的最小高度h，面积为w*h
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        int ans = 0;
        for (int left = 0; left < n; left++) {
            int min = Integer.MIN_VALUE;
            for (int right = left; right < n; right++) {
                min = Math.min(min, heights[right]);
                ans = Math.max(ans, (right - left + 1) * min);
            }
        }
        return ans;
    }


}
