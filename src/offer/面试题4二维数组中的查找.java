package offer;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/22 14:22
 */
public class 面试题4二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null) return false;
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) return false;
        int row = 0;
        int col = n - 1;
        // 从右上角遍历数组，缩小查找范围，剔除行或者列
        while (row <= m - 1 && col >= 0){
            if (matrix[row][col] == target) return true;
                // 如果数列的数比目标数大 则肯定不在目标数所在的列，缩小列
            else if (matrix[row][col] > target) col--;
                // 如果比目标数小缩小所在的行
            else row++;
        }
        return false;
    }

}
