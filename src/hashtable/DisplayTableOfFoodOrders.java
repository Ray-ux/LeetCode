package hashtable;

import java.util.*;
import java.util.stream.Stream;

/**
 * 点菜展示表
 *
 * @author 张烈文
 */
public class DisplayTableOfFoodOrders {

    /**
     * 自己的思路写一个类来实现
     */
    private class Table{
        Integer tableId;
        HashMap<String, Integer> orders = new HashMap<>();
        public Table(Integer tableId) { this.tableId = tableId; }
        @Override
        public int hashCode() {
            return super.hashCode()+tableId.hashCode();
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Table table = (Table) obj;
            return tableId.equals(table.tableId);
        }
    }
    public List<List<String>> displayTable(List<List<String>> orders) {

        List<Table> ans = new ArrayList<>();
        List<String> foodNames = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        for (List<String> inner:orders) {
            Integer tableId = Integer.parseInt(inner.get(1));
            String curFood = inner.get(2);
            if (!foodNames.contains(curFood)) {
                foodNames.add(curFood);
            }
            Table table = new Table(tableId);
//            如果集合中包含当前餐桌
            int curPos = ans.indexOf(table);
            if (curPos!=-1) {
//                取出集合中的当前餐桌，然后再拿出当前桌的菜单进行判断即可
                Table curTable = ans.get(curPos);
                HashMap<String, Integer> curOrders = curTable.orders;
                curOrders.put(curFood, curOrders.getOrDefault(curFood, 0) + 1);
            }else{
//                如果不含有当前Table
                ans.add(table);
                table.orders.put(curFood, 1);
            }
        }
        //            排序
        Collections.sort(ans,(o1,o2)-> o1.tableId-o2.tableId);
        Collections.sort(foodNames);
        List<String> f = new ArrayList<>();
        f.add("Table");
        f.addAll(foodNames);
        res.add(f);
        for (int i = 0; i < ans.size(); i++) {
            List<String> in = new ArrayList<>();
            Table table1 = ans.get(i);
            HashMap<String, Integer> orders1 = table1.orders;
            in.add(String.valueOf(table1.tableId));
            for (int j = 0; j < foodNames.size(); j++) {
                Integer num = orders1.getOrDefault(foodNames.get(j), 0);
                in.add(String.valueOf(num));
            }
            res.add(in);
        }
        return res;
    }

    /**
     * 参考题解：题解中的Map的value实际和自己的思路中的重新抽象的类相同
     * @param os
     * @return
     */
    public List<List<String>> displayTable1(List<List<String>> os) {
        List<List<String>> ans = new ArrayList<>();
        // 桌号 : {餐品 : 个数}（用于构造内容）
        Map<Integer, Map<String, Integer>> tm = new HashMap<>();
        // 餐品（用于构造 title）
        Set<String> ts = new HashSet<>();
        for (List<String> o : os) {
            String c = o.get(0), t = o.get(1), f = o.get(2);
            Integer tidx = Integer.parseInt(t);
            ts.add(f);
            Map<String, Integer> map = tm.getOrDefault(tidx, new HashMap<>());
            map.put(f, map.getOrDefault(f, 0) + 1);
            tm.put(tidx, map);
        }
        int n = tm.size() + 1, m = ts.size() + 1;
        // 构造 title & 手动排序
        List<String> foods = new ArrayList<>(ts);
        Collections.sort(foods);
        List<String> title = new ArrayList<>();
        title.add("Table");
        title.addAll(foods);
        ans.add(title);
        // 构造内容 & 手动排序
        List<Integer> tables = new ArrayList<>(tm.keySet());
        Collections.sort(tables);
        for (int tidx : tables) {
            Map<String, Integer> map = tm.get(tidx);
            List<String> cur = new ArrayList<>();
            cur.add(tidx + "");
            for (String food : foods) {
                cur.add(map.getOrDefault(food, 0) + "");
            }
            ans.add(cur);
        }
        return ans;
    }



}
