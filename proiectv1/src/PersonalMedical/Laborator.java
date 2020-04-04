package PersonalMedical;

import java.util.Vector;

public class Laborator {
    private int nrPacienti = 0;
    private int nrPacientiTratati = 0;
    private int nrMaximPacientiZilnic;
    private double costAnalize = 30;
    private Vector<Integer> pacienti = new Vector<>();

    public Vector<Integer> getPacienti() {
        return pacienti;
    }

    public int getNrPacienti() {
        return nrPacienti;
    }

    public void setNrPacienti(int nrPacienti) {
        this.nrPacienti = nrPacienti;
    }

    public int getNrPacientiTratati() {
        return nrPacientiTratati;
    }

    public void setNrPacientiTratati(int nrPacientiTratati) {
        this.nrPacientiTratati = nrPacientiTratati;
    }

    public int getNrMaximPacientiZilnic() {
        return nrMaximPacientiZilnic;
    }

    public void setNrMaximPacientiZilnic(int nrMaximPacientiZilnic) {
        this.nrMaximPacientiZilnic = nrMaximPacientiZilnic;
    }

    public double getCostAnalize() {
        return costAnalize;
    }

    @Override
    public String toString() {
        return "Laborator{" +
                "nrPacienti=" + nrPacienti +
                ", nrPacientiTratati=" + nrPacientiTratati +
                ", nrMaximPacientiZilnic=" + nrMaximPacientiZilnic +
                ", pacienti=" + pacienti +
                ", cost analize=" + this.getCostAnalize() +
                '}';
    }
}
