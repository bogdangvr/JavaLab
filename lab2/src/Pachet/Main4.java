package Pachet;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main4 {
    public static void main(String[] args){
        int[][] ints = new int[2][];
        ints[0] = new int[]{3,5,7};
        ints[1] = new int[]{1,4,6,8,9};

        System.out.println(Arrays.deepToString(ints));
        System.out.println(Arrays.hashCode(ints));
        System.out.println(Arrays.deepHashCode(ints));

        short[] w = new short[5];
        Arrays.fill(w,(short)7);
        System.out.println(Arrays.toString(w));

    }
}
