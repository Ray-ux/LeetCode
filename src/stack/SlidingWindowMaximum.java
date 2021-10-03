package stack;

import java.util.*;

/**
 * 滑动窗口的最大值
 *
 * @author 张烈文
 * @date 2021/10/3 20:15
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < 2) {
            return nums;
        }
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty()&&nums[deque.peekLast()]<=nums[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if (deque.peek() <= i - k) {
                deque.poll();
            }
            if (i + 1 >= k) {
                res[i + 1 - k] = nums[deque.peek()];
            }
        }

        return res;

    }
}
