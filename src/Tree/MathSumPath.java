package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/17 16:34
 */
public class MathSumPath {
    public static void main(String[] args) {
        Object[] obj = new Object[]{1,2,3,4,5,6,7};
        TreeNode treeNode = new TreeNode();
        treeNode = TreeNode.create(obj);
        maxPathSum(treeNode);
        System.out.println(ans);
    }

    static int ans;
    public static int maxPathSum(TreeNode root) {
        ans = root.val;
        maxSum(root);
        return ans;
    }
    public static int maxSum(TreeNode node){
        if (node == null) {
            return 0;
        }
        if (node.right == null && node.left == null) {
            // 当前结点作为最小的值
            ans = Math.max(ans, node.val);
            return node.val;
        }
        // 最大值的结点有三种情况，找出当前结点的左子树和右子树的最大值，结果相加
        int rightSum = maxSum(node.right);
        int leftSum = maxSum(node.left);
        // 如果都小于0则应该都舍去
        if (leftSum < 0) leftSum = 0;
        if (rightSum < 0) rightSum = 0;
        ans = Math.max(ans, rightSum + leftSum + node.val);
        return Math.max(leftSum + node.val, rightSum + node.val);
    }
}
