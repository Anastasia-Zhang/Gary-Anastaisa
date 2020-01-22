import java.util.Arrays;

public class RotateArraySolution {


    // 使用环状替换
    //如果我们直接把每一个数字放到它最后的位置，但这样的后果是遗失原来的元素。
    // 因此，我们需要把被替换的数字保存在变量 temp 里面。
    // 然后，我们将被替换数字（temp）
    // 放到它正确的位置，并继续这个过程 n 次,n是数组的长度。
    // 这是因为我们需要将数组里所有的元素都移动。
    // 但是，这种方法可能会有个问题，如果 n%k==0其中k=k%n（因为如果k大于n,移动k次实际上相当于移动 k%n次）。
    // 这种情况下，我们会发现在没有遍历所有数字的情况下回到出发数字。
    // 此时，我们应该从下一个数字开始再重复相同的过程。
    private static void rotate1(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for (int start = 0; count < nums.length; start++) { // 最多不超过数组的长度，可以宽大循环的次数
            int current = start;//current 移动的元素的下标
            int prev = nums[start];// 当前要移动的元素
            do {
                int next = (current + k) % nums.length; // 需要移动的元素所放到的最后位置
                int temp = nums[next];// 最后位置上需要被替换的元素赋值给临时变量
                nums[next] = prev; // 将当前需要移动的元素放到最后的位置上
                prev = temp; // 将需要被替换的元素作为下一个需要移动的元素为下一次替换做准备
                current = next;// 下标赋值
                count++; // 移动的计数加一
                System.out.println("循环第" + start + "圈，第" + count + "次的结果：" + Arrays.toString(nums));
            } while (start != current);// 直到循环完一圈，再进行第二个元素的替换
        }
    }
    //循环第1次的结果：[1, 2, 3, 1, 5, 6, 7]
    //循环第2次的结果：[1, 2, 3, 1, 5, 6, 4]
    //循环第3次的结果：[1, 2, 7, 1, 5, 6, 4]
    //循环第4次的结果：[1, 2, 7, 1, 5, 3, 4]
    //循环第5次的结果：[1, 6, 7, 1, 5, 3, 4]
    //循环第6次的结果：[1, 6, 7, 1, 2, 3, 4]
    //循环第7次的结果：[5, 6, 7, 1, 2, 3, 4]
    //循环第01圈，第1次的结果：[1, 2, 1, 4, 5, 6]
    //循环第01圈，第2次的结果：[1, 2, 1, 4, 3, 6]
    //循环第01圈，第3次的结果：[5, 2, 1, 4, 3, 6]
    //循环第11圈，第4次的结果：[5, 2, 1, 2, 3, 6]
    //循环第11圈，第5次的结果：[5, 2, 1, 2, 3, 4]
    //循环第11圈，第6次的结果：[5, 6, 1, 2, 3, 4]

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        rotate(nums, 4);
    }

    // 反转
    //当我们旋转数组 k 次， k\%nk%n 个尾部元素会被移动到头部，剩下的元素会被向后移动。在这个方法中，我们首先将所有元素反转。
    //然后反转前 k 个元素，再反转后面 n-k 个元素，就能得到想要的结果。
    //原始数组                  : 1 2 3 4 5 6 7
    //反转所有数字后             : 7 6 5 4 3 2 1
    //反转前 k 个数字后          : 5 6 7 4 3 2 1
    //反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果
    private void rotate2(int[] nums, int k) {
        k %= nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }

    private void reverse(int[] nums,int start,int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start ++;
            end --;
        }
    }

    // 测试用例 [1,2,3,4,5,6] k = 4 错误
    public static void rotateVersion1(int[] nums, int k) {
        if (k == 0) return;
        int start = 0;
        int startNum = nums[0];
        int next = 0;
        int jumpIndex = 0;
        if (nums.length % k != 0){
            do{
                jumpIndex = (start + k) > nums.length - 1 ? (start + k) % nums.length : (start + k);
                next = nums[jumpIndex];
                nums[jumpIndex] = startNum;
                System.out.println(Arrays.toString(nums));
                start = jumpIndex;
                startNum = next;
            } while (start != 0);
        } else if(nums.length % k == 0) {
            int count = 0;
            for (int i = 0; count < nums.length; i++){
                System.out.println("before do");
                start = i;
                startNum = nums[i];
                //jumpIndex = i;
                do {
                    jumpIndex = (start + k) > nums.length - 1 ? (start + k) % nums.length : (start + k);
                    System.out.println(jumpIndex);
                    next = nums[jumpIndex];
                    nums[jumpIndex] = startNum;
                    System.out.println(Arrays.toString(nums));
                    start = jumpIndex;
                    startNum = next;
                    count ++;
                } while (start != i);
            }
        }
    }

    // 不用区分是否为奇数和偶数，当循环情况不确定时用计数器代替，其循环次数只需要少于总的数组长度（即每个数都需要交换位置
    public static void rotate(int[] nums, int k) {
        if (k == 0) return;
        int start = 0; // 起始位置
        int startNum = nums[0]; // 初试的索引
        int next = 0; // 下一个数
        int jumpIndex = 0; // 需要替换的数
//        if (nums.length % k != 0){
//            do{
//                jumpIndex = (start + k) > nums.length - 1 ? (start + k) % nums.length : (start + k);
//                next = nums[jumpIndex];
//                nums[jumpIndex] = startNum;
//                System.out.println(Arrays.toString(nums));
//                start = jumpIndex;
//                startNum = next;
//            } while (start != 0);
//        } else if(nums.length % k == 0) {
            int count = 0; // 计数
            for (int i = 0; count < nums.length; i++){
                // System.out.println("before do");
                start = i; // 起始位置
                startNum = nums[i]; // 起始的数
                //jumpIndex = i;
                do {
                    jumpIndex = (start + k) > nums.length - 1 ? (start + k) % nums.length : (start + k); // 需要交换的位置，如果超过数组长度则循环
//                    System.out.println(jumpIndex);
                    next = nums[jumpIndex]; // 下一次替换的数 如 1 到 4的位置 则next = 4
                    nums[jumpIndex] = startNum; // 将初始的数赋值给需要换的数
//                    System.out.println(Arrays.toString(nums));
                    start = jumpIndex; // 1 到 4 下一次就从 4 开始
                    startNum = next; // 下一次交换的数
                    count ++;
                } while (start != i);
            }
        //}
    }
}

