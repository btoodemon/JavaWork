package collenction.list;

import java.util.ArrayList;

/**
 * ArrayList自动扩容机制
 * 1:创建一个全新的空List.
 * 2:添加元素时,判断当前的元素数组是否是空数组.
 *  2.1 是空数组,则进行扩容(长度基数固定的10).
 *  2.2 创建一个长度为10的全新数组
 *  2.3 完成添加元素.并有一个size成员变量负责记录下一次添加的默认索引.还有modCount来记录数组的修改次数
 *
 * 3.若数组元素以及加满,长度无法满足时.
 *  3.1 进行长度判断,若长度无法满足,则按照当前的容量扩容1.5倍的长度.
 *  3.2 将原有的数组元素拷贝到原有数组长度的1.5倍的新数组中
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        //ArrayList<Object> objects = new ArrayList<>(16);//创建一个长度为16的ArrayList
        objects.add("a");
        objects.add("b");
        objects.add("a");
        System.out.println(objects);
        objects.add(1,10);
        System.out.println(objects);

        ArrayList<Object> list = new ArrayList<>();
        list.add("q");
        list.add("e");
        objects.addAll(list);
        System.out.println(objects);

        objects.addAll(1,list);
        System.out.println(objects);

        objects.set(0, "A");
        System.out.println(objects);

        System.out.println(objects.get(2));
        System.out.println(objects.indexOf(10));
        System.out.println(objects.lastIndexOf("q"));

        for (Object o:objects){
            System.out.print(o+" , ");
        }
        System.out.println();
        objects.forEach(o->{
            System.out.print(o+" , ");
        });
        System.out.println();
        System.out.println(10>>1);
        System.out.println(97>>1);
        System.out.println(97<<1);





    }
}
