package offer;

import java.util.LinkedList;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/7 11:43
 */
public class 面试题59_1滑动窗口的最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        LinkedList<Integer> queue = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]){
                queue.pollLast();
            }
            queue.addLast(i);
            // 判断队头元素时否过期
            if (i - queue.peekFirst() + 1 > k) {
                queue.pollFirst();
            }
            if (i >= k - 1){
                res[index++] = nums[queue.peekFirst()];
            }
        }
        return res;
    }
}
