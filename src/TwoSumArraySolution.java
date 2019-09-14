public class TwoSumArraySolution {

    // 使用有序数组的特性
    // 我们使用两个指针，
    // 初始分别位于第一个元素和最后一个元素位置，比较这两个元素之和与目标值的大小。
    // 如果和等于目标值，我们发现了这个唯一解。如果比目标值小，我们将较小元素指针增加一。
    // 如果比目标值大，我们将较大指针减小一。移动指针后重复上述比较知道找到答案

    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0 || target < numbers[0]) return new int[]{};
        int slow = 0;
        int quick = numbers.length - 1;
        while (slow < quick){
            if(numbers[slow] + numbers[quick] == target){
                return new int[]{slow + 1, quick + 1};
            }else if(numbers[slow] + numbers[quick] > target){
                quick --;
            }else if(numbers[slow] + numbers[quick] < target){
                slow ++;
            }
        }
        return null;
    }
}
