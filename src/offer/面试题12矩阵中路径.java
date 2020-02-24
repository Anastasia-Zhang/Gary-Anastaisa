package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/24 14:15
 */
public class 面试题12矩阵中路径 {
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0 || board == null) return false;
        char[] words = word.toCharArray();
        // 深度优先遍历，查询每个可能的起点是否含有这样的给定路径
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[0].length; j++){
                if (find(board, i, j, 0, words)) return true;
            }
        }
        return false;
    }

    public boolean find(char[][] board, int i, int j, int index, char[] words){
        // 数组越界，已经访问过，不相等
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != words[index]) return false;
        // 找到一条路径，返回 true
        if (index == words.length - 1) return true;
        char temp = board[i][j];
        // 设置字符代表已经放过 ，访问过的设置一个特殊字符，给定的数组里
        board[i][j] = '/';
        boolean res = find(board, i + 1, j, index + 1, words) ||
                find(board, i - 1, j, index + 1, words) ||
                find(board, i, j - 1, index + 1, words) ||
                find(board, i, j + 1, index + 1, words);
        // 恢复现场，上面的函数循环调用，需要回复现场，给下一次的循环做准备
        board[i][j] = temp;
        return res;
    }
}
