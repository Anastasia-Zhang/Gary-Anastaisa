import java.util.Collections;
import java.util.PriorityQueue;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/19 20:50
 */
public class FindMedianSortedArrays {
    public PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        for (int num : nums1) {
            addNum(num);
        }

        for (int num : nums2) {
            addNum(num);
        }

        if (minHeap.size() == maxHeap.size()) return (minHeap.peek() + maxHeap.peek()) * 0.5;
        else return maxHeap.peek();
    }

    public void addNum(int num){
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int len = (m + n);
        // len 是奇数的话 中间就是 (len - 1) / 2 我们只需要知道（len + 1）/ 2
        // len 是偶数的话 中间就是 len / 2 和 lne / 2 + 1
        int start1 = 0, start2 = 0; // A B 两个指针
        int left = -1, right = -1;
        // 根据两个数据的大小关系找到中位数的位置
        for (int i = 0; i < len / 2; i++){
            // 用于偶数的情况，记录上一次遍历的right值
            left = right;
            // 记录中间的数, 要判断数组1是否超过下标，还要判断数组2是否超过下标，只要数组2超过下标就不再进行后面的判断
            // A || B 的条件只要为 A 为 1 B就不执行
            // 适用于A还有数字B已经遍历完的情况
            if (start1 < m && ((start2 >= n) || nums1[start1] < nums2[start2])){
                right = nums1[start1++];
            }else {
                right = nums2[start2++];
            }
        }

        if ((len & 1) == 0) return (left + right) / 2.0;
        else return right;

    }
}
