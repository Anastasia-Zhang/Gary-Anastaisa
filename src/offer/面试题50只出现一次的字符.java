package offer;

import java.util.HashMap;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/5 16:39
 */
public class 面试题50只出现一次的字符 {
    public char firstUniqChar(String s) {
        if (s.length() == 0) return ' ';
        HashMap<Character, Integer> hashMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars){
            if (!hashMap.containsKey(c)){
                hashMap.put(c, 1);
            } else {
                hashMap.put(c, hashMap.get(c) + 1);
            }
        }

        // 遍历 hashmap 是无序的，遍历也没用，因为要第一个出现的
        // for (Map.Entry<Character, Integer> map : hashMap.entrySet()){
        //     if (map.getValue() == 1) return map.getKey();
        // }

        for (char c : chars){
            if (hashMap.get(c) == 1) return c;
        }
        return ' ';
    }
}
