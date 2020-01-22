/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/13 15:50
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
       int[] res = new int[nums.length];
       int k = 1;

       // 计算除了自身外左边元素的乘积
       for (int i = 0; i < nums.length; i++){
           res[i] = k;
           k *= nums[i];
       }

       // 计算除自身元素外右边元素的乘积，结果上再称上之前左边元素的乘积
       k = 1;
       for (int i = nums.length - 1; i >= 0; i--){
           res[i] *= k;
           k *= nums[i];
       }

       return res;
    }
}
