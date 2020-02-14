package Tree;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/14 20:21
 */

import common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int rightDepth = maxDepth(root.right);
        int leftDepth = maxDepth(root.left);
        return Math.max(rightDepth, leftDepth) + 1;
    }
}
