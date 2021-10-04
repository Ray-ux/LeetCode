package array;

/**
 * 螺旋矩阵Ⅱ
 * @author 张烈文
 * @date 2021/10/4 19:13
 */
public class SpiralMatrixII {

    public int[][] generateMatrix(int n) {
        int startX = 0, startY = 0;
        int count = 0;
        int[][] res = new int[n][n];
        int loop = n / 2;
        int offset = 1;
        int mid = n / 2;
        while (loop > 0) {
            int i = startX;
            int j = startY;
            for (; j < startY + n - offset; j++) {
                res[i][j] = count++;
            }
            for (; i < startX + n - offset; i++) {
                res[i][j] = count++;
            }
            for (; j > startY; j--) {
                res[i][j] = count++;
            }
            for (; i > startX; i--) {
                res[i][j] = count++;
            }

            loop--;
            startX += 1;
            startY += 1;
            offset += 2;
        }
        if (n % 2 == 1) {
            res[mid][mid] = count;
        }
        return res;
    }
}
