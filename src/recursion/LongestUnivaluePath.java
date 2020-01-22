package recursion;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/1/17 15:03
 */

import common.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LongestUnivaluePath {
    public static void main(String[] args) {

    }

    int ans = 0;

    public int longestUnivaluePath(TreeNode root) {
        arrowLength(root);
        return ans;

    }


    /**
     * 每个结点都有单侧的最长路径和左右两侧是最长路径，该函数返回的是包括该节点在内的单侧最长路径
     * https://github.com/echofoo/ARTS/blob/master/A-20190925-%E6%9C%80%E9%95%BF%E5%90%8C%E5%80%BC%E8%B7%AF%E5%BE%84.md
     * */
    public int arrowLength(TreeNode node){
        if (node == null) return 0;
        int right = arrowLength(node.right);
        int left = arrowLength(node.left);
        int arrowRight = 0, arrowLeft = 0;
        // 递归用于计算该节点在内的左右子树的最长路径
        // 计算在该节点在内的单侧最长路径，用于递归回溯返回父节点以计算该节点的最长路径
        if (node.left != null && node.left.val == node.val) arrowLeft = left + 1;
        if (node.right != null && node.right.val == node.val) arrowRight = right + 1;
        // 更新全局最长路径，用于返回最终结果（左子树的最长路径 + 右子树的最长路径）
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

}
