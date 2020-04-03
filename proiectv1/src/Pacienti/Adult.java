package Pacienti;

import PersonalMedical.Receptionist;

public class Adult extends Pacient{

    final private boolean beneficiarReducere=false;

    public Adult(String nume, int varsta, int afectiune) {
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

    void consultatie(){}
    void vizitaMedic(){}
    void vizitaLaborator(){}


    int apel(Receptionist receptionist){
        boolean suficienteInformatii = receptionist.verificaInformatiiSuficiente(this);
        if (suficienteInformatii){
            this.setDataConsultatie(receptionist.programeazaConsultatie(this));
        }
        else{
            this.setDataAnalize(receptionist.programeazaAnalize(this));
        }
    }

    @Override
    public String toString() {
        return "Adult{" +
                "nume=" + getNume() +
                ", varsta=" + getVarsta() +
                ", varsta=" + getId() +
                ", beneficiarReducere=" + beneficiarReducere +
                ", tratat=" + tratat +
                ", informatiiSuficiente=" + informatiiSuficiente +
                ", tensiuneAnormala=" + tensiuneAnormala +
                ", inflamareGat=" + inflamareGat +
                ", durereMasea=" + durereMasea +
                ", vedereNeclara=" + vedereNeclara +
                '}';
    }
}
