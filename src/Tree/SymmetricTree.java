package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/14 22:31
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        // 从左右子树开始判断是否为对称的树
        return isSymmetric(root.left, root.right);
    }

    // 判断两个树是否为相等的树
    public boolean isSymmetric(TreeNode t1, TreeNode t2){
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        // 对称的话，从该结点触发的的左子树和右子树必须相等，两种情况，左右 右左
        return isSymmetric(t1.right, t2.left) && isSymmetric(t1.left, t2.right);
    }
}
