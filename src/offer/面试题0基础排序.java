package offer;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/28 22:50
 */
public class 面试题0基础排序 {

    public static void main(String[] args) {
        int[] arr = new int[]{2,6,5,4,2,5,3,4,2};
        // System.out.println(segmentCount(arr, 0, arr.length - 1));
        System.out.println(Arrays.toString(arr));
        // partition(arr,0,arr.length - 1);
        // bubbleSort(arr);
        // insertSort(arr);
        // selectSort(arr);
        shellSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int j;
            int temp = nums[i];
            for (j = i; j > 0 && temp < nums[j - 1]; j--) {
                nums[j] = nums[j - 1];
            }
            nums[j] = temp;
        }
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            boolean flag = false;
            // 每次排序找到最大的数，排到后面
            for (int j = 1; j < nums.length - i; j++){
                if (nums[j] < nums[j - 1]){
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            int min = i; // 最小元素的下标
            for (int j = i + 1; j < nums.length; j++){
                if (nums[min] > nums[j]) min = j;
            }
            int temp = nums[min];
            nums[min] = nums[i];
            nums[i] = temp;
        }
    }

    public static void shellSort(int[] nums) {
        int h = 1;
        while (h < nums.length / 3) h = 3 * h + 1;
        while (h >= 1) {
            System.out.println(h);
            for (int i = h; i < nums.length; i++){
                int j;
                int temp = nums[i];
                for (j = i; j >= h && temp < nums[j - h]; j -= h){
                    nums[j] = nums[j - h];
                }
                nums[j] = temp;
            }
            h = h / 3;
        }
    }

    public static void quickSort(int[] nums, int left, int right){
        if (left < right){
            int i = partition(nums, left, right);
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }

    public static void quickSortWithStack(int[] nums, int left, int right){
        LinkedList<Integer> stack = new LinkedList<>();
        // 非递归是将下标加入到栈中来循环调用 partition 方法
        // 先右后左这样能保证取出来是先左后右
        stack.push(right);
        stack.push(left);
        while (!stack.isEmpty()){
            int l = stack.pop();
            int r = stack.pop();
            int pivot = partition(nums, l, r);
            if (pivot - 1 > l){
                // quickSort(nums, left, i - 1);
                stack.push(pivot - 1);
                stack.push(l);
            }
            if (pivot + 1 < r){
                // quickSort(nums, i + 1, right);
                stack.push(r);
                stack.push(pivot + 1);
            }
        }
    }


    public static int partition(int[] nums, int left, int right){
        int pivot = nums[left];
        while (left < right){
            while (left < right && nums[right] > pivot) right--;
            nums[left] = nums[right];
            // 要加等号，要不然left = right 会造成死循环
            while (left < right && nums[left] <= pivot) left++;
            nums[right] = nums[left];
        }
        nums[left] = pivot;
        return left;
    }

    // 归并排序
    public static void segment(int[] nums, int left, int right){
        if (left < right){
            int center = left + (right - left) / 2;
            segment(nums, left, center);
            segment(nums, center + 1, right);
            merge(nums, left, center, right);
        }
    }

    public static void merge(int[] nums, int left, int center, int right){
        // 分成左右两个半部分
        int[] tempNum = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = center + 1;
        int tempIndex = 0;
        while (leftIndex <= center && rightIndex <= right){
            // 双指针，查看两组元素的大小，先把较小的归并到临时数组中
            if (nums[leftIndex] <= nums[rightIndex]) tempNum[tempIndex++] = nums[leftIndex++];
            else tempNum[tempIndex++] = nums[rightIndex++];
        }

        // 合并剩下的
        while (leftIndex <= center){
            tempNum[tempIndex++] = nums[leftIndex++];
        }

        while (rightIndex <= right){
            tempNum[tempIndex++] = nums[rightIndex++];
        }
        tempIndex = 0;
        for (int i = left; i <= right; i++){
            nums[i] = tempNum[tempIndex++];
        }
    }

    static int count = 0;

    // 逆序的对数
    public static int segmentCount(int[] nums, int left, int right){
        if (left >= right) return 0;
        else {
            int center = left + (right - left) / 2;
            int leftNum = segmentCount(nums, left, center);
            int rightNum = segmentCount(nums, center + 1, right);
            int reverseNum = leftNum + rightNum;
            if (nums[center] < nums[center + 1]){
                return reverseNum;
            }
            return mergeCount(nums, left, center, right) + reverseNum;

        }
    }

    public static int mergeCount(int[] nums, int left, int center, int right){
        //int reverseNum = 0;
        // 分成左右两个半部分
        int reverseNum = 0;
        int[] tempNum = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = center + 1;
        int tempIndex = 0;
        while (leftIndex <= center && rightIndex <= right){
            // 双指针，查看两组元素的大小，先把较小的归并到临时数组中
            if (nums[leftIndex] <= nums[rightIndex]) {
                tempNum[tempIndex++] = nums[leftIndex++];

            }
            else {
                reverseNum += center - leftIndex + 1;
                // 右边的数字小，与整个左数组构成了逆序
                tempNum[tempIndex++] = nums[rightIndex++];

            }
        }
        // 合并剩下的
        while (leftIndex <= center){
            tempNum[tempIndex++] = nums[leftIndex++];
        }

        while (rightIndex <= right){
            tempNum[tempIndex++] = nums[rightIndex++];
        }
        tempIndex = 0;
        for (int i = left; i <= right; i++){
            nums[i] = tempNum[tempIndex++];
        }
        return reverseNum;
    }

    public static int countReverse(int[] nums){
        int num = 0;
        for (int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                if (nums[j] < nums[i]) num++;
            }
        }
        return num;
    }

    // 堆排序实现，大顶堆
    public static void heapSort(int[] nums){
        int n = nums.length - 1;
        // 堆内有序,从最后一个根节点开始扫描
        for (int i =  n / 2 - 1; i >= 0; i--){
            heapify(nums, i, n);
           // System.out.println(Arrays.toString(nums));
        }
        // 堆排序，把最大元素放在后面
        while (n > 0){
            swap(nums, 0, n);
            n --;
            heapify(nums, 0, n);
        }
    }

    public static void heapify(int[] nums, int k, int n){
        // 根节点和两个孩子结点交换，保证孩子结点小于等n
        while (2 * k + 1 <= n){
            // 孩子结点下标，从零开始
            int child = 2 * k + 1;
            // 找出两个孩子中的较大的孩子
            // child < n 如果加上等于号child + 1 下标越界
            if (child < n && nums[child] < nums[child + 1]) child++;
            // 满足堆的条件直接 break 掉
            if (nums[k] >= nums[child]) break;
            // 不满足则交换
            swap(nums, k, child);
            k = child;
        }
    }


    private static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
