import java.util.HashMap;

public class SubArraySumk {
    public int subarraySum1(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) count++;
            }
        }
        return count;
    }
    public int subarraySum2(int[] nums, int k) {
        int count = 0;
        // hahsmap 存放所有的前缀和 和 其出现的次数
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            // 若存在之前某个前缀合
            if (hashMap.containsKey(prefixSum - k)) {
                count += hashMap.get(prefixSum - k);
            }
            if (hashMap.containsKey(prefixSum)) {
                hashMap.put(prefixSum, hashMap.get(prefixSum) + 1);
            } else{
                hashMap.put(prefixSum, 1);
            }
        }
        return count;
    }
}
