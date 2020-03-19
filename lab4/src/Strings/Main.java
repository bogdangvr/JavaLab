package Strings;

public class Main {

    static String membruClasa;

    public static void main(String[] args) {

        //System.out.println(membruClasa);

        String s1 = "";  //sirul vid
        String s2 = " "; //blank -- isBlank()
        String s3 = "abc"; //string pool
        s3.toUpperCase();
        System.out.println(s3);
        //s3 = s3.toUpperCase();
        //System.out.println(s3);
        String s4 = new String("abc"); //heap
        String s5 = "abc";
        System.out.println(s3==s4); //false
        System.out.println(s3==s5); //true
        System.out.println(s4==s5); //false
        System.out.println(s3.equals(s4)); //true
        s4 = s4.intern();
        System.out.println(s3==s4); //true

        String s6 = "a \nb";
        System.out.println(s6);

        String s7 = "a \t b";
        System.out.println(s7);

        String s8 = "a \\bb";
        System.out.println(s8);

        String adresa = s3 + s2 + s3.toUpperCase() + s4.length();
        StringBuilder sb = new StringBuilder(adresa);
        sb.append(s3);
        System.out.println(adresa);
        System.out.println(sb);

        StringBuffer sbf1 = new StringBuffer(adresa);
        StringBuffer sbf2 = new StringBuffer(sb);
        StringBuilder sb1 = new StringBuilder(sbf2);
    }

}
