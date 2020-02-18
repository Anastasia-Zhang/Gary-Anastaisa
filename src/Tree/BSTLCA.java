package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/18 1:37
 */
public class BSTLCA {
    // 最近公共结点
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 当前的根都比结点大，就去左子树去找
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        // 当前的根都比结点小，就去右子树找
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p ,q);
        return root;
    }
}
