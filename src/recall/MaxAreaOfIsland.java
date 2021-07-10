package recall;

/**
 * 岛屿的最大面积
 *
 * @author 张烈文
 */
public class MaxAreaOfIsland {

    int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    int m = 0;
    int n = 0;
    boolean[][] used;
    /**
     * 实际上此题类似于岛屿的数量那题
     *
     * 但是需要特别注意一点的是没发现一个岛屿记得保存当前岛屿的最大面积
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {

        int max = 0;
        m = grid.length;
         n = grid[0].length;
        used = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !used[i][j]) {
                    int curMax = bfs(grid, 1, used, i, j);
                    max = Math.max(curMax, max);
                }
            }
        }
        return max;
    }

    private int bfs(int[][] grid, int areas, boolean[][] used,int startx,int  starty) {
        used[startx][starty] = true;
        for (int i = 0; i < dir.length; i++) {
            int newStartx = startx + dir[i][0];
            int newStarty = starty + dir[i][1];
            if (inArea(newStartx, newStarty) && !used[newStartx][newStarty] && grid[newStartx][newStarty] == 1) {
                areas = bfs(grid, areas + 1, used, newStartx, newStarty);
            }
        }
        return areas;
    }

    private boolean inArea(int newStartx, int newStarty) {

        return newStartx >= 0 && newStartx < m && newStarty >= 0 && newStarty < n;
    }

    public static void main(String[] args) {
        MaxAreaOfIsland max = new MaxAreaOfIsland();
        max.maxAreaOfIsland(new int[][]{{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}});
    }
}
