package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 螺旋矩阵
 *
 * @author 张烈文
 * @date 2021/10/4 20:14
 */
public class SpiralMatrix {
    /**
     * 参考了题解
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res=new ArrayList();
        // 设置上边界
        int u=0;
        // 设置左边界
        int l=0;
        // 设置下边界
        int b=matrix.length-1;
        // 设置右边界
        int r=matrix[0].length-1;
        while(true){
//            向右移动，移到最右边
            for(int i=l;i<=r;i++) {
                res.add(matrix[u][i]);
            }
//            重新设置上边界：因为此时u所对应的那一行已经用过了，
//            倘若设置边界的时候大于或小于其它边界了，那么就退出循环
            if(++u>b) {
                break;
            }
            for(int i=u;i<=b;i++) {
                res.add(matrix[i][r]);
            }
            if(--r<l) {
                break;
            }
            for(int i=r;i>=l;i--) {
                res.add(matrix[b][i]);
            }
            if(--b<u) {
                break;
            }
            for(int i=b;i>=u;i--) {
                res.add(matrix[i][l]);
            }
            if(++l>r) {
                break;
            }
        }
        return res;
    }
}
