public class Milka  extends CandyBox{

    private double radius;
    private double height;

    public Milka() {
    }

    public Milka(String flavour, String origin, int radius, int height) {
        super(flavour, origin);
        this.radius = radius;
        this.height = height;
    }

    @Override
    double getVolume() {
        return 3.14*radius*radius*height;
    }

    @Override
    public String toString() {
        return super.toString() + " has volume" + this.getVolume();
    }

    public void printMilkaDim(){
        System.out.println("Radius:" + this.radius + " height:" + this.height);
    }
}
