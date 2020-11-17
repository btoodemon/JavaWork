package collenction.list;

import java.util.LinkedList;

public class LinkedListDemo {
    public static void main(String[] args) {
        LinkedList<Object> list = new LinkedList<>();
        list.add("a");
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        list.addFirst("A");
        list.addLast("Z");
        System.out.println(list);
        System.out.println(list.pop());
        System.out.println(list);
        System.out.println(list.poll());
        System.out.println(list);

        list.push(456);
        System.out.println(list);
        System.out.println(list.pollLast());
        System.out.println(list);
        System.out.println(list.element());
        System.out.println(list);
        System.out.println("peek"+list.peek());
        System.out.println(list);

    }
}
