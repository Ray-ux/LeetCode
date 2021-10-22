package math;

/**
 * 表示数值的字符串
 *
 * @author 张烈文
 * @date 2021/10/22 17:18
 */
public class ExpressionNumString {
    public boolean isNumber(String s) {
//        特判
        if (s == null || s.length() == 0) {
            return false;
        }
//        isNum:当前位置的字符是否是数字，isDot：当前位置的字符是否是小数点，iseOrE：当前位置的字符是否是e或E
        boolean isNum = false, isDot = false, iseOrE = false;
//        去除首尾字符串
        char[] str = s.trim().toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] >= '0' && str[i] <= '9') {   //当前字符是否为0~9的数位
                isNum = true;
            } else if (str[i] == '.') {
                if (isDot || iseOrE) { //小数点之前可以没有整数，但是不能重复出现小数点或者出现e,E
                    return false;
                }
                isDot = true; //标记已经遇到小数点
            } else if (str[i] == 'e' || str[i] == 'E') {
                if (!isNum || iseOrE) {
                    return false;
                }
                iseOrE = true;  //表及已经遇到e,E
                isNum = false; //重置isNum，因为e,E之后也必须接上整数，防止出现123e或者123e+的非法情况
            } else if (str[i] == '-' || str[i] == '+') {
                if(i!=0&&str[i-1]!='e'&&str[i-1]!='E') {  // 正负号只可能出现在第一个位置，或者出现在‘e’或'E'的后面一个位置
                    return false;
                }
            }else { //其它情况直接返回false
                return false;
            }
        }
        return isNum;
    }
}
