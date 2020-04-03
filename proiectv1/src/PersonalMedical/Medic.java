package PersonalMedical;

import java.util.Arrays;
import java.util.Vector;

public abstract class Medic {
    //date personale:
    private String nume;
    private int id;
    private int nrMaximPacientiZilnic;
    private static int contorMedici = 0;
    private Vector pacienti;

    //metode:
    abstract void consulta();
    abstract void trateaza();
    public void adaugaPacient (int id){
        pacienti.add(id);
    }

    @Override
    public String toString() {
        return "Medic{" +
                "nume='" + nume + '\'' +
                ", id=" + id +
                ", nrMaximPacientiZilnic=" + nrMaximPacientiZilnic +
                ", pacienti=" + pacienti +
                '}';
    }

    //constructor:
    public Medic(String nume, int nrMaximPacientiZilnic) {
        this.nume = nume;
        this.id = ++contorMedici;
        this.nrMaximPacientiZilnic = nrMaximPacientiZilnic;
    }

    public String getNume() {
        return nume;
    }

    public int getId() {
        return id;
    }

    public int getNrMaximPacientiZilnic() {
        return nrMaximPacientiZilnic;
    }

    public Vector getPacienti() {
        return pacienti;
    }
}
