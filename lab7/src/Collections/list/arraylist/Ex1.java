package Collections.list.arraylist;

import java.util.ArrayList;
import java.util.List;

public class Ex1 {

    public static void main(String[] args) {

        //without generics
        List bulkList = new ArrayList();
        bulkList.add(1);
        bulkList.add("two");
        bulkList.add(3.0);
        System.out.println(bulkList);

        List<String> list1 = new ArrayList<>();
        System.out.println(list1.isEmpty());
        list1.add("one");
        list1.add("two");
        list1.add(0,"zero");
        list1.add(1,"1");
        System.out.println(list1);

        if (list1.contains("one")){
            list1.remove(0);
            list1.remove("one");
        }
        System.out.println(list1);

        List<Integer> ints = new ArrayList<>(bulkList);
        ints.add(1);
        System.out.println(ints);
        System.out.println(ints.get(1));

        List<String> list2 = new ArrayList<String>(bulkList);
        System.out.println(list2);
        list2.addAll(list2);
        System.out.println(list2);
        list2.addAll(1, list2);
        System.out.println(list2);
        list2.add("Last element");
        list2.removeAll(list1);
        System.out.println("After remove all:" + list2);
        list2.clear();
        System.out.println("After clear:" + list2);

    }

}
