package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张烈文
 */
public class PascalTriangle {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> res = new ArrayList<>();

//        从第一行开始
        helper(1, numRows, res, new ArrayList<>());
        return res;
    }

//        curRow当前行，prelist上一行
    private void helper(int curRow, int numRows, List<List<Integer>> res, List<Integer> prelist) {
//        当前行数大于最大行数时则返回
        if (curRow > numRows) {
            return;
        }

//        当前行
        List<Integer> curlist = new ArrayList<>();
//        从第一列开始遍历
        for (int i = 1; i <= curRow; i++) {
//            最左列和最右列值为1
            if (i == 1 || i == curRow) {
                curlist.add(1);
            }else{
                curlist.add(prelist.get(i - 2) + prelist.get(i - 1));
            }
        }
        res.add(curlist);
        helper(curRow + 1, numRows, res, curlist);
    }
}
