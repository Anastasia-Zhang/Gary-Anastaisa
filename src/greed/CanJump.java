package greed;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/22 20:03
 */
public class CanJump {
    public boolean canJump3(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++){
            if (i > k) return false;
            k = Math.max(k, i + nums[i]);
        }
        return true;
    }
    int[] memo;
    public boolean canJump(int[] nums) {
        // 所有的顶点都有三种状态：能跳到终点 1、不能跳到终点 0、 未知 （还未遍历到、初始化）2
        memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = 2;
        }
        memo[nums.length - 1] = 1;
        return canJump(nums, 0);
    }

    public boolean canJump(int[] nums, int position) {
        // if (position == nums.length - 1) return true;
        if (memo[position] != 2) {
            return memo[position] == 1;
        }
        int jumpIndex = Math.min(position + nums[position], nums.length - 1);
        // 从当前起点到终点都跳一遍，看能不能找到跳到终点的一条路径
        for (int i = jumpIndex; i > position; i--) {
            // 如果当前结点存在能够达到终点的一条路径 i 代表从当前路径开始 跳 1 步、2 步、直到跳到最大 能跳到的位置
            if (canJump(nums, i)) {
                // 代表当前能够跳到终点
                memo[position] = 1;
                return true;
            }
        }
        memo[position] = 0;
        return false;
    }
}
