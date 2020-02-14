package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/14 20:47
 */
public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        // 递归的翻转左右子树
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
