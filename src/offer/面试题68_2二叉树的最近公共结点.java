package offer;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/7 14:10
 */
public class 面试题68_2二叉树的最近公共结点 {
    // 这个函数的作用就是以 root 为根的树，求 p q 的祖先
    // 有三种情况：p q 位于 root 的右边，p q 在 root 的左边，p q 在root的两边
    // 分解子问题，求 root 子树的结点
    /**
     * 该函数返回以 root 为根的树， p q 的公共祖先
     * @param root 树的根节点
     * @param p p结点
     * @param q q结点
     * @return p q 结点在该数上的最近公共结点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 递归出口，遇到叶子结点或者遇到相等的结点就返回。相等的结点返回本身的值，叶子结点返回 null
        if (root == null || root == p || root == q) {
            return root;
        }
        // root 分别判断他的左右子树是否包含祖先，若包含则返回公共祖先的值
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        // if (left == null){
        //     TreeNode right = lowestCommonAncestor(root.right, p, q);
        // }
        // 回溯个上一层的值，也就是分类讨论的结果
        // 如果他的左子树没有公共结点，那么公共结点一定在他的右子树中，返回右子树的结果
        if (left == null){
            return right;
        }
        // 如果右子树中没有公共结点，那么公共结点一定在他的左子树中，返回左子树结点
        if (right == null){
            return left;
        }
        // 返回根节点
        return root;
    }
}
