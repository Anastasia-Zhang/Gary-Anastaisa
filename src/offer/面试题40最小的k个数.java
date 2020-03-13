package offer;

import java.util.Arrays;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/3 19:56
 */
public class 面试题40最小的k个数 {
    // 基于快排的思想，使得比 k 小的数字都位于数组的左边
    public int[] getLeastNumbers(int[] arr, int k) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high){
            // 基于一次 partition 后，i右边的数字都是比 i 小的
            int i = partition(arr, low, high);
            //  k 的位置一定在 i 的左边，则应该缩小 右指针的范围，到 i 的左边再去查找
            if (i >= k) high = i - 1;
            //  k 的位置位于 i 的右边，则应该扩大左指针的范围，到 i 的右边再去查找
            if (i < k) low = i + 1;
        }
        return Arrays.copyOf(arr, k);
    }

    public int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        while (left < right){
            while (left < right && nums[right] > pivot) right--;
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    // 使用大顶堆来实现
    public int[] getLeastNumbersHeap(int[] arr, int k) {
        if (k == 0) return new int[0];
        // 大顶堆
        int[] res = Arrays.copyOfRange(arr, 0, k); // 先取k个元素
        // 调整至大顶堆,队内有序 res[0] 就是最大元素
        for (int i = k / 2 - 1; i >= 0; i--){
            heapify(res, i, k - 1);
        }
        // 遍历剩下的数组，在最大堆中取堆顶的元素，如果插入的元素比最大堆的堆顶还要小，就替换，重新调整堆，否则就舍弃
        for (int i = k; i < arr.length; i++){
            if (arr[i] < res[0]) {
                res[0] = arr[i];
                // 新插入的元素插入到大顶堆上面，肯定不符合堆内的排序 重新调整
                heapify (res, 0, k - 1);
            }
        }
        return res;

    }

    // 下沉调整大顶堆，m 为开始索引， n为堆的容量
    private void heapify(int[] nums, int m, int n){
        // i 2i 2i + 1 的对应关系是 下标为1开始的，因此对照此关系要下标 + 1: i 2i+ 1 2i + 2
        while (m * 2 + 1 <= n) {
            int child = m * 2 + 1;
            // 外层循环 child 可能等于 n，一次这个判断要保证小于 n
            // 选出两个孩子结点较大的一个交换
            if (child < n && nums[child] < nums[child + 1]) child++;
            if (nums[m] >= nums[child]) break;
            swap(nums, m, child);
            m = child;
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
