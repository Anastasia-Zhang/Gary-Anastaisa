import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 */
public class MajorityElement {

    //暴力法 time:O(n2)
    public int majorityElement1(int[] nums) {
        int majorityCount = nums.length / 2;
        for(int num : nums){
            int count = 0;
            for(int elem : nums){
                if(num == elem){
                    count++;
                }
            }
            if(count > majorityCount){
                return num;
            }
        }
        return -1;
    }

    // 哈希表法，记录哈希表中的数据个数
    // 时间复杂度：O(n),空间复杂度：O(n)
    public int majorityElement2(int[] nums) {

        // 利用哈希表，存储每个元素出现的位置
        int res = 0;
        HashMap<Integer,Integer> hash = new HashMap<>();
        for(int num : nums){
            int count = 0;
            if(!hash.containsKey(num)){
                hash.put(num,count);
            }else {
                hash.put(num,hash.get(num)+1);
            }
            if(hash.get(num) > nums.length / 2){
                res = num;
                break;
            }
        }
        return res;

        // 遍历哈希表,寻找hashMap里
        // 用于接收上一个hash
//        Map.Entry<Integer,Integer> majorityEntry = null; // 保存最小
//        for(Map.Entry<Integer,Integer> entry : hash.entrySet()){
//            if(majorityEntry == null || entry.getValue() > majorityEntry.getValue()){
//                majorityEntry = entry;
//            }
//        }
//
//        return majorityEntry.getKey();
    }

    //排序算法 如果所有数字被单调递增或者单调递减的顺序排了序，那么众数的下标为 n/2
    public int majorityElement3(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    // Moore voting
    public int majorityElement4(int[] nums){
        return 0;
    }

    // 分冶算法
    // 想法
    // 如果我们知道数组左边一半和右边一半的众数，我们就可以用线性时间知道全局的众数是哪个。
    // 这里我们使用经典的分治算法递归求解，直到所有的子问题都是长度为 1 的数组。
    // 由于传输子数组需要额外的时间和空间，所以我们实际上只传输子区间的左右指针 lo 和 hi 表示相应区间的左右下标。
    // 长度为 1 的子数组中唯一的数显然是众数，直接返回即可。
    // 如果回溯后某区间的长度大于 1 ，我们必须将左右子区间的值合并比较。
    // 如果它们的众数相同，那么显然这一段区间的众数是它们相同的值。
    // 否则，我们需要比较两个众数在整个区间内出现的次数来决定该区间的众数。
    // 原问题的答案就是下标为 00 和 nn 之间的众数这一子问题。
    public int majorityElement5(int[] nums){
        return majorityElementRec(nums,0,nums.length-1);
    }

    private int majorityElementRec(int[] nums,int low,int height){

        //最简单情况，递归后长度为1，子问题，直接返回，递归出口
        if(low == height){
            return nums[low];
        }

        //如果众数相同，则次众数就是整个区间上的众数
        int mid = (low + height) / 2;
        int left = majorityElementRec(nums,low,mid);
        int right = majorityElementRec(nums,mid + 1,height);
        if(left == right){
            return left;
        }

        // 众数不相同，分别求各个区间上众数出现的次数
        int rightCount = countNumInRange(nums,right,mid,height);
        int leftCount = countNumInRange(nums,left,low,height);
        return rightCount > leftCount ? right : left;

    }

    private int countNumInRange(int[] nums,int num,int height,int low){
        int count = 0;
        for(int i = low;i < height;i ++){
            if(nums[i] == num){
                count ++;
            }
        }
        return count;
    }
}
