package Services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Reader {

    private static String BASE_PATH;
    private static Reader single_instance = null;

    private Reader(){
        BASE_PATH = "./src/files/";
    }

    public static Reader getInstance(){
        if (single_instance == null)
            single_instance = new Reader();
        return single_instance;
    }

    public String[][] read(String fileName) {
        String line = "";
        String splitBy = ",";
        int size = 0;
        String[][] values =  new String[size][];
        try {
            BufferedReader br = new BufferedReader(new FileReader(BASE_PATH + fileName));
            while ((line = br.readLine()) != null)
            {
                String[] persoana = line.split(splitBy);
                size = size + 1;
                String[][] newvalues = new String[size][];
                System.arraycopy(values, 0, newvalues, 0, values.length);
                newvalues[size - 1] = persoana;
                values = newvalues;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return values;
    }
}