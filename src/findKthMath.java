import java.util.PriorityQueue;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/5 1:06
 */
public class findKthMath {
    public int findKthLargest(int[] nums, int k) {
        // init heap 'the smallest element first'
        PriorityQueue<Integer> heap = new PriorityQueue<>((n1, n2) -> n1 - n2);

        // keep k largest elements in the heap
        for (int n: nums) {
            heap.add(n);
            if (heap.size() > k)
                heap.poll();
        }

        // output
        return heap.poll();
    }

}
