package fastSlowPoint;

public class sortColorscountCount {
    public static void main(String[] args) {

    }

    // 计数排序
    public void sortColorsCountSort(int[] nums) {
        int maxValue = Integer.MIN_VALUE;
        int minValue = Integer.MAX_VALUE;

        for (int num : nums){
            maxValue = Math.max(num, maxValue);
            minValue = Math.min(num, minValue);
        }

        int[] countArr = new int[maxValue - minValue + 1];

        for (int num : nums) {
            int index = num - minValue;
            countArr[index]++;
        }

        int index = 0;
        for (int i = 0; i < countArr.length; i ++){
            while (countArr[i] -- > 0){
                nums[index++] = i + minValue;
            }
        }
    }

    public void sortColors(int[] nums){
        if (nums.length == 0 || nums == null ) return;

        // 设置最左边和最右边的边界
        int leftIndex = 0;
        int rightIndex = nums.length - 1;
        int curr = 0;

        while (curr < rightIndex){
            if (nums[curr] == 0){
                // 和最左边的交换
                swap(nums, curr, leftIndex);
                curr++;
                leftIndex++;
            }else if (nums[curr] == 2){
                // 和最左边的交换
                swap(nums, curr, rightIndex);
                rightIndex--;
            }else{
                curr ++;
            }
        }

    }

    private void swap(int[] arr, int index1,int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
