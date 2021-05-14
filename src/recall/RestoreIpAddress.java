package recall;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author 张烈文
 */
public class RestoreIpAddress {
    public List<String> restoreIpAddresses(String s) {
        List<String> res=new ArrayList();
        int len=s.length();
        if(len<4 || len>12){
            return res;
        }
        // 双向队列，两端都可以进出，当只允许一端进出时，可当作栈来使用
        Deque<String> path=new ArrayDeque();
        dfs(s,len,0,4,path,res);
        return res;
    }
    private void dfs(String s,int len,int begin,int residue,Deque<String> path,List<String> res){
        // 当begin==len时则代表当前已经移动到字符串长度的后一位
        if(begin==len){
            // 并且将剩余多少段还没被分割的变量为0时才添加
            if(residue==0){
                res.add(String.join(".",path));
            }
            return;
        }
        // 如果当前剩余字符总数大于当前可供截取ip段的最大字符数，则返回
        if(residue*3<len-begin) return;
        // 由于ip段的限制，每段最多只有三位数，因此i最后向后移动三位
        for(int i=begin;i<begin+3;i++){
            if(i>=len){
                break;
            }
            if(judgeIpSegment(s,begin,i)){
                // 如果当前[begin,i]的IP段有效，则截取出来
                String currentIpSegment=s.substring(begin,i+1);
                path.addLast(currentIpSegment);
                dfs(s,len,i+1,residue-1,path,res);
                path.removeLast();
            }
        }
    }

    // 判断当前截取的IP段是否有效
    private boolean judgeIpSegment(String s,int left,int right){
        int len=right-left+1;
        // 防止011出现
        if(len>1&&s.charAt(left)=='0'){
            return false;
        }
        int res=0;
        // 计算当前ip段的大小
        while(left<=right){
            res=res*10+s.charAt(left)-'0';
            left++;
        }
        return res>=0&&res<=255;

    }

    public static void main(String[] args) {
        RestoreIpAddress res = new RestoreIpAddress();
        res.restoreIpAddresses("25525511135");
    }

}
