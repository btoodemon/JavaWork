package collenction.list;

import java.util.Vector;

public class VectorDemo {
    public static void main(String[] args) {
        Vector<Object> vector = new Vector<>();
        vector.add("a");
        vector.add("A");
        vector.add("a");
        vector.add("b");
        vector.add("c");
        vector.add("d");
        vector.add("e");
        System.out.println(vector);

        vector.insertElementAt("X", 0);
        System.out.println(vector);
        vector.set(3, "B");
        System.out.println(vector);
        System.out.println(vector.capacity());
    }
}
