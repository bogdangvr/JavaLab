package Pachet;

import java.sql.SQLOutput;

public class Main2 {
    public static void main (String[] args){

        char[] chars = {'j', 'a', 'v', 'a'};

        for (char c : chars){
            System.out.println(c);
        }

        System.out.println(chars);

        int[][] matrice = new int[3][3];
        matrice[0][0]=69;
        matrice[0][1]=420;

        for (int[] i : matrice){
            for (int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

        char[][] chmatr = {{'c','f'},{'p'}, {'j', 'a', 'v', 'a'}};
        System.out.println(chmatr);

        for (char[] i : chmatr){
            for (char j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }

        int[][] intmtr1 = new int[3][];

        intmtr1[0]=new int[2];
        intmtr1[0][0]=1;
        intmtr1[0][1]=2;

        intmtr1[1]=new int[]{3,4,5};

        intmtr1[2]=new int[]{3};

        afisare(intmtr1);

    }

    private static void afisare (int[][] matrice){
        for (int[] i : matrice){
            for (int j : i){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }



}
