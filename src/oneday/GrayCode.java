package oneday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 张烈文
 * 格雷编码
 * @date 2022/1/12 14:07
 */
public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> res=new ArrayList();
        for(int i=0;i<1<<n;i++){
            res.add(generateNum(i));
        }
        return res;
    }

    private int generateNum(int index){
        return index^(index>>1);
    }
}
