package common;

import java.util.*;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/16 13:31
 */
public class TreeNodeTraverse {
    // 层次遍历
    // 统计所有二叉树的每层的平均值
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for (int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                sum += node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            res.add(sum / size);
        }
        return res;
    }

    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            // 直接赋值操作就可以，遍历到最后的一定就是 最右下角的值
            root = queue.poll();
            if (root.right != null) queue.add(root.right);
            if (root.left != null) queue.add(root.left);
        }
        return root.val;
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root); // 为空不报错
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) continue;
            res.add(node.val);
            stack.push(node.right); // 先右后左
            stack.push(node.left);
        }
        return res;
    }

    // 前序遍历为 root -> left -> right，后序遍历为 left -> right -> root。
    // 可以修改前序遍历成为 root -> right -> left，那么这个顺序就和后序遍历正好相反
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root); // 为空不报错
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            if (node == null) continue;
            res.add(node.val);
            // 先左后右
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            // 当前结点一直向右走，一直走到尽头
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            // 取出当前结点，把取出的结点加到结果集当中
            TreeNode node = stack.pop();
            res.add(node.val);
            // 再从当前结点的右节点开始遍历
            cur = node.right;
        }
        return res;
    }

}
