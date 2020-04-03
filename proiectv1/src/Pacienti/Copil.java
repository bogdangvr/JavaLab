package Pacienti;

public class Copil extends Pacient{

    final private boolean beneficiarReducere=true;

    public Copil(String nume, int varsta, int afectiune) {
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
        if (afectiune==4) {
            this.vedereNeclara = true;
        }
    }

    void consultatie(){}
    void apel(){}
    void vizitaMedic(){}
    void vizitaLaborator(){}

    @Override
    public String toString() {
        return "Copil{" +
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