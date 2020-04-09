package Collections.list.linkedlist;

import java.util.LinkedList;

public class Ex2 {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("a");
        list.offer("c");
        list.offerFirst("rr");
        System.out.println(list.element()); //NoSuchElementException if list is empty
        //new LinkedList<>().element();

        System.out.println(list.peek());
        System.out.println(list.poll());
        System.out.println(list);

        list.pop();
        System.out.println(list);
    }

}
