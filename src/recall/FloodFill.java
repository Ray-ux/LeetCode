package recall;

/**
 * 图像渲染
 *
 * @author 张烈文
 */
public class FloodFill {

    /**
     * 最普通的洪水泛滥问题，我们每访问一个就记得要标记为已访问过了，要不然我们每次顺时针访问周围元素时，会造成栈溢出
     */
    int[][] dir = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
    boolean[][] visited;
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int curColor = image[sr][sc];
        visited = new boolean[image.length][image[0].length];
        return dfs(image, sr, sc, curColor, newColor);
    }

    private int[][] dfs(int[][] image, int x, int y, int color, int newColor) {
        visited[x][y] = true;
        if (image[x][y] == color) {
            image[x][y] = newColor;
            for (int i = 0; i < dir.length; i++) {
                int newX = x + dir[i][0];
                int newY = y + dir[i][1];
                if (newX >= 0 && newX < image.length && newY >= 0 && newY < image[0].length&&!visited[newX][newY]) {
                    dfs(image, newX, newY, color, newColor);
                }
            }
        }
        return image;
    }
}
