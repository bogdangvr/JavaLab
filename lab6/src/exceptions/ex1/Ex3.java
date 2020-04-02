package exceptions.ex1;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Ex3 {

    public static void main(String[] args) {

        int a, b;
        try {
            createFile();
            Scanner scanner = new Scanner(new File("text.txt"));
            a = scanner.nextInt();
            b = scanner.nextInt();
            double result = a / b;
            System.out.println(result);
            scanner.close();
        } catch (IOException | ArithmeticException | NoSuchElementException e) {
            System.out.println(e);
            //e = new IOException();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("In finally");
        }

    }

    static void createFile() throws IOException{
        File file = new File("text.txt");
        if (file.createNewFile()){
            System.out.println("File created");
        }else{
            System.out.println("File already exists");
        }
        throw new IOException("IO exception while creating file");
    }
}
