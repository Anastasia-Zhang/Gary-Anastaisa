package Tree;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/19 11:53
 */
public class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return generateBST(nums, 0, nums.length - 1);
    }

    public TreeNode generateBST(int[] nums, int start, int end){
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = generateBST(nums, start, mid - 1);
        node.right = generateBST(nums, mid + 1, end);
        return node;
    }
}
