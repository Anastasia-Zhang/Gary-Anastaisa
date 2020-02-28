package offer;

import common.TreeNode;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/27 19:23
 */
// 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
// B是A的子结构， 即 A中有出现和B相同的结构和节点值。
// 注意子树和子结构的区别，只要存在这个结构就可以，子树要求结点都一样
public class 面试题26树的子结构 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        boolean result = false;
        if (A != null && B != null) {
            if (A.val == B.val)
                // 如果结点的两个值相等，那么再递归的去沿着 A 结点同时遍历 A 和 B 是否相等
                result = isSubStructureWithRoot(A, B);
            if (!result)
                // 如果这个子结构不相等，那么就继续遍历 A 的左子树或者右子树寻找这个结点
                result = isSubStructure(A.left, B);
            if (!result)
                result = isSubStructure(A.right, B);
        }
//        if (A == null || B == null) return false;
//        return DFS(A,B) || isSubStructure(A.left,B) || isSubStructure(A.right,B);

        return result;
    }
    // 同时遍历 A 和 B 判断是否是相等的结构
    public boolean isSubStructureWithRoot(TreeNode A, TreeNode B) {
        // 递归结束的条件
        // 如果 B 遍历完了 那么代表 B 的子结构全在 A 里
        // 注意和子树的区别，子树要求他们的结点和子孙完全相同，所以两个数必须同时遍历完
        // if (s == null && t == null) return true;
        if (B == null) return true;
        if (A == null) return false;
        if (A.val != B.val) return false;
        // A 和 B 的左右子树必须同时满足
        return isSubStructureWithRoot(A.left, B.left) && isSubStructureWithRoot(A.right, B.right);
    }
}
