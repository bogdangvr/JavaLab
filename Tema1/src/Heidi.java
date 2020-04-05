public class Heidi extends CandyBox {

    private double height;

    public Heidi() {
    }

    public Heidi(String flavour, String origin, int height) {
        super(flavour, origin);
        this.height = height;
    }

    @Override
    double getVolume() {
        return height*height*height;
    }

    @Override
    public String toString() {
        return super.toString() + " has volume" + this.getVolume();
    }

    public void printHeidiDim(){
        System.out.println("Height:" + this.height);
    }
}
