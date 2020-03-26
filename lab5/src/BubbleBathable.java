public interface BubbleBathable extends Soakable, Scrubbable {

    void takeBubbleBath();

    default void wash() {
        //Soakable.super.wash();
        System.out.println("Default wash in bubble bathing");
    }

}
