package offer;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/7 13:26
 */
public class 面试题68_1二叉搜索树的最低公共祖先 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // 从上到下找

        // 如果根节点的值小于两个给定结点，那么这个公共祖先一定是在右子树中
        if (root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right, p, q);
        }
        // 如果根节点的值位于左右两个根节点中间，则就是最近的公共祖先
        // 以下条件可加可不加，默认返回根节点
        // if ((root.val >= p.val && root.val <= q.val) || (root.val <= p.val && root.val >= q.val)){
        //     return root;
        // }
        if (root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }
}
