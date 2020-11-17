package collenction.map;

import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        TreeMap<Object, Object> treeMap = new TreeMap<>();
        treeMap.put(1, "abc");
        treeMap.put(2, "abc");
        treeMap.put(2, "absdac");
        treeMap.put(4, 123);
        treeMap.put(5, "233");
        treeMap.put(6, "a23");
        System.out.println(treeMap);


    }
}
