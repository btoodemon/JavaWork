package collenction.map;

import java.util.*;

/**
 * 泛型标志符:
 *      E : 元素
 *      T : 类
 *      K : key
 *      V : value
 *      ? super Class 边界占位,表示传入的类必须是指定类的子类
 *      ? extends Class 边界占位
 *
 *      HashMap是Map的子类. Map接口的数据存储都是Key-Value键值对的保存形式.
 *      Key都是不允许重复的,如果重复了则覆盖.
 *      map保存的值是按照key的hash值摆放的,不是按照存放顺序摆放的
 *
 *      HashMap是一个Node数组,默认长度为16. 每一个数组坐标上都存放的是一个单向链表
 *      当链表长度为8时,将链表转换为红黑树[1.8].
 */
public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(null, null);
        hashMap.put(1, "张三");
        hashMap.put(2, "李四");
        hashMap.put(2, "李四1");
        hashMap.put(3, "李四3");
        hashMap.put("a", "李四a");
        hashMap.put("b", "李四b");
        System.out.println(hashMap);

        hashMap.remove(null);
        System.out.println(hashMap);
        System.out.println(hashMap.getOrDefault(1, "王五"));
        System.out.println(hashMap.getOrDefault(9, "王五"));
        System.out.println(hashMap.containsKey(2));//key是否存在 :
        System.out.println(hashMap.containsValue("张三"));//value是否存在 :
        System.out.println(hashMap.size());
        System.out.println("--------------------------------------------");

        Set<Object> keySet = hashMap.keySet();
        System.out.println(keySet);
        for (Object k:keySet){
            System.out.println(k+":"+hashMap.get(k));
        }
        System.out.println("---------------------------------------------");
        Set<Map.Entry<Object, Object>> entries = hashMap.entrySet();
        Iterator<Map.Entry<Object, Object>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Object, Object> next = iterator.next();
            System.out.print(next.getKey() + ":" + next.getValue()+",");
        }
        System.out.println();
        System.out.println("---------------------------------------------");

        hashMap.forEach((k,v)-> System.out.print(k+"="+v+","));

    }
}
