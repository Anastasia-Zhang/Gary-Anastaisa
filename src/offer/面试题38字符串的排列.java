package offer;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/4 0:27
 */
public class 面试题38字符串的排列 {
    // arraylist 超时
    Set<String> ans = new TreeSet<>();
    boolean[] visited = null;
    public String[] permutation(String s) {
        if (s.length() == 0 || s == null) return new String[0];
        char[] chars = s.toCharArray();
        visited = new boolean[s.length()];
        dfs(chars, s.length() - 1, 0, new StringBuffer());
        String[] res = new String[ans.size()];
        int index = 0;
        for (String str : ans){
            res[index++] = str;
        }
        return res;
    }

    public void dfs(char[] s, int len, int index, StringBuffer sb){
        if (index == s.length){
            ans.add(new StringBuffer(sb).toString());
            return;
        }
        // 一定是从0开始 index 代表的是我遍历字符串的索引，主要记录了我遍历了多少个字符
        // 这个循环是遍历这个字符所有组成的可能性：b 还可以和 a 组合，所以 i 就不能从 index 开始
        for (int i = 0; i <= len; i++){
            if (!visited[i]){
                visited[i] = true;
                sb.append(s[i]);
                dfs(s, len, index + 1, sb);
                visited[i] = false;
                sb.deleteCharAt(index);
            }
        }
    }
}
