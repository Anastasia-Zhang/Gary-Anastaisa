package offer;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/9 16:10
 */
public class 面试题48最长不含重复字符的子字符串 {
    // 假设字符串只有 a-z
    public int lengthOfLongestSubstring1(String s) {
        if (s == null || s.length() == 0) return 0;
        // if (s.equals(" ")) return 1;
        char[] chars = s.toCharArray();
        if (chars[0] == ' ') return 1;
        // Set<Character> set = new HashSet<>();
        int[] position = new int[26];
        int[] dp = new int[chars.length];
        dp[0] = 1;
        // set.add(chars[0])
        Arrays.fill(position, -1);
        int maxLen = dp[0];
        position[chars[0] - 'a'] = 0; // 记录第0个字符的位置
        for (int i = 1; i < dp.length; i++){
            //if (!set.contains(chars[i])){
            if (position[chars[i] - 'a'] == -1){
                position[chars[i] - 'a'] = i;
                dp[i] = dp[i - 1] + 1;
            } else {
                // set.clear();
                // set.add(chars[i]);
                int index = position[chars[i] - 'a'];
                // 代表重复的数字在 dp[i - 1]对应的子串中，我们就重复的字符开始算到现在的距离
                // 也就是说在第 i 个字符出现连次所夹的字符串中再也没有其他重复的数字了
                if (i - index <= dp[i -1]) dp[i] = i - index;
                else dp[i] = dp[i - 1] + 1; // 重复字符在 dp[i - 1] 对应的最长子串之前
                position[chars[i] - 'a'] = i;
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        if (chars[0] == ' ') return 1;
        HashMap<Character, Integer> map = new HashMap<>();
        int[] dp = new int[chars.length];
        dp[0] = 1;
        int maxLen = dp[0];
        map.put(chars[0], 0);
        for (int i = 1; i < dp.length; i++){
            if (!map.containsKey(chars[i])){
                map.put(chars[i], i);
                dp[i] = dp[i - 1] + 1;
            }else {
                int index = map.get(chars[i]);
                // 如果出现重复的字符，我们要计算距离上一次重复出现字符的距离 d
                // 1) 如果 d <= dp[i - 1] abcdavf
                // 代表重复的数字在 dp[i - 1]对应的子串中，我们就重复的字符开始算到现在的距离
                // 也就是说在第 i 个字符出现连次所夹的字符串中再也没有其他重复的数字了
                // 2) d > dp[i - 1]
                // 重复字符在 dp[i - 1] 对应的最长子串之前,不用管，继续算就好 arabcacfr f

                dp[i] = (i - index) > dp[i - 1] ? dp[i - 1] + 1 : (i - index);
                map.put(chars[i], i);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();
        if (chars[0] == ' ') return 1;
        HashMap<Character, Integer> map = new HashMap<>();
        // int[] dp = new int[chars.length];
        int curLen = 1;
        //dp[0] = 1;
        int maxLen = 1;
        map.put(chars[0], 0);
        for (int i = 1; i < chars.length; i++){
            if (!map.containsKey(chars[i])){
                curLen++;
            }else {
                int index = map.get(chars[i]);
                curLen = (i - index) > curLen ? ++curLen : (i - index);
                //map.put(chars[i], i);
            }
            map.put(chars[i], i);
            maxLen = Math.max(maxLen, curLen);
        }
        return maxLen;
    }
}
