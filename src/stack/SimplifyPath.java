package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 简化路径
 *
 * @author 张烈文
 */
public class SimplifyPath {


    /**
     * 具体思路：用双端队列，split函数分割字符串，最后在拼接
     * @param path
     * @return
     */
    public static String simplifyPath(String path) {

//        双端队列
        Deque<String> deque = new LinkedList<>();
//        分割字符
        String[] res = path.split("/");
        for (String s : res) {
//            遇到""或"."直接跳过
            if (s.equals(".") || s.equals("")) {
                continue;
//                遇到".."则弹出队尾元素，注意判断队列是否为空
            } else if (s.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pollLast();
                }
            } else {
                deque.offer(s);
            }
        }
        StringBuilder builder = new StringBuilder("/");
        while (!deque.isEmpty()) {
            builder.append(deque.poll());
//            添加分隔符
            if (!deque.isEmpty()) {
                builder.append("/");
            }
        }

//        判空
        return builder.toString().equals("") ? "/" : builder.toString();
    }


}
