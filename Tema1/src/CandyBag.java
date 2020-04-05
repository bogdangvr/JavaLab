public class CandyBag {

    private CandyBox[] arrayOfBoxes;
    private int noBoxes;

    public CandyBag(CandyBox[] arrayOfBoxes, int noBoxes) {

        this.arrayOfBoxes = arrayOfBoxes;
        this.noBoxes = noBoxes;

    }

    public CandyBox[] getArrayOfBoxes() {
        return arrayOfBoxes;
    }

    public int getNoBoxes() {
        return noBoxes;
    }
}
