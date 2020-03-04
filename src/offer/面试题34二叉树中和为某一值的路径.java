package offer;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/29 11:36
 */
public class 面试题34二叉树中和为某一值的路径 {
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        char a = '2';

        System.out.println(a - '0');
        System.out.println(a - 'a');
//        TreeNode root = TreeNode.create(new Object[]{10, 5, 2, 4, 7});
//        pathSum(root, 22);
    }
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) return res;
        List<Integer> path = new ArrayList<>();
        findPathSum(root, sum, path);
        return res;
    }

    public static void findPathSum(TreeNode root, int sum, List<Integer> path){

        // if (sum < 0 || root == null) return;
        path.add(root.val);

        // 递归终点, 必须把当前结的值减掉
        if (root.right == null && root.left == null && sum - root.val == 0){
            res.add(new ArrayList<>(path));
            return;
        }

        if (root.left != null) {
            // 直接 new 会慢很多
            // findPathSum(root.left, sum - root.val , new ArrayList<>(path));
            findPathSum(root.left, sum - root.val , path);
            path.remove(path.size() - 1);
        }


        if (root.right != null){
            findPathSum(root.right, sum - root.val, path);
            path.remove(path.size() - 1);
        }


    }

    public void findPathSum(TreeNode root, int sum, List<Integer> path, int target){
        // 注意这两句的位置，是把这个根节点先拿到，放到path里面，和加上之后才要判断是否是终点
        // 要不然叶子节点在验证之前放不进去
        // 因永远也递归不到 null 结点
        path.add(root.val);
        target += root.val;
        // 递归终点
        // if (root == null && sum == 0)
        if (root.right == null && root.left == null && sum == target){
            // System.out.println("0000");
            res.add(new ArrayList<>(path));
            return;
        }

        if (root.left != null) {

            findPathSum(root.left, sum, path, target);
            path.remove(path.size() - 1);
        }
        if (root.right != null) {

            findPathSum(root.right, sum, path, target);
            path.remove(path.size() - 1);
        }
    }
}
