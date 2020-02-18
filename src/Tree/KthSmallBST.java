package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/17 10:28
 */
public class KthSmallBST {
    public int kthSmallest(TreeNode root, int k) {
        // 先去左子树查找：统计左子树的结点数量
        int leftCount = countNodes(root.left);
        // 如果左子树的数量正好等于 k - 1，则该节点正好是第k小的结点
        if (leftCount == k - 1) return root.val;
            // 如果左子树的数量大于 k - 1,则去左子树搜索
        else if (leftCount > k - 1) return kthSmallest(root.left, k);
            // 说明在右子树，转换成求右子树中第 k - 1 - leftCount 小的结点
        else return kthSmallest(root.right, k - 1 - leftCount);
    }

    // 统计结点的数量
    public int countNodes(TreeNode root){
        if (root == null) return 0;
        int left = countNodes(root.left);
        int right = countNodes(root.right);
        return left + right + 1;
    }
}
