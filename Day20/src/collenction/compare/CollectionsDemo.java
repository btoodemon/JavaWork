package collenction.compare;

import work.SE;

import java.util.ArrayList;
import java.util.Collections;

public class CollectionsDemo {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(3);list.add(1);list.add(2);list.add(3);
        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

        /**
         * Collections.sort进行排序
         * 排序的类型必须得实现Comparable接口
         */
        ArrayList<SE> arrayList = new ArrayList<>();
        arrayList.add(new SE(1, "123"));
        arrayList.add(new SE(3, "123"));
        arrayList.add(new SE(2, "123"));
        Collections.sort(arrayList);
        System.out.println(arrayList);

        Collections.shuffle(list); //洗牌
        System.out.println(list);
        Comparable max = Collections.max(list); //取最大
        System.out.println(max);
        Comparable min = Collections.min(list); //取最小
        System.out.println(min);
    }
}
