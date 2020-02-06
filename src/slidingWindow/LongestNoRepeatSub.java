package slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/5 18:41
 */
public class LongestNoRepeatSub {
    public static void main(String[] args) {
        String s = "ddddd";
        System.out.println(lengthOfLongestSubstring2(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int len = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = i; j < s.length(); j++) {
                // 应该判断 i j - 1 之间的字符串都无重复的,不包括j因为包括j就无法计算一个子串的情况（j = 1 + 1)时
                if (isAllNoRepeat(s, i, j)) {
                    len = Math.max(len, j - i + 1);
                }
            }
        }
        return len;
    }

    private static boolean isAllNoRepeat(String s, int start, int end){
        Set<Character> hash = new HashSet<>();
        for (int i = start; i <= end; i++){
            if (hash.contains(s.charAt(i))) return false;
            hash.add(s.charAt(i));
        }
        return true;
    }

    public static int lengthOfLongestSubstring2(String s) {
        // 滑动串口一侧[i, j) 右侧滑动加元素，左侧不满足条件减元素
        int res = 0, i = 0, j = 0;
        Set<Character> set = new HashSet<>();
        while (i < s.length() && j < s.length()){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                res = Math.max(res, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }

    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // 维护每个字符及其索引
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            // 若有重复的则直接跳过重复的字母，从重复字母的下一个索引开始
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

}
