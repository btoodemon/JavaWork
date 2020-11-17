package collenction.set;

import java.util.LinkedHashSet;

/**
 * LinkedHashSet 有序的,按照保存的顺序
 * LinkedHashSet 保留hash特点,不允许元素重复
 * LinkedHashSet实际上就是LinkedHashMap.该类完全是为了符合Collection的规范保存单值的集合
 *与Collection接口下的方法一致
 */
public class LinkedHashSetDemo {
    public static void main(String[] args) {
        LinkedHashSet<Object> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("a");
        linkedHashSet.add(3);
        linkedHashSet.add("a");
        linkedHashSet.add("A");
        System.out.println(linkedHashSet);

    }
}
