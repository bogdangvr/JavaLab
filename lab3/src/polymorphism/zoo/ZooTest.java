package polymorphism.zoo;

import polymorphism.zoo.carnivor.Leu;
import polymorphism.zoo.carnivor.Pisica;
import polymorphism.zoo.ierbivor.Cal;
import polymorphism.zoo.ierbivor.Elefant;
import polymorphism.zoo.omnivor.Caine;
import polymorphism.zoo.omnivor.Urs;

import java.util.Scanner;

public class ZooTest {
    public static void main(String args[]) {

        int nrAnimaleZoo = Integer.parseInt(args[0]);
        System.out.println(nrAnimaleZoo);

        //Scanner scanner = new Scanner (System.in);
        //System.out.println("Precizati nr maxim de animale ce pot fi gazduite in zoo");
        //int nrAnimaleZoo = scanner.nextInt();
        //scanner.close();

        Pisica pisica1 = new Pisica("Tom", 3);
        Pisica pisica2 = new Pisica("Tom", 3);
        System.out.println(pisica1.equals(pisica2));

        Zoo zooBucuresti = new Zoo(nrAnimaleZoo);
        adaugaAnimaleLaZoo(zooBucuresti);

        for (int i = 0; i < zooBucuresti.animaleZoo.length && zooBucuresti.animaleZoo[i]!=null; i++){
            Animal animal = zooBucuresti.animaleZoo[i];
            animal.afiseazaDetalii();
            animal.seHraneste();
            animal.scoateSunet();
        }

    }

    public static void adaugaAnimaleLaZoo(Zoo zoo) {
        Leu leu = new Leu("Simba", 7);
        zoo.adaugaAnimal(leu);
        Elefant elefant = new Elefant("Eli", 10);
        zoo.adaugaAnimal(elefant);
        Urs urs = new Urs("Bijou", 20);
        zoo.adaugaAnimal(urs);
        Pisica pisica = new Pisica("Tom", 3);
        zoo.adaugaAnimal(pisica);
        Caine caine = new Caine("Skip", 10);
        zoo.adaugaAnimal(caine);
        Cal cal = new Cal("Thunder", 3);
        zoo.adaugaAnimal(cal);
    }

}
