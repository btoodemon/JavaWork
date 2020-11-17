package collenction.compare;

import work.Employee;
import work.SE;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class CompareDemo {
    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        set.add(new SE(1,"李四1"));
        set.add(new SE(3,"李四2"));
        set.add(new SE(2,"李四3"));
        System.out.println(set);

        //HashSet排序
        HashSet hashSet = new HashSet();
        hashSet.add(new SE(1,"李四1"));
        hashSet.add(new SE(3,"李四2"));
        hashSet.add(new SE(2,"李四3"));
        System.out.println(hashSet);
        TreeSet set1 = new TreeSet<>(hashSet); //HashSet转换为TreeSet排序
        System.out.println(set1);

        //HashMap排序
        HashMap<Employee,String> hashMap = new HashMap<>();
        hashMap.put(new SE(3, "asd"), "123");
        hashMap.put(new SE(1, "asd"), "123");
        hashMap.put(new SE(2, "asd"), "123");
        System.out.println(hashMap);
        TreeMap<Employee, String> employeeStringTreeMap = new TreeMap<>(hashMap); //HashMap转为TreeMap进行排序
        System.out.println(employeeStringTreeMap);
    }
}
