package recursion;

/**
 * @author Zhang Xinyu
 * @version 1.0
 * @date 2020/3/15 22:35
 */
public class AreaOfIsland {
    static boolean[][] visited;

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                new int[]{1,1,0,0,0},
                new int[]{1,1,0,0,0},
                new int[]{0,0,0,1,1},
                new int[]{0,0,0,1,1}
        };
        maxAreaOfIsland(grid);

    }
    public static int maxAreaOfIsland(int[][] grid) {
        if (grid == null) return 0;
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        visited = new boolean[row][col];
        int count = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (!visited[i][j] && grid[i][j] == 1) {
                    count = Math.max(count, dfs(i, j, grid));
                }
            }
        }
        return count;
    }

    // dfs 做标记
    public static int dfs(int i, int j, int[][] grid){
        // 递归出口 越界、访问过、0
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0 || visited[i][j])
            return 0;
        visited[i][j] = true;
        int res = dfs(i - 1, j ,grid)+
                dfs(i + 1, j ,grid) +
                dfs(i, j - 1 ,grid) +
                dfs(i, j + 1 ,grid) + 1;
        // visited[i][j] = false;
        return res;
    }
}
