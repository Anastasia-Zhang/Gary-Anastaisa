
public class TowSumSortArray {
    /**
     * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数
     * @param numbers 升序排列数组
     * @param target 目标数
     * @return index 两个结果的下标数组，从零开始
     * */
    public int[] twoSum(int[] numbers, int target) {
        if(numbers == null || numbers.length == 0 || target < numbers[0]) return new int[]{};
        int[] indexs = new int[2];
        for (int i = 0; i < numbers.length; i++){
            if (indexs[0] != 0) break;
            for(int j = i + 1; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target){
                    indexs[0] = i + 1;
                    indexs[1] = j + 1;
                    break;
                }
            }
        }
        return indexs;
    }
}
