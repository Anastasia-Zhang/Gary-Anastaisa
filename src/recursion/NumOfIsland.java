package recursion;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/15 0:22
 */
public class NumOfIsland {
    static boolean[][] visited;

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                new char[]{'1','0','1','1','0','1','1'}
        };
        numIslands(grid);
    }
    public static int numIslands(char[][] grid) {
        if (grid == null) return 0;
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }
        return count;
    }

    // dfs 做标记
    public static void dfs(int i, int j, char[][] grid){
        // 递归出口 越界、访问过、0
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0' || visited[i][j])
            return;
        visited[i][j] = true;
        dfs(i - 1, j ,grid);
        dfs(i + 1, j ,grid);
        dfs(i, j - 1 ,grid);
        dfs(i, j + 1 ,grid);
    }

    public int numIslandsBSF(char[][] grid) {
        if (grid == null) return 0;
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        visited = new boolean[row][col];
        //           x-1,y
        //  x,y-1    x,y      x,y+1
        //           x+1,y
        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int count = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    // dfs(i, j, grid);
                    // bfs
                    LinkedList<Integer> queue = new LinkedList<>(); // 存遍历过的下标
                    queue.addLast(i * col + j); // 压缩成一维的下标
                    visited[i][j] = true;
                    while (!queue.isEmpty()){
                        int index = queue.poll();
                        int curX = index / col;
                        int curY = index % col;
                        // 四个方向的遍历
                        for (int k = 0; k < 4; k++){
                            int x = directions[k][0] + curX;
                            int y = directions[k][1] + curY;
                            if (inArea(x,y,row,col) && grid[x][y] == '1' && !visited[x][y]){
                                queue.addLast(x * col + y);
                                visited[x][y] = true;
                            }
                        }
                    }
                }
            }
        }
        return count;
    }
    private boolean inArea(int x, int y, int col, int row) {
        // 等于号这些细节不要忘了
        return x >= 0 && x < row && y >= 0 && y < col;
    }

}
