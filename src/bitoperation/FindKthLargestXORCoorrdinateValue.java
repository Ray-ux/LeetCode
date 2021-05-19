package bitoperation;

import java.util.Arrays;

/**
 * @author 张烈文
 */
public class FindKthLargestXORCoorrdinateValue {
    public  static int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
//        开辟一个新数组来存储
        int[] res=new int[m*n];
        int index=0;
        for(int a=0;a<m;a++){
            for(int b=0;b<n;b++){
//                当a>0&&b>0时，当前数组值等于上一个值和左边一个值及对角线值的异或
                if(a>0&&b>0){
                    matrix[a][b]^=matrix[a-1][b]^matrix[a][b-1]^matrix[a-1][b-1];
                }
                if(a>0&&b==0) {
                    matrix[a][b] ^= matrix[a - 1][b];
                }
                if(b>0&&a==0){
                    matrix[a][b]^=matrix[a][b-1];
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                res[index++]=matrix[i][j];
            }
        }
//        升序
        Arrays.sort(res);
        return res[index - k-1];
    }

    public static void main(String[] args) {
        int[][] nums = {{5, 2},{1,6}};
        kthLargestValue(nums, 1);
    }

}
