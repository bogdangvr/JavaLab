package Collections.list.arraylist;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Ex3 {

    public static void main(String[] args) {

        List<Integer> ints = Arrays.asList(2,3,66,5,50,6,7,18,0);
        System.out.println(ints);


        Object[] arrayOfInts = ints.toArray();
        //Collections.sort(ints);
        System.out.println(ints);
        System.out.println(Collections.binarySearch(ints, 66));
        System.out.println(Collections.binarySearch(ints, -1));
    }
}
