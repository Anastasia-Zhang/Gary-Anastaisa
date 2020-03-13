package offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/7 11:14
 */
public class 面试题59_2队列的最大值 {
    class MaxQueue {
        Queue<Integer> queue;
        LinkedList<Integer> maxQueue;

        public MaxQueue() {
            queue = new LinkedList<>(); // 平常的操作队列
            maxQueue = new LinkedList<>(); // 保存的是从当前队头开始最大的元素
        }

        public int max_value() {
            // 队首就是最大元素
            if (!maxQueue.isEmpty()) return maxQueue.peekFirst();
            else return -1;
        }

        public void push_back(int value) {
            queue.add(value);
            // 加入队列，如果加入队列的数比最大值队列的元素大，那么他以前的元素都不是最大元素的候选元素，从队列后端删除
            while (!maxQueue.isEmpty() && maxQueue.peekLast() <= value) {
                maxQueue.pollLast();
            }
            // 直到这个元可以作为最大元素的候选元素
            maxQueue.addLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) return -1;
            // 如果删除的是最大元素，则同步最大元素一块删除
            int e = queue.poll();
            if (!maxQueue.isEmpty() && e == maxQueue.peekFirst()) {
                maxQueue.pollFirst();
            }
            return e;

        }
    }
}
