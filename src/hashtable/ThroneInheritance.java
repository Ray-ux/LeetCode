package hashtable;

import dynamic.LastStoneWeightⅡ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 皇位继承顺序
 * 自己的思路：超时，定义一个内部内Person并重写equals和hashcode方法，外部成员变量：kingName存储国王名字
 * hashMap   key：Person value：List<Person>
 *
 * @author 张烈文
 */
public class ThroneInheritance {

    class Person{
        String Name;
        boolean isDeath;
        Person(String Name) {
            this.Name = Name;
            isDeath = false;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Person p = (Person) obj;
            if (Name.equals(p.Name)) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Name.hashCode();
        }
    }
    HashMap<Person, List<Person>> order = new HashMap<>();
    String kingName;
    public ThroneInheritance(String kingName) {
        this.kingName = kingName;
        order.put(new Person(kingName), new ArrayList<>());
    }

    public void birth(String parentName, String childName) {
        List<Person> value = order.get(new Person(parentName));
        value.add(new Person(childName));
        order.put(new Person(childName), new ArrayList<>());
    }

    public void death(String name) {
        Person person = new Person(name);
        List<Person> list = order.get(person);
        order.remove(person);
        person.isDeath = true;
        order.put(person, list);
    }

    public List<String> getInheritanceOrder() {
        List<String> res = new ArrayList<>();
        dfs(res, kingName);
        return res;
    }

    private void dfs(List<String> res, String name) {
        for (Person p : order.keySet()) {
            if (p.Name.equals(name)) {
                if (!p.isDeath) {
                    res.add(name);
                }
                List<Person> people = order.get(p);
                for (Person p1:people) {
                    dfs(res, p1.Name);
                }
            }
        }
    }
}
