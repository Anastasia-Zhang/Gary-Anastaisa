package Tree;

import common.TreeNode;

import java.util.ArrayList;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/21 23:27
 */
public class FindModBST {
    TreeNode preNode = null;
    int curCount = 1;
    int maxCount = 1;

    public int[] findMode(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        inorder(root, list);
        int[] nums = new int[list.size()];
        for (int i = 0; i < nums.length; i++){
            nums[i] = list.get(i);
        }
        return nums;
    }

    public void inorder(TreeNode root, ArrayList<Integer> nums){
        if (root == null) return;
        inorder(root.left, nums);
        if (preNode != null) {
            // 如果前一个结点和当前结点的值相等
            if (preNode.val == root.val){
                curCount++;
            }else {
                curCount = 1;
            }
        }
        // 和最大值做比较
        if (maxCount < curCount){
            // 当前结点出现的次数是最大值
            maxCount = curCount; // 更新最大值
            nums.clear(); // 清空数组
            nums.add(root.val);
        }
        else if (maxCount == curCount){
            nums.add(root.val);
        }

        preNode = root;
        inorder(root.right, nums);

    }
}
