package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/20 23:20
 */
public class MInDiffBST {
    // 中序遍历有序，记录中序遍历的前一个结点和当前结点的差值
    int minDiff = Integer.MAX_VALUE;
    TreeNode preNode = null;
    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    public void inorder(TreeNode root){
        if (root == null) return;
        inorder(root.left);
        if (preNode != null) minDiff = Math.min(minDiff, root.val - preNode.val);
        preNode = root;
        inorder(root.right);
    }
}
