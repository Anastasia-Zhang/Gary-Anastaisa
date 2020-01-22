public class PeakElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        System.out.println(findPeakElement(nums));
    }
    public static int findPeakElement(int[] nums) {
        int rightNum = 0;
        int leftNum = 0;
        //if (nums.length < 2) return 0;
        for(int i = 0; i < nums.length; i++){
            if (i - 1 < 0) {
                leftNum = Integer.MIN_VALUE;
            }else{
                leftNum = nums[i - 1];
            }
            if (i + 1 <= nums.length - 1){
                rightNum = nums[i + 1];
            }else {
                rightNum = Integer.MIN_VALUE;
            }
            if (nums[i] > leftNum && nums[i] > rightNum){
                return i;
            }
        }
        return nums.length - 1;
    }

    public static int findPeakElement2(int[] nums) {
        return searchPeek(nums, 0, nums.length - 1);
    }

    private static int searchPeek(int[] nums, int left, int right){
        if (left == right) return 1;
        int mid = left + right / 2;
        if (nums[mid] < nums[mid + 1]) return searchPeek(nums,mid + 1, right);
        return searchPeek(nums, left, mid);
    }
}
