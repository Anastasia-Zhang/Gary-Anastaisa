package bits;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/14 19:02
 */
public class MaxProductWordLength {
    public int maxProduct(String[] words) {
        if (words.length <= 1) return 0;
        // 位图32位二进制代表26个字母出现，如果出现则在相应的位置上置1
        // 定义一个和给给定字符串数组等长的一维整数数组，用来存储每个字符串的“位图”
        int[] bitMap = new int[words.length];
        for (int i = 0; i < words.length; i++){
            for (char c : words[i].toCharArray()){
                bitMap[i] |= 1 << (c - 'a');
            }
        }
        int max = 0;
        for (int i = 0; i < words.length - 1; i++){
            for (int j = i + 1; j < words.length; j++){
                //if (isCommon(words[i], words[j])) {
                if ((bitMap[i] & bitMap[j]) == 0){
                    max = Math.max(max, words[i].length() * words[j].length());
                }
            }
        }
        return max;
    }


    // public boolean isCommon(String a, String b){

    //     for (int i = 0; i < a.length(); i++){
    //         for (int j = 0; j < b.length(); j++){
    //             if (a.charAt(i) == b.charAt(j)) return false;
    //         }
    //     }
    //     return true;
    // }
}
