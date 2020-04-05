public class Main {

    public static void main(String[] args) {

        int n=5;
        CandyBox[] arrayOfBoxes = new CandyBox[n];

        arrayOfBoxes[0] = new Lindt("berries", "usa", 3, 2, 6);
        arrayOfBoxes[1] = new Milka("chocolate", "usa", 2,4);
        arrayOfBoxes[2] = new Lindt("chocolate", "usa", 3, 2, 6);
        arrayOfBoxes[3] = new Lindt("berries", "usa", 3, 2, 6);
        arrayOfBoxes[4] = new Heidi("berries", "usa", 3);

        for (int i=0; i<n-1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arrayOfBoxes[i].equals(arrayOfBoxes[j])) {
                    System.out.println(arrayOfBoxes[i]);
                }
            }
        }
    }
}
