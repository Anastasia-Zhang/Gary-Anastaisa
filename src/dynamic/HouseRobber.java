package dynamic;

/**
 * 每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 * [2,1,1,2]
 * 输出 4
 * */

public class HouseRobber {
//    动态规划
//    动态规划方程：dp[n] = MAX( dp[n-1], dp[n-2] + num )
//    由于不可以在相邻的房屋闯入，所以在当前位置 n 房屋可盗窃的最大值，要么就是 n-1 房屋可盗窃的最大值，要么就是 n-2 房屋可盗窃的最大值加上当前房屋的值，二者之间取最大值
//    举例来说：
//    1 号房间可盗窃最大值为 3 即为 dp[1]=3，2 号房间可盗窃最大值为 4 即为 dp[2]=4，
//    抢第三个房子，将数额与第一个房子相加。
//    不抢第三个房子，保持现有最大数额。
//    3 号房间自身的值为 2 即为 num=2，
//    那么 dp[3] = MAX( dp[2], dp[1] + num ) = MAX(4, 3+2) = 5，3 号房间可盗窃最大值为 5
//    时间复杂度：O(n)，n 为数组长度

    public int rob(int[] nums) {
//       int len = nums.length;
//       if(len == 0) return 0;
//       int[] dp = new int[len + 1];
//       dp[0] = 0;
//       dp[1] = nums[0];
//       for (int i = 2;i <= len;i ++){
//           dp[i] = Math.max(dp[i - 1],dp[i - 2] + nums[i - 1]);
//       }
//       return dp[len];
        // 优化，最大值最小值用变量来优化
        int curMax = 0; // 上一次循环中的最大值，在循环中更新
        int preMax = 0; // 前两次循环中的最大值，用于在循环中记录上一次的最大值
        for (int x : nums){
            int temp = curMax; // 上一次的最大值
            curMax = Math.max(x + preMax, curMax); // 用于更新
            preMax = temp; // 用于下一次的更新
        }
        return curMax;
    }
}
