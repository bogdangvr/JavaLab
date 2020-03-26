import java.util.Arrays;

public class MovieTest {

    public static void main(String[] args) {

        Movie movies[] = {new Movie("Whiplash", 2014, 8.5),
                        new Movie("Good Will Hunting", 1999, 8.4),
                        new Movie("Breaveheart", 1990, 8.9),
                        new Movie("1917", 2019, 8.7)};

        System.out.println(Arrays.toString(movies));
        Arrays.sort(movies);
        System.out.println(Arrays.toString(movies));

        Arrays.sort(movies,new MovieRatingComparator());
        System.out.println(Arrays.toString(movies));
    }

}
