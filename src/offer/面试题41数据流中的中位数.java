package offer;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/7 14:55
 */
public class 面试题41数据流中的中位数 {

    class MedianFinder {
        PriorityQueue<Integer> minHeap, maxHeap;
        /** initialize your data structure here. */
        public MedianFinder() {
            // 可以把数组划分为两部分，在中位数前面的半部分，在中位数后面的半部分
            // 中位数前面半部分用大顶堆实现，这样找的时候只需要找中位数位置前最大的数
            // 中位数前面半部分用大小顶堆实现，这样找的时候只需要找中位数位置后最小的数
            // 为了保持平衡，两个堆的元素要么相等（数字个数为偶数的情况）要么大顶堆比小顶堆个数大1（数字个数为奇数的情况）
            maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            minHeap = new PriorityQueue<>();
        }

        public void addNum(int num) {
            // 先把数据插入最大堆，在从最大堆中拿出最大的数字插入最小堆
            // 由于最终插入最小堆的数字是原先最大堆的数字，这样就能保证最小堆的数字大于最大堆的数字
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            // 如果不平衡了再移回去
            if (minHeap.size() > maxHeap.size()){
                // 最小堆中最小的数字移回到最大堆
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (minHeap.size() == maxHeap.size()) {
                return (maxHeap.peek() + minHeap.peek()) * 0.5;
            } else {
                return maxHeap.peek();
            }
        }
    }
}
