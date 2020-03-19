package asociere;

public class Main {

    public static void main(String[] args) {

        Profesor profesorPrincipalMate = new Profesor(1, "Popescu");
        Profesor profesorSecundarMate = new Profesor(2, "Ionescu");
        Profesor profesorInfo = new Profesor(3, "Anghel");
        Profesor profesorMateSiInfo = new Profesor(4, "Petrescu");
        Profesor profesorInfoSiMate = new Profesor(5, "Andrei");

        Departament departaemntInfo = new Departament("info");
        departaemntInfo.setProfesori(new Profesor[]{profesorInfo, profesorInfoSiMate, profesorMateSiInfo});

        Departament departaemntMate = new Departament("mate");
        departaemntMate.setProfesori(new Profesor[]{profesorInfoSiMate, profesorMateSiInfo, profesorPrincipalMate, profesorSecundarMate});

        Universitate unibuc = new Universitate("UNIBUC", new Departament[]{departaemntInfo, departaemntMate});

        System.out.println(unibuc);

        departaemntInfo = null;

        System.out.println(departaemntMate);

        departaemntInfo = null;

        System.out.println(unibuc);

        //profesorSecundarMate = null;
        departaemntMate.getProfesori()[3]=null;
        System.out.println(departaemntMate);
        System.out.println(profesorSecundarMate);
    }

}
