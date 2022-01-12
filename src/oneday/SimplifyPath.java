package oneday;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 简化路劲
 * @author 张烈文
 * @date 2022/1/6 21:34
 */
public class SimplifyPath {

    public static String simplifyPath(String path) {
        String[] paths=path.split("/");
        Deque<String> deque = new LinkedList<>();
        for (int i = 0; i < paths.length; i++) {
            if (paths[i].equals(".")||paths[i].equals("")) {
                continue;
            } else if (paths[i].equals("..")) {

                if (!deque.isEmpty()) {
                    deque.removeLast();
                }
            } else {
                deque.addLast(paths[i]);
            }
        }
        StringBuilder res = new StringBuilder("/");
        while (!deque.isEmpty()) {
            res.append(deque.removeFirst());
            if (!deque.isEmpty()) {
                res.append("/");
            }
        }
        return  res.toString();
    }

    public static void main(String[] args) {
        simplifyPath("/home/");
    }
}
