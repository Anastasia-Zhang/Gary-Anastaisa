package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/21 20:04
 */
public class LetterCombination {
    HashMap<Character, String> map;
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        ans = new ArrayList<>();
        if (digits == null || digits.equals("")) return ans;
        map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(digits, new StringBuffer(), 0);
        return ans;
    }

    public void dfs(String digits, StringBuffer prefix, int index) {
        // 递归出口
        if (index == digits.length()){
            ans.add(prefix.toString());
            return;
        }
        // 取 index 为key的单词
        String s = map.get(digits.charAt(index));
        for (int i = 0; i < s.length(); i++){
            dfs(digits, prefix.append(s.charAt(i)), index + 1);
            // 恢复现场
            prefix.deleteCharAt(index);

        }
    }
}
