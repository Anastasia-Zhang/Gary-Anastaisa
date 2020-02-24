package offer;

import java.util.Arrays;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/22 14:05
 */
public class 面试题5替换空格 {
    public static void main(String[] args) {

    }
    // split 做切分 多个空格？？
    // String[] strs = s.split(" "); // 前面有空格的话就直接把前面的空格分给下一个数组 " 0 " [, 0]
    public static String replaceSpace1(String s) {
        // 判断空格位置 前面有空格 中间有空格 后面有空格 全是空格
        if (s == null || s.length() == 0) return s;
        if (s.equals(" ")) return "%20";
        StringBuffer buffer = new StringBuffer("");
        if (s.charAt(0) == ' ') buffer.append("%20");
        s = s.substring(1, s.length());
        String[] strs = s.split(" ");
        System.out.println(Arrays.toString(strs));

        if (strs.length == 0){
            for (char c : s.toCharArray()){
                buffer.append("%20");
            }
            return buffer.toString();
        }else {
            //if (s.charAt(0) == ' ') buffer.append("%20");
            buffer.append(strs[0]);
            for (int i = 1; i < strs.length; i++){
                buffer.append("%20");
                buffer.append(strs[i]);
            }
            if (s.charAt(s.length() - 1) == ' ') buffer.append("%20");
            return buffer.toString();
        }
    }

    public String replaceSpace(String s) {
        StringBuilder res = new StringBuilder();
        for(Character c : s.toCharArray())
        {
            if(c == ' ') res.append("%20");
            else res.append(c);
        }
        return res.toString();
    }
}
