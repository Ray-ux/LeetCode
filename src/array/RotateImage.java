package array;

import java.util.Arrays;

/**
 * 旋转图像
 *
 * @author 张烈文
 */
public class RotateImage {

    /**
     * 思路一：开辟一个新数组，行和列对换即可
     * 但是不满足题目要求。没做到只要原数组进行翻转
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int[][] tmp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                tmp[i][j] = matrix[i][j];
            }
        }
        for (int i = 0,r = tmp.length-1; i < tmp.length; i++,r--) {
            for (int j = 0; j < tmp[i].length; j++) {
                matrix[j][r]=tmp[i][j];
            }
        }
    }

    /**
     * 思路2：沿着副对角线翻转，然后沿着中线翻转,原地翻转
     *
     * 副对角线交换：[i][j] 和 [n-1-j][n-1-i] 交换
     * 中线交换：[i][j] 和 [n-1-i][j] 交换
     * @param matrix
     */
    public void rotate1(int[][] matrix) {
        int n = matrix.length;
//        沿着副对角线反转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n - i; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - j][n - 1 - i];
                matrix[n - 1 - j][n - 1 - i] = tmp;
            }
        }
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < n; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = tmp;
            }
        }
    }

}
