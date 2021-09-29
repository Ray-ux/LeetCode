package string;

/**
 * 反转字符串Ⅱ
 * @author 张烈文
 * @date 2021/9/29 19:19
 */
public class ReverseStringⅡ {
    public String reverseStr(String s, int k) {
        char[] ch=s.toCharArray();
//        1，每隔2k个字符的前k个字符进行字符反转
        for(int i=0;i<ch.length;i+=2*k){
            if(i+k<=ch.length){
//                2.剩余字符小于2k但大于或等于k个，则反转前k个字符
                reverse(ch,i,i+k-1);
                continue;
            }
//            3.剩余字符少于k个，则将剩余字符全部反转
            reverse(ch,i,ch.length-1);
        }
        return new String(ch);
    }

//    定义翻转函数
    private void reverse(char[] s,int i,int j){
        while(i<=j){
            char c=s[i];
            s[i++]=s[j];
            s[j--]=c;
        }
    }
}
