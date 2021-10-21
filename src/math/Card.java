package math;

import java.util.HashSet;
import java.util.Set;

/**
 * 扑克牌中的顺子
 * @author 张烈文
 * @date 2021/10/21 14:03
 */
public class Card {

    /**
     * max-min<5,则能构成顺子，且不能重复，遇到0直接跳过，用set
     * @param numbers
     * @return
     */
    public boolean IsContinuous(int [] numbers) {
        Set<Integer> set = new HashSet<>();
//        牌中最大值为14，最小值为0
        int min = 14, max = 0;
        for (int num : numbers) {
            if (num == 0) {
                continue;
            }
            if (!set.add(num)) {
                return false;
            }
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return max - min < 5;
    }
}
