package string;

/**
 * 替换空格
 *
 * @author 张烈文
 * @date 2021/10/2 14:20
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuilder str=new StringBuilder();

        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(c==' '){
                str.append("%20");
            }else{str.append(c);}
        }

        return str.toString();
    }
}
