package collenction.set;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<Object> set = new HashSet<>();
        set.add("3");
        set.add(2);
        set.add("5");
        set.add("66");
        set.add("a");
        set.add("f");
        set.add("A");
        set.add("gg");
        System.out.println(set);
        Object clone = set.clone();
        System.out.println(clone);

        HashSet<Object> hashSet = (HashSet<Object>) clone;
        hashSet.add("asdasdasd");
        System.out.println(set);
        System.out.println(clone);
        System.out.println(hashSet);


        for (Object o:set){
            System.out.print(o+",");
        }
        System.out.println();
        Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+",");
        }
        System.out.println();
        set.forEach(o-> System.out.print(o+","));

    }
}
