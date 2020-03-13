package offer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/9 15:32
 */
public class 面试题45把数组排列成最小的数 {
    public String minNumber(int[] nums) {
        if (nums == null) return "";
        List<String> list = new ArrayList<>();
        for (int num : nums) {
            list.add(String.valueOf(num));
        }
        list.sort((s1, s2) -> (s1 + s2).compareTo(s2 + s1));
        StringBuffer sb = new StringBuffer();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }
}
