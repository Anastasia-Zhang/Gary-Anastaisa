import java.util.HashMap;

public class SubArrayModK {
    public int subarraysDivByK(int[] A, int K) {
        int count = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int prefixSum = 0;
        for (int i = 0; i < A.length; i++) {
            prefixSum = (prefixSum + A[i]) % K;
            if (prefixSum < 0) prefixSum += K;
            // 若存在之前某个前缀合
            if (hashMap.containsKey(prefixSum)) {
                count += hashMap.get(prefixSum);
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
