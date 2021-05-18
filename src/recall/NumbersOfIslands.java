package recall;

/**
 * @author 张烈文
 */
public class NumbersOfIslands {
    //    顺时针方向从当前位置向右下左上移动位置

    int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    //    m,n记录字符数组的行数和列数

    int m,n;

    //    判断当前下标是否在字符数组下标内
    private boolean inArea(int newStartx, int newStarty) {
        return newStartx >= 0 && newStartx < m && newStarty >= 0 && newStarty < n;
    }

//    广度遍历
    private void bfs(char[][] grid,int startx,int starty,boolean[][] visited){
//       对当前访问元素，设为已被访问
        visited[startx][starty] = true;
//        通过一个for循环来对当前位置向四个方向移动
        for (int i = 0; i < 4; i++) {
            int newStartx=startx+d[i][0];
            int newStarty=starty+d[i][1];
//            若待搜索的位置在区域内且未被访问过且带搜索位置的元素为'1'，则继续向下搜索
            if (inArea(newStartx, newStarty) && !visited[newStartx][newStarty]&&grid[newStartx][newStarty]=='1') {
//                从新位置继续搜索
                bfs(grid, newStartx, newStarty, visited);
            }
        }
        return;
    }
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
//                若当前位置元素等于1且未被访问则进行向下搜索
                if (grid[i][j]=='1'&&!visited[i][j]){
                    res++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return res;
    }

}
