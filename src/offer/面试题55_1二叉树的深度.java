package offer;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/5 19:25
 */
public class 面试题55_1二叉树的深度 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        // 计算左子树的深度和右子树的深度 取最大值
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}
