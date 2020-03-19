package imutabilitate;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Adresa domiciliu =  new Adresa("Cuza", "14A");
        Persoana persoana = new Persoana(1, "Teo", domiciliu);
        String numePersoana = persoana.getNume().toUpperCase();
        System.out.println(persoana);
        System.out.println(numePersoana);
        String stradaUppercase = domiciliu.getStrada().toUpperCase();

        domiciliu.setStrada(stradaUppercase);
        System.out.println(persoana);

        Adresa adresaDomiciliu = persoana.getAdresa();
        String adresaDomiciliuUpper = adresaDomiciliu.getStrada().toUpperCase();
        adresaDomiciliu.setStrada(adresaDomiciliuUpper);
        System.out.println(persoana);
    }
}
