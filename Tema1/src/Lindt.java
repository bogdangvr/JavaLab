public class Lindt extends CandyBox {

    private double height;
    private double width;
    private double length;

    public Lindt() {
    }

    public Lindt(String flavour, String origin, double height, double width, double length) {
        super(flavour, origin);
        this.height = height;
        this.width = width;
        this.length = length;
    }

    @Override
    double getVolume() {
        return height*length*width;
    }

    @Override
    public String toString() {
        return super.toString() + " has volume" + this.getVolume();
    }

    public void printLindtDim(){
        System.out.println("Width:" + this.width + " height:" + this.height + " length:" + this.length);
    }
}
