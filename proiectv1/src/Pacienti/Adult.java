package Pacienti;

import PersonalMedical.Receptionist;

public class Adult extends Pacient{

    final private boolean beneficiarReducere=false;

    public Adult(String nume, int varsta, int afectiune) {
        super(nume, varsta, afectiune);
    }


    public void apel(Receptionist receptionist){
        boolean suficienteInformatii = receptionist.verificaInformatiiSuficiente(this);
        if (suficienteInformatii){
            this.setDataConsultatie(receptionist.programeazaConsultatie(this));
        }
        else {
            this.setDataAnalize(receptionist.programeazaAnalize(this));
        }
    }

    @Override
    public String toString() {
        return "Adult{" +
                "nume=" + getNume() +
                ", varsta=" + getVarsta() +
                ", id=" + getId() +
                ", data programare laborator=" + getDataAnalize() +
                ", data programare consultatie=" + getDataConsultatie() +
                ", beneficiarReducere=" + beneficiarReducere +
                ", tratat=" + tratat +
                ", informatiiSuficiente=" + informatiiSuficiente +
                ", tensiuneAnormala=" + tensiuneAnormala +
                ", inflamareGat=" + inflamareGat +
                ", durereMasea=" + durereMasea +
                ", vedereNeclara=" + vedereNeclara +
                '}';
    }

    @Override
    public boolean beneficiarReducere() {
        return true;
    }
}
