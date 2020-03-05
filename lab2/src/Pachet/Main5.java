package Pachet;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main5 {

    public static void main(String[] args){

        int[] v = {2,5,6,7,-91,234,-612,1000};
        Arrays.sort(v);
        System.out.println(Arrays.toString(v));
        System.out.println(Arrays.binarySearch(v,-90));

    }

}
