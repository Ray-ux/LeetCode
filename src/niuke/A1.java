package niuke;

/**
 * 二维数组中的查找
 * @author 张烈文
 * @date 2021/9/19 14:38
 */
public class A1 {

    public boolean Find(int target, int [][] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] == target) {
                    return true;
                } else if (array[i][j] > target) {
                    break;
                }
            }
        }
        return false;
    }
}
