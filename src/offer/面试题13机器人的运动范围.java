package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/24 15:07
 */
public class 面试题13机器人的运动范围 {

    boolean[][] visitd = null;
    public int movingCount(int m, int n, int k) {
        if (k == 0) return 1;
        int[][] boards = new int[m][n];
        visitd = new boolean[m][n];
        return moveCount(boards, 0, 0, k);
    }

    public int moveCount(int[][] boards, int i, int j, int k){
        // if (i < 0 || i >= boards.length || j < 0 || j >= boards[0].length
        //         || getDigitSum(i) + getDigitSum(j) > k || visitd[i][j]) return 0;
        if (i < 0 || i >= boards.length || j < 0 || j >= boards[0].length
                || getDigitSum(i) + getDigitSum(j) > k || boards[i][j] == 1) return 0;
        int temp = boards[i][j];
        boards[i][j] = 1;
        visitd[i][j] = true;
        int res = 1 + moveCount(boards, i + 1, j, k) +
                moveCount(boards, i - 1, j, k) +
                moveCount(boards, i, j + 1, k) +
                moveCount(boards, i, j - 1, k);
        // boards[i][j] = temp; 无须恢复现场因为是一次调用，他的调用结果无须给下一次循环做准备
        return res;
    }

    public int getDigitSum(int num){
        int sum = 0;
        while (num > 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
