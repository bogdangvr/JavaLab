package Pachet;

import java.util.Arrays;

public class Main {
    public static void main (String[] args){
        System.out.println("Hello");

        byte[] bytes;
        bytes = new byte[5];
        bytes[0] = -128;
        bytes[4] = 127;
        for (byte i = 0; i< bytes.length; i++){
            System.out.println(bytes[i]);
        }

        short[] shortArray;
        shortArray = new short[4];
        boolean[] boolShort;
        boolShort = new boolean[4];

        int[] ints = new int[]{1,3,5,7};

        for (int i = 0; i < ints.length; i++){
            System.out.println(ints[i]);
        }

        int[] ints1 = new int[4];
        ints1[0]=1;
        ints1[1]=3;
        ints1[2]=5;
        ints1[3]=7;

        for (int i = 0; i < ints1.length; i++){
            System.out.println(ints1[i]);
        }

        int[] ints2 = {1,3,5,7};
        for (int i = 0; i < ints2.length; i++){
            System.out.println(ints2[i]);
        }

        System.out.println(Arrays.toString(ints2));
    }
}
