package Collections.list.linkedlist;

import java.util.LinkedList;

public class Ex1 {

    public static void main(String[] args) {
        LinkedList<String> list1 = new LinkedList<>();
        list1.add("aa");
        list1.add("aa");
        list1.add("aa");
        list1.add("aa");
        list1.add("aa");

        list1.add("ac");
        list1.add(1, "bb");
        list1.addFirst("primul");
        list1.addLast("ultimul");
        System.out.println(list1);

        list1.remove("aa");
        list1.remove(1);
        System.out.println(list1.removeFirst());
        System.out.println(list1.removeLast());
        System.out.println(list1);
        list1.removeFirstOccurrence("aa");
        System.out.println(list1);
        System.out.println(list1.removeFirstOccurrence("ff"));
    }

}
