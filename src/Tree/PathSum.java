package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/14 21:31
 * 给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        // 递归去看左右子树是否存在目标和
        if (root == null) return false;
        // 如果当前结点是叶子结点，且剩下的和为0（子问题的目标和为0）
        if (root.right == null && root.left == null && sum - root.val == 0) return true;
        // 去左右子树递归的寻找剩下的和， 和为sum 值减去当前节点的权值
        return hasPathSum(root.right, sum - root.val) ||
                hasPathSum(root.left, sum - root.val);
    }
}
