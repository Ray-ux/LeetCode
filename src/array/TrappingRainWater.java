package array;

/**
 * 接雨水
 *
 * @author 张烈文
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int max = 0;
        int n = height.length;
//        找到数组中高度最高的下标，将数组分为两部分
        for (int i = 0; i < n; i++) {
            if (height[i]>height[max]) {
                max = i;
            }
        }
        int water = 0;
//        当前高度比前一个高度小时则累加，左半
        for (int i = 0, peak = 0; i < max; i++) {
            if (height[i]>peak){
                peak = height[i];
            }else{
                water += peak - height[i];
            }
        }

//        从右半部分的最后一个坐标开始

        for (int i = n - 1, top = 0; i > max; i--) {
            if (height[i] > top) {
                top = height[i];
            }else{
                water += top - height[i];
            }
        }
        return water;
    }
}
