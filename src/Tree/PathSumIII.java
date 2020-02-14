package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/14 21:59
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        // 此递归的作用是遍历子树，来寻找所有可能的路径起点，因此还要不断向左子树或者右子树递归
        if (root == null) return 0;
        int ret = pathSumStartWithRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return ret;
    }

    private int pathSumStartWithRoot(TreeNode root, int sum) {
        if (root == null) return 0;
        int ret = 0;
        if (root.val == sum) ret++;
        // 此层递归的作用是判断以当前结点为起始的结点，寻找满足当前和的路径个数
        ret += pathSumStartWithRoot(root.left, sum - root.val) + pathSumStartWithRoot(root.right, sum - root.val);
        return ret;
    }

}
