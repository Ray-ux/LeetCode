package math;

/**
 * 构建乘积数组
 * @author 张烈文
 * @date 2021/10/22 18:59
 */
public class ConstructArray {

    public int[] constructArr(int[] a) {
        int len=a.length;
        if(len==0){
            return new int[0];
        }
        int[] b=new int[len];
//        初始化b[0]的第一个值为1
        b[0]=1;
        int temp=1;
//        第一个for循环保存i之前的乘积
        for(int i=1;i<len;i++){
            b[i]=b[i-1]*a[i-1];
        }
//        第二个循环保存i之后的乘积，与i之前的乘积相乘
        for(int i=len-2;i>=0;i--){
            temp*=a[i+1];
            b[i]*=temp;
        }
        return b;
    }
}
