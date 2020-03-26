public class Dog extends Animal implements BubbleBathable{
    @Override
    public void wash(){
        System.out.println("Washing a dog");
    }

    @Override
    public boolean needsWashing() {
        return false;
    }

}
