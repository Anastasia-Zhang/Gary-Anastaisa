package offer;

import java.util.ArrayList;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/2/27 21:18
 */
public class 面试题29顺时针打印矩阵 {
    int index = 0;
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        // 每一圈打印的起始索引 (1,1) (2,2)。。
        int start = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[] res = new int[row * col];
        // 循环打印的条件
        while (row > start * 2 && col > start * 2){
            addMatrix(matrix, row, col, start, res);
            //System.out.println(Arrays.toString(res));
            ++start;


        }
        return res;
    }

    public void addMatrix(int[][] matrix, int row, int col, int start, int[] res){

        int endX = col - 1 - start; // 终止列号
        int endY = row - 1 - start; // 终止行号

        // 从左到右打印第一行
        for (int i = start; i <= endX; i++){
            res[index++] = matrix[start][i];
        }

        // 从上到下打印一列，首先得保证有两行数据
        if (start < endY){
            for (int i = start + 1; i <= endY; i++){
                res[index++] = matrix[i][endX]; // 列的值保持在终止列号不变
            }
        }

        // 从左到右打印一列，必须大于两行，必须大于两列
        if (start < endX && start < endY){
            for (int i = endX - 1; i >= start; i--){
                res[index++] = matrix[endY][i];
            }
        }

        // 从下到上打印一列，必须得是三行两列，终止行号至少比起始行号大于2
        if (start < endX && start <  endY - 1){
            for (int i = endY - 1; i >= start + 1; --i){
                res[index++] = matrix[i][start];
            }
        }
    }
}
