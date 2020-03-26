public class Cup implements BubbleBathable{

    double volume;
    String color;

    public int getLevelOfFragility(){
        return Washable.FRAGILE;
    }

    @Override
    public boolean needsWashing(){
        return false;
    }

    @Override
    public void wash(){
        needsWashing();
        System.out.println("Washing a cup");
    }

    @Override
    public void takeBubbleBath() {
        System.out.println("Does not need bubble bathing");
    }

    @Override
    public void scrub() {
        System.out.println("Soft scrub");
    }

    @Override
    public void soak() {

    }
}
