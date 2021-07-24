package greedy;

/**
 * 摆动序列
 * @author 张烈文
 * @date 2021/7/24 23:31
 */
public class WiggleSubSequence {

    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
//        当前一对差值
        int curDiff = 0;
//        前一对差值
        int preDiff = 0;
//        记录峰值个数，序列默认序列最右边有一个峰值
        int result = 1;
        for (int i = 0; i < nums.length-1; i++) {
            curDiff = nums[i + 1] - nums[i];
//            出现峰值
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                result++;
                preDiff=curDiff ;
            }
        }
        return result;
    }
}
