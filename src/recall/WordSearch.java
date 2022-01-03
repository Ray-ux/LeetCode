package recall;

import java.util.Arrays;

/**
 * @author 张烈文
 */
public class WordSearch {

    //    右下左上，顺时针
    int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    int m,n;
    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        boolean[][] used = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (bfs(word, 0, board, i, j,used)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean bfs(String word, int index, char[][] board, int startx, int starty,boolean[][] used) {
//        当最后一个元素等于当前数组中的元素
        if (index == word.length()-1) {
            return board[startx][starty] == word.charAt(index);
        }
        if (board[startx][starty]==word.charAt(index)) {
            used[startx][starty] = true;
            for (int i = 0; i < d.length; i++) {
                int newStartx = startx + d[i][0];
                int newStarty = starty + d[i][1];
                if (inArea(newStartx, newStarty) && !used[newStartx][newStarty] && bfs(word, index + 1, board, newStartx, newStarty, used)) {
                    return true;
                }
            }
//            回溯
            used[startx][starty] = false;
        }
        return false;
    }

    private boolean inArea(int newStartx, int newStarty) {
        return newStartx >= 0 && newStartx < m && newStarty >= 0 && newStarty < n;
    }

}
