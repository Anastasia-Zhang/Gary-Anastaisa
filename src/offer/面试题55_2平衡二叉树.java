package offer;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/5 19:50
 */
public class 面试题55_2平衡二叉树 {
    public static void main(String[] args) {
        //TreeNode root = TreeNode.create(new Object[]{1,2,2,3,null,null,3,4,null,null,null,null,4});
        // isBalanced2(root);
        int[][] ints = new int[][]{
                new int[]{1,2,3},
                new int[]{1,2}
        };
    }
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        if (Math.abs(left - right) > 1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public int treeDepth(TreeNode root){
        if (root == null) return 0;
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return Math.max(left, right) + 1;
    }

    public static boolean isBalanced2(TreeNode root) {
        if (root == null) return true;
        return treeDepth2(root) > 0;
    }

    // 这个函数在遍历当中得到这个 root 结点的左右子树的深度，再判断是不是平衡二叉树，不过不是平衡二叉树，返回 -1
    public static int treeDepth2(TreeNode root){
        if (root == null) return 0;
        int left = treeDepth2(root.left);
        int right = treeDepth2(root.right);
        // TODO 为什么左右结点小于 0 去掉？因为他的左右结点一旦返回 -1 就代表他的子节点处不是二叉平衡树，因此该节点处也不是二叉平衡树
        // 他的子节点不是二叉平衡树，那么该节点也不是二叉平衡树，为了回溯给他的父节点
        if (left < 0 || right < 0) return -1;
        if (Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
