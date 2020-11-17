package collenction.set;

import java.util.TreeSet;
/**
 * TreeSet不允许保存空元素.元素不重复.
 * TreeSet会自动按照值的大小去排序(调用元素类型的compareTo方法).则需要保证保存的元素是同类型的.
 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet<Object> treeSet = new TreeSet<>();
        treeSet.add("x");
        treeSet.add("x");
        treeSet.add("X");
        treeSet.add("y");
        treeSet.add("s");
        treeSet.add("d");
        treeSet.add("f");
        System.out.println(treeSet);

        treeSet.forEach(o-> System.out.print(o+","));





    }
}
