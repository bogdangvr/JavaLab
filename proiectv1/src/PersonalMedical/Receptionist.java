package PersonalMedical;

import Pacienti.Copil;
import Pacienti.Pacient;

public class Receptionist {
    private String nume;
    private int varsta;

    public boolean verificaInformatiiSuficiente(Pacient pacient){
        // copiii trebuie consultati mereu, indiferent de cate informatii se detin
        if (pacient instanceof Copil){
            return true;
        }
        // altfel, trebuie sa faca analize la laborator
        return pacient.isInformatiiSuficiente();
    }

    public int programeazaConsultatie(Pacient pacient){

    };

    public int programeazaAnalize(Pacient pacient){


    };

    public Receptionist(String nume, int varsta) {
        this.nume = nume;
        this.varsta = varsta;
    }

    @Override
    public String toString() {
        return "Receptionist{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                '}';
    }
}
