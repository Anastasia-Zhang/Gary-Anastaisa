package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/16 14:59
 */
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        // 若当前结点的值大于右边界的值，应该去左子树修剪
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);
        // 合并修剪的结果
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
