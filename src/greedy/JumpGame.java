package greedy;

/**
 * 跳跃游戏
 *
 * @author 张烈文
 * @date 2021/10/31 12:22
 */
public class JumpGame{

    public boolean canJump(int[] nums) {
        int len = nums.length;
//        若数组长度为1，则直接返回
        if (len == 1) {
            return true;
        }
//        初始话覆盖范围为nums[0]
        int coverRange = nums[0];
//        在覆盖范围内更新最大覆盖范围
        for (int i = 0; i <= coverRange; i++) {
            coverRange = Math.max(coverRange, i + nums[i]);
//            如果覆盖范围已经超出了数组长度则返回true
            if(coverRange>=len-1){
                return true;
            }
        }
        return false;
    }
}
