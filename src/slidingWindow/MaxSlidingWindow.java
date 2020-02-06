package slidingWindow;

import java.util.LinkedList;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/6 18:01
 */
public class MaxSlidingWindow {
    public static void main(String[] args) {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        maxSlidingWindow(nums, 3);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) return new int[0];
        int[] ans = new int[nums.length - k + 1];
        LinkedList<Integer> queue = new LinkedList<>();
        int  right = 0, index = 0;;
        while (right < nums.length){
            // 滑动窗口 保持窗口的头部是最大值 判断当前队列是否为空，若不为空则更新队列，
            // 只要当前队尾的元素比要加入的元素小 确认当前加入的元素是最大元素候选值
            // 队列中保留的元素必须必新加入的元素大，这样才能保持队首元素比新加入的元素小
            System.out.println("-----当前队尾元素小于等于要加入元素清空队列-----");
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[right]) {
                int e = queue.peekLast();
                queue.pollLast();
                System.out.print("清空：" + nums[e] + " ");
            }
            System.out.println();
            System.out.println("-----添加新队列-----");
            queue.addLast(right);
            for (int i : queue){
                System.out.print(nums[i] + " ");
            }
            System.out.println();
            // 窗口头部元素过期
            if (right - queue.peekFirst() + 1 > k){
                System.out.println("-----队头元素过期-----");
                int e  = queue.peekFirst();
                queue.pollFirst();
                System.out.println(nums[e]);
            }
            if (right >= k - 1) ans[index++] = nums[queue.peekFirst()];
            right++;
        }
        return ans;
    }

}
