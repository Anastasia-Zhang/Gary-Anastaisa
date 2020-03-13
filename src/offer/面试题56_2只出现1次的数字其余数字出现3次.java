package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/10 21:52
 */
public class 面试题56_2只出现1次的数字其余数字出现3次 {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] bitSum = new int[32]; // 保存每一位的和

        for (int i = 0; i < nums.length; i++){
            int bitMask = 1;
            for (int j = 31; j >= 0; j--){
                if ((nums[i] & bitMask) != 0) bitSum[j] += 1;
                bitMask <<= 1; // 右移至高位
            }
        }

        int result = 0;
        for (int i = 0; i < 32; i++){
            result <<= 1; // 往高位移让低位参与运算
            result += bitSum[i] % 3;
        }
        return result;
    }
}
