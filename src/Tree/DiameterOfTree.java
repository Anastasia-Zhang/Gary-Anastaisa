package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/14 20:39
 */
public class DiameterOfTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }

    // 在遍历二叉树结点的过程中记录左右子树的最大深度
    // 同时更新左右两个子树的深度之和
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int rightDepth = maxDepth(root.right);
        int leftDepth = maxDepth(root.left);
        max = Math.max(max, rightDepth + leftDepth);
        return Math.max(rightDepth, leftDepth) + 1;
    }
}
