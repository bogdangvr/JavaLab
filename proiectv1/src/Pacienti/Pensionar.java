package Pacienti;

import PersonalMedical.Receptionist;

public class Pensionar extends Pacient{

    final private boolean beneficiarReducere=true;

    public Pensionar(String nume, int varsta, int afectiune) {
        super(nume, varsta);

        if (afectiune==1){
            this.tensiuneAnormala=true;
        }
        if (afectiune==2){
            this.inflamareGat=true;
        }
        if (afectiune==3){
            this.durereMasea=true;
        }
        if (afectiune==4){
            this.vedereNeclara=true;
        }
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
        return "Pensionar{" +
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
