package imutabilitate;

public final class Persoana {

    private final int id;
    private final String nume;
    private final Adresa adresa;

    public Persoana(int id, String nume, Adresa adresa) {
        this.id = id;
        this.nume = nume;
        //Adresa copieAdresa = new Adresa(adresa.getStrada(),adresa.getNr());
        //this.adresa = copieAdresa;
        this.adresa = new Adresa(adresa);
    }


    public int getId() {
        return id;
    }

    public Adresa getAdresa() {
        //String numeStrada = this.adresa.getStrada();
        //String nrStrada = this.adresa.getNr();
        //Adresa copieAdresa = new Adresa (numeStrada, nrStrada);
        //return copieAdresa;
        return new Adresa(adresa);
    }

    public String getNume() {
        return nume;
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", adresa=" + adresa +
                '}';
    }
}
