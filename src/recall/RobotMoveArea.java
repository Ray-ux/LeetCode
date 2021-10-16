package recall;

/**
 * 机器人的运动范围
 * @author 张烈文
 * @date 2021/10/16 23:37
 */
public class RobotMoveArea {

    int rows,cols;
    boolean[][] used;
    public int movingCount(int m, int n, int k) {
        rows=m;
        cols=n;
        used=new boolean[m][n];
        return count(k,0,0);
    }

    private int count(int k,int startX,int startY){
        // 做着里的时候感觉好像统计二叉树中节点的数量啊，一样的递归结构
        //若当前格子不再区域内或者格子已经被使用过了或者格子下标和大于k则直接返回0
        if(!inArea(startX,startY)||used[startX][startY]||(cal(startX)+cal(startY))>k){
            return 0;
        }

        // 占用当前格子
        used[startX][startY]=true;
        // 统计当前格子的上方机器人能走的格子数量
        int upNums=count(k,startX-1,startY);
        // 统计右方机器人能走的格子数量
        int rightNums=count(k,startX,startY+1);
        // 统计下方机器人能走的格子数量
        int downNums=count(k,startX+1,startY);
        // 统计左方机器人能走的格子数量
        int leftNums=count(k,startX,startY-1);
        // 格子相加就行
        return 1+upNums+rightNums+downNums+leftNums;
    }
    private boolean inArea(int startX,int startY){
        return (startX>=0&&startX<rows)&&(startY>=0&&startY<cols);
    }

    /**
     *该函数用于计算下标的各个位置的和
     */
    private int cal(int num){
        int sum=0;
        while(num!=0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
}
