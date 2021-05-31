package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 路径总和Ⅱ
 * @author 张烈文
 */
public class PathSumⅡ {
    /**
     * 具体思路就是回溯算法
     * @param root
     * @param targetSum
     * @return
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList();
//      用双端队列
        Deque<Integer> path = new LinkedList();
        dfs(root,targetSum,res,path);
        return res;
    }
//    递归三步骤：
//    1.找递归终止条件
//    2.当前递归到的层级需要做什么
//    3.找递归的返回值

    private void dfs(TreeNode node,int targetSum,List<List<Integer>> res,Deque<Integer> path){
        if(node==null){
            return;
        }
//        这里由于我们只开辟了一个双端队列，以此当我们向队列尾部加入元素时，还需要再进行回溯（即删除操作）
        if(node.left==null&&node.right==null&&targetSum==node.val){
            path.addLast(node.val);
            res.add(new ArrayList(path));
            path.removeLast();
            return;
        }
//        向队列中添加元素
        path.addLast(node.val);
        dfs(node.left, targetSum - node.val, res, path);
        dfs(node.right, targetSum - node.val, res, path);
//        回溯
        path.removeLast();
    }
}
