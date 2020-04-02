package exceptions.ex3;

import java.util.Arrays;

public class Ex3 {

    public static void main(String[] args) {

        try(R2 r1 = new R2("r1");
            R2 r2 = new R2("r2")){
            throw new Exception("Exception in try block");
            //System.out.println("In try block");
            //aici se apeleaza implicit close (indiferent de throw)
        }
        catch (Exception e){
            System.out.println(e);
            //suppressed exceptions
            Throwable[] suppressedExceptions = e.getSuppressed();
            System.out.println(Arrays.toString(suppressedExceptions));
        }
        finally{
            System.out.println("In finally");
        }

    }

}
