package Pachet;
import java.util.Arrays;

public class Main3 {
    public static void main(String[] args){
        int[] v1 = {2,3,5,6,7};
        int[] v2 = v1.clone();

        for (int i : v2){
            System.out.println(i);
        }

        System.out.println(Arrays.toString(v2));

        int[] v3 = new int[5];
        System.arraycopy(v1, 0, v3, 0 , 3);
        System.out.println(Arrays.toString(v3));

    }
}
