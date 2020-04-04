package PersonalMedical;

import Pacienti.Pacient;

import java.util.Vector;

public abstract class Medic {
    //date personale:
    private String nume;
    private int id;
    protected int nrMaximPacientiZilnic;
    protected int nrPacienti=0;
    private static int contorMedici = 0;
    private int ziDisponibila = 0;
    private int nrPacientiUltimaZi = 0;
    private Vector<Integer> pacienti = new Vector<>();

    //metode:
    public abstract void consulta(Pacient pacient);
    public void adaugaPacient (int id){
        this.pacienti.add(id);
        nrPacienti++;
    }

    @Override
    public String toString() {
        return "Medic{" +
                "nume='" + nume +
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

    public Vector<Integer> getPacienti() {
        return pacienti;
    }

    public int getNrPacienti() {
        return nrPacienti;
    }

    public int getZiDisponibila() {
        return ziDisponibila;
    }

    public void setZiDisponibila(int ziDisponibila) {
        this.ziDisponibila = ziDisponibila;
    }

    public int getNrPacientiUltimaZi() {
        return nrPacientiUltimaZi;
    }

    public void setNrPacientiUltimaZi(int nrPacientiUltimaZi) {
        this.nrPacientiUltimaZi = nrPacientiUltimaZi;
    }
}
