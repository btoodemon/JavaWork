package collenction;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;

public class CollenctionDemo {
    public static void main(String[] args) {
        Collection collection = new ArrayList();
        collection.add(100);
        collection.add(null);
        collection.add("hello");
        collection.add("hello");
        collection.add(1.0);
        collection.add(1.0);
        collection.add(1);
        collection.add("张三");
        collection.add(false);
        collection.add(2.5);
        collection.add('c');
        collection.add(new Object());
        System.out.println(collection);
        collection.remove("hello");
        System.out.println(collection);
//        collection.clear();
//        System.out.println(collection);
        System.out.println(collection.isEmpty());
        System.out.println(collection.contains("hello"));
        Object[] objects = collection.toArray();
        System.out.println(Arrays.toString(objects));
        Object[] objects1 = new Object[collection.size()];
        collection.toArray(objects1);
        System.out.println(Arrays.toString(objects1));

        System.out.println("----------------------------");
        for (Object object : collection) {
            System.out.println(object);
        }
        System.out.println("----------------------------");

        /*
         * 遍历
         */
        //-1- Iterator<E> iterator() 获得集合对象的迭代器对象 (将集合的所有元素 都存储至迭代器对象 )
        System.out.println("-1- ====================");
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Object object = it.next();
            System.out.println("object: " + object);
        }

        //-2-增强for循环
        System.out.println("-2- =====================");
        for (Object object:collection){
            System.out.println(object + " ");
        }

        //-3- 创建SimpleConsumer类,接口Consumer,重写accept方法
        System.out.println("-3- =====================");
        collection.forEach(new SimpleConsumer());

        //-4- 匿名内部类
        System.out.println("-4- ======================");
        collection.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o + " ");
            }
        });

        //-5- lambda 表达式 写法1
        System.out.println("-5- lambda 表达式 写法1");
        collection.forEach((Object o)->{
            System.out.println(o);
        });

        //-6- lambda 表达式 写法2
        System.out.println("-5- lambda 表达式 写法2");
        collection.forEach(o->{
            System.out.println(o);
        });

        //-7- lambda 表达式 写法3
        System.out.println("-7- lambda 表达式 写法3");
        collection.forEach(System.out::println);
    }
}
