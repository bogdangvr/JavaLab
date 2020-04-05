import java.util.Objects;

public class CandyBox {

    private String flavour;
    private String origin;

    public CandyBox() {
    }

    public CandyBox(String flavour, String origin) {
        this.flavour = flavour;
        this.origin = origin;
    }

    double getVolume(){
        return 0;
    }

    @Override
    public String toString() {
        return "CandyBox{" +
                "flavour='" + flavour + '\'' +
                ", origin='" + origin + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CandyBox candyBox = (CandyBox) o;
        return Objects.equals(flavour, candyBox.flavour) &&
                Objects.equals(origin, candyBox.origin) &&
                getVolume()==((CandyBox) o).getVolume();
    }

}
