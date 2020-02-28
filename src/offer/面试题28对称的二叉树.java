package offer;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/27 20:27
 */
public class 面试题28对称的二叉树 {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root, root);
    }

    public boolean isSymmetric(TreeNode root1, TreeNode root2){
        // 两颗树的结构必须一样
        if (root1 == null && root2 == null) return true;
        if (root1 == null || root2 == null) return false;
        if (root1.val != root2.val) return false;
        // 先根后右左遍历和先根后左右遍历两颗树是一样的
        // 如果 root1 和 root2 当前根节点相等，那么树1的右子树和树2的左子树相等，树1的左子树和树2的右子树相等
        return isSymmetric(root1.right, root2.left) && isSymmetric(root1.left, root2.right);
    }
}
