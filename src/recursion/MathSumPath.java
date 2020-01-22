package recursion;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/17 16:34
 */
public class MathSumPath {
    public static void main(String[] args) {
        Object[] obj = new Object[]{1,2,null,3,null,4,null,5};
        TreeNode treeNode = new TreeNode();
        treeNode = treeNode.create(obj);
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
            ans = Math.max(ans, node.val);
            return node.val;
        }
        int rightSum = maxSum(node.right);
        int leftSum = maxSum(node.left);
//        int maxRight = 0;
//        int maxLeft = 0;
//        if (node.right != null){
//            maxRight = rightSum;
//        }
//        if (node.left != null){
//            maxLeft = leftSum;
//        }
        // 如果都小于0则应该都舍去
        if (leftSum < 0) leftSum = 0;
        if (rightSum < 0) rightSum = 0;
        // int subSum = (maxLeft < 0 || maxRight < 0) ? Math.max(maxLeft, maxRight) : maxLeft + maxRight;
        ans = Math.max(ans, rightSum + leftSum + node.val);
//        int subSum = (maxLeft < 0 || maxRight < 0) ? Math.max(maxLeft, maxRight) : maxLeft + maxRight;
        return Math.max(leftSum + node.val, rightSum + node.val);
    }
}
