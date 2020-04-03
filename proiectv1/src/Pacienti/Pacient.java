package Pacienti;

import PersonalMedical.Receptionist;

import java.lang.Math;

public abstract class Pacient {
    //date personale:
    private String nume;
    private int varsta;
    private int id;
    private int dataConsultatie;
    private int dataAnalize;
    protected boolean tratat=false;
    protected boolean informatiiSuficiente;
    private static int contorPacienti = 0;
    private double costTratament;


    //afectiune:
    protected boolean tensiuneAnormala; //1
    protected boolean inflamareGat;     //2
    protected boolean durereMasea;      //3
    protected boolean vedereNeclara;    //4

    //campuri utile:
    protected int idMedic;

    //metode:
    abstract void consultatie();

    //returneaza data programarii
    abstract int apel(Receptionist receptionist);


    abstract void vizitaMedic();
    abstract void vizitaLaborator();

    @Override
    public String toString() {
        return "Pacient{" +
                "nume='" + nume + '\'' +
                ", varsta=" + varsta +
                ", id=" + id +
                ", tratat=" + tratat +
                '}';
    }



    //constructor
    public Pacient(String nume, int varsta) {
        //generam random pentru fiecare pacient daca medicul
        //are suficiente informatii pentru tratare de la inceput
        double rand = Math.random() * 10;
        if ((int)rand%2==0){
            this.informatiiSuficiente=true;
        }
        else{
            this.informatiiSuficiente=false;
        }
        this.nume = nume;
        this.varsta = varsta;
        this.id=++contorPacienti;
    }

    //getters
    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public boolean isInformatiiSuficiente() {
        return informatiiSuficiente;
    }

    public int getId() {
        return id;
    }

    public boolean isTensiuneAnormala() {
        return tensiuneAnormala;
    }

    public boolean isInflamareGat() {
        return inflamareGat;
    }

    public boolean isDurereMasea() {
        return durereMasea;
    }

    public boolean isVedereNeclara() {
        return vedereNeclara;
    }

    public int getIdMedic() {
        return idMedic;
    }


    //setters
    public void setTratat(boolean tratat) {
        this.tratat = tratat;
    }

    public void setInformatiiSuficiente(boolean informatiiSuficiente) {
        this.informatiiSuficiente = informatiiSuficiente;
    }

    public void setTensiuneAnormala(boolean tensiuneAnormala) {
        this.tensiuneAnormala = tensiuneAnormala;
    }

    public void setInflamareGat(boolean inflamareGat) {
        this.inflamareGat = inflamareGat;
    }

    public void setDurereMasea(boolean durereMasea) {
        this.durereMasea = durereMasea;
    }

    public void setVedereNeclara(boolean vedereNeclara) {
        this.vedereNeclara = vedereNeclara;
    }

    public void setCostTratament(double costTratament) {
        this.costTratament = costTratament;
    }

    public void setDataConsultatie(int dataConsultatie) {
        this.dataConsultatie = dataConsultatie;
    }

    public void setDataAnalize(int dataAnalize) {
        this.dataAnalize = dataAnalize;
    }
}
