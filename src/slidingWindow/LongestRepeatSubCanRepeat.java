package slidingWindow;

import java.util.Arrays;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/5 23:46
 * 替换后的最长重复字符
 */
public class LongestRepeatSubCanRepeat {
    public static void main(String[] args) {
        String s = "ABAB";
        System.out.println(characterReplacement(s,2));

    }
    public static int  characterReplacement (String s, int k){
        char[] chars = s.toCharArray();
        int len=s.length();
        int[] mark = new int[26];
        int maxCount = 0;
        for (int left=0,right = 0; right < len; right++) {
            maxCount = Math.max(maxCount, ++mark[chars[right] - 'A']);
            //if判断即可，无须while循环，因为缩小一次之后肯定满足
            if (right - left + 1 - maxCount > k) {
                mark[chars[left] - 'A']--;
                left++;
            }
        }
        return Math.min(len , maxCount + k);



    }
}
