package array;

/**
 * 有效的数独
 *
 * @author 张烈文
 */
public class ValidSudoku {

    /**
     * 判断当前行，当前列，当前block是否已经出现过这个数字
     * @param board
     * @return
     */
    public boolean isValidSudoku(char[][] board) {

        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!(board[i][j] == '.')) {
                    int curNum = board[i][j] - '0';
//                    获取当前[i,j]是第几个box
                    int boxIndex = j / 3 + (i / 3) * 3;
//                    如果当前行已经出现过了，则返回false
//                    如果当前列已经出现过了，则返回false
//                    如果当前block已经出现过了，则返回false
                    if (row[i][curNum] ==1|| col[j][curNum]==1 || box[boxIndex][curNum]==1) {
                        return false;
                    }
//                没有出现过，则在当前行列，block，将该元素标记为已出现过
                    row[i][curNum] = 1;
                    col[j][curNum] = 1;
                    box[j / 3 + (i / 3) * 3][curNum] = 1;
                }
            }
        }
        return true;
    }
}
