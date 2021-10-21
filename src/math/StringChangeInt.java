package math;

/**
 * 把字符串转换为整数
 *
 * @author 张烈文
 * @date 2021/10/21 14:35
 */
public class StringChangeInt {

    /**
     * 1.去除首尾字符
     * 2.判断符号位
     * 3.处理边界值
     * @param s
     * @return
     */
    public int myAtoi(String s) {
        // 去掉首尾空格
        char[] c=  s.trim().toCharArray();
        //   若为空字符串则直接返回0
        if(c.length==0){
            return 0;
        }
        //   结果res，边界border
        int res=0,border=Integer.MAX_VALUE/10;
        //   假设字符串第一位是+，我们定义index就从1开始并且符号位为1
        int index=1,sign=1;
        //   如果第一位为-，则说明为负数
        if(c[0]=='-'){
            sign=-1;
            // 若第一位不为+号，则我们定义的index就应重置
        }else if(c[0]!='+'){
            index=0;
        }
        for(int i=index;i<c.length;i++){
            // 如果遇到非数字直接结束循环
            if(c[i]<'0'||c[i]>'9') break;
            // 判断是否越界，若res>border 则直接根据sign返回具体值，若res==border，则还需要判断当前遍历到的字符数字是否大于7，若小于7是不越界的
            if(res>border||(res==border&&c[i]>'7')){
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;
            }
            res=res*10+(c[i]-'0');
        }
        return sign*res;
    }
}
