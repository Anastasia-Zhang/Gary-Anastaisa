package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/14 20:28
 */
public class IsBalanceTree {
    private boolean isBalanced = true;

    public boolean isBalanced(TreeNode root) {
        maxDepth(root);
        return isBalanced;
    }

    // 遍历二叉树的过程中，不断求最大深度，判断左右子树的高度判断是否是平衡二叉树
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int rightDepth = maxDepth(root.right);
        int leftDepth = maxDepth(root.left);
        if (Math.abs(rightDepth - leftDepth) > 1) isBalanced = false;
        return Math.max(rightDepth, leftDepth) + 1;
    }
}
