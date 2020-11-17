package collenction.map;

import java.util.LinkedHashMap;

/**
 * LinkedHashMap 保存的元素是有序的.(存放顺序).
 * 是HashMap的子类,方法都是一样的.
 * key和value的保存都是通过链表来保存的,保证的保存的顺序
 */
public class LinkedHashMapDemo {
    public static void main(String[] args) {
        LinkedHashMap<Object, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("b", "123");
        linkedHashMap.put("c", "123");
        linkedHashMap.put("a", "123");
        linkedHashMap.put("a", "456");
        linkedHashMap.put(null, null);
        System.out.println(linkedHashMap);
    }

}
