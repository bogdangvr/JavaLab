package Pacienti;

import PersonalMedical.Medic;
import PersonalMedical.Receptionist;

import java.io.IOException;

public abstract class Pacient implements Comparable<Pacient>{
    //date personale:
    private String nume;
    private int varsta;
    private int id;
    //-1 inseamna ca nu este programat
    protected int dataConsultatie = -1;
    protected int dataAnalize = -1;
    protected boolean tratat=false;
    protected boolean informatiiSuficiente;
    private static int contorPacienti = 0;
    protected double costTratament;


    //afectiune:
    protected boolean tensiuneAnormala; //1
    protected boolean inflamareGat;     //2
    protected boolean durereMasea;      //3
    protected boolean vedereNeclara;    //4

    //campuri utile:
    protected int idMedic;

    //serviciul de scriere:

    //constructor
    public Pacient(String nume, int varsta, int nrAfectiune) {
        //generam random pentru fiecare pacient daca medicul
        //are suficiente informatii pentru tratare de la inceput
        //am decis sa o generez random pentru ca nimeni nu stie
        //daca are suficiente informatii pana nu ii spune cineva avizat acest lucru
        double rand = Math.random() * 10;
        this.informatiiSuficiente= (int) rand % 2 == 0;
        this.nume = nume;
        this.varsta = varsta;
        this.id=++contorPacienti;
        switch (nrAfectiune){
            case 1:
                tensiuneAnormala = true;
                break;
            case 2:
                inflamareGat = true;
                break;
            case 3:
                durereMasea = true;
                break;
            case 4:
                vedereNeclara = true;
                break;
        }
    }

    //metode:

    //returneaza data programarii
    public abstract void apel(Receptionist receptionist);
    abstract public boolean beneficiarReducere();


    public void mergeConsultatie(Medic medic) throws IOException {
        medic.consulta(this);
    }

    public void faceAnalize(Receptionist receptionist) throws IOException {
        this.setInformatiiSuficiente(true);
        this.setDataAnalize(-1);
        if (this.beneficiarReducere()){
            costTratament+=(receptionist.getLaborator().getCostAnalize()/2);
        }
        else{
            costTratament+=receptionist.getLaborator().getCostAnalize();
        }
        this.apel(receptionist);
    }

    @Override
    public String toString() {
        return "Pacient{" +
                "nume='" + nume +
                "; varsta=" + varsta +
                "; id=" + id +
                "; tratat=" + tratat +
                "; data programare laborator=" + getDataAnalize() +
                "; data programare consultatie=" + getDataConsultatie() +
                '}';
    }





    //getters
    public String getNume() {
        return nume;
    }

    public int getVarsta() {
        return varsta;
    }

    public int getAfectiune() {

        if (tensiuneAnormala){
            return 1;
        }
        if (inflamareGat){
            return 2;
        }
        if (durereMasea){
            return 3;
        }
        return 4;
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

    public int getDataConsultatie() {
        return dataConsultatie;
    }

    public int getDataAnalize() {
        return dataAnalize;
    }

    public double getCostTratament() {
        return costTratament;
    }

    public boolean isTratat() { return tratat; }



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

    public void setIdMedic(int idMedic) {
        this.idMedic = idMedic;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public void resetAfectiune(){
        tensiuneAnormala = false; //1
        inflamareGat = false;     //2
        durereMasea = false;      //3
        vedereNeclara = false;    //4
    }

    public void setAfectiune(int nrAfectiune){
        switch (nrAfectiune){
            case 1:
                tensiuneAnormala = true;
                break;
            case 2:
                inflamareGat = true;
                break;
            case 3:
                durereMasea = true;
                break;
            case 4:
                vedereNeclara = true;
                break;
        }
    }

    //functie pentru sortare
    @Override
    public int compareTo(Pacient o) {
        if (this.getDataConsultatie()==o.getDataConsultatie()){
            return this.getDataAnalize()-o.getDataAnalize();
        }
        return this.getDataConsultatie()-o.getDataConsultatie();
    }
}
