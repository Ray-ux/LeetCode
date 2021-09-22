package offershow.fourday;

/**
 * 二维区域和检索-矩阵不可变
 * @author 张烈文
 * @date 2021/9/22 12:33
 */
public class Offer13 {

    int[][] matrix;
    int[][] preSum;

    public Offer13(int[][] matrix) {
        this.matrix = matrix;
        int m = matrix.length;
        int n = 0;
        if (m!=0) {
            n = matrix[0].length;
        }
        preSum = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n + 1; j++) {
                preSum[i][j] = preSum[i][j - 1] + matrix[i][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += preSum[row1][col2 + 1] - preSum[row1][col1];
        }
        return sum;
    }
}
