package Tree;

import common.TreeNode;

import java.util.HashMap;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/15 14:36
 */
public class RobHouseIII {
    int res = 0;
    public int rob(TreeNode root) {
        if (root == null) return 0;
        robHouse(root);
        int res1 = res;
        int res2 = 0;
        int res3 = 0;
        if (root.left != null) {
            res = 0;
            robHouse(root.left);
            res2 = res;
        }
        if (root.right != null){
            res = 0;
            robHouse(root.right);
            res3 = res;
        }
        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
        return Math.max(res1, res2 + res3);
    }

    public int robHouse(TreeNode root){
        if (root == null) return 0;

        if (root.right == null && root.left == null){
            res = Math.max(res, root.val);
            return root.val;
        }
        int right = 0;
        int left = 0;
        // 这样做完全是间隔遍历

        if (root.right != null) right = robHouse(root.right.right) + robHouse(root.right.left);
        if (root.left != null) left = robHouse(root.left.left)  + robHouse(root.left.right);
        res = Math.max(right + left + root.val, res);
        // 这样计算就相当于当前结点必须得偷
        return Math.max(right, left) + root.val;
    }

    public int rob1(TreeNode root) {
        if (root == null) return 0;

        int money = root.val;
        if (root.left != null) {
            money += (rob1(root.left.left) + rob1(root.left.right));
        }

        if (root.right != null) {
            money += (rob1(root.right.left) + rob1(root.right.right));
        }

        return Math.max(money, rob1(root.left) + rob1(root.right));
    }

    HashMap<TreeNode, Integer> memo = new HashMap<>();

    public int rob2(TreeNode root) {
        if (root == null) return 0;
        if (memo.containsKey(root)) return memo.get(root);

        int money = root.val;
        if (root.left != null) {
            // 抢劫他的左边两个孙子结点
            money += (rob2(root.left.left) + rob2(root.left.right));
        }

        if (root.right != null) {
            // 抢劫他的右边两个孙子结点
            money += (rob2(root.right.left) + rob2(root.right.right));
        }

        // 和他的两个儿子结点作比较
        int res = Math.max(money, rob2(root.left) + rob2(root.right));
        memo.put(root, res);
        return res;
    }

    public int rob3(TreeNode root){
        int[] result = robInternal(root);
        return Math.max(result[0], result[1]); // 偷和不偷两种情况
    }
    public int[] robInternal(TreeNode root){
        if (root == null) return new int[2];
        int[] result = new int[2];

        int[] left = robInternal(root.left); // 左子树偷和不偷两种情况的结果
        int[] right = robInternal(root.right);

        // 两种情况
        result[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        result[1] = left[0] + right[0] + root.val;
        return result;
    }


}
