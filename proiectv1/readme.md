# Documentatie proiect:
# Aplicatie Policlinica:

- Clase:

    - Pacient = clasa abstracta cu metodele si datele: nume, varsta, id, dataConsultatie, dataAnalize, tratat, informatiiSuficiente (generat random), cost tratament, tensiuneAnormala, durereMasea, inflamareGat, vedereNeclara, idMedic, apel(Receptionist), beneficiarReducere(), mergeConsultatie(Medic), faceAnalize(Receptionist), getters&setters, compareTo(Pacient);
    	Clase ce mostenesc Pacient si implementeaza metodele care sunt abstracte in Pacient (apel(Receptionist), beneficiarReducere()):
		- Copil;
		- Pensionar;
		- Adult;

    - Medic = clasa abstracta cu metodele si datele: nume, varta, Medic[], Laborator, nrMedici, setListaMedici(Medic[], int), verificaInformatiiSuficiente(Pacient), programeazaConsultatie(Pacient), programeazaAnalize(Pacient),getters&setters;
    	Clase ce mostenesc Medic si implementeaza metoda abstracta din Medic (consulta(Pacient)), dar au si un cost particular al tratamentului:
		- Pediatru;
		- Oftalmolog;
		- Cardiolog;
		- ORL;
		- Dentist;
	
    - Receptionist = clasa cu metodele si datele: nume, id, nrMaximPacientiZilnic, nrPacienti, ziDisponibila, nrPacientiUltimaZi, Vector<Integer> pacienti (aici se afla id-urile pacientilor), consulta(Pacient), getters&setters. Aceasta clasa simuleaza activitatea unul receptionist din viata reala: este apelat de pacienti, ii intreaba daca au anumite analize facute necesare consultatiei: daca le au, ii programeaza la consultatie, altfel, ii trimite la laborator sa faca analize pentru ca ulterior in urma altui apel sa ii programeze la medic;
	
    - Laborator = clasa cu metodele si datele: nrPacientiTratati, nrPacienti, nrMaximPacientiZilnic, costAnalize, Vector<Integer> pacienti, getters&setters;
	
- Interactiuni:

	Clasa Service are urmatoarele metode:
	
		-CrearePoliclinica(Medic[] listaMedici, int nrMedici, Laborator laborator) care returneaza un obiect de tipul Receptionist prin care initializam policlinica;
		
		-AfisarePoliclinica (Receptionist receptionist) care afiseaza date despre policlinica: medicii, tipul lor, capacitatea zilnica a laboratorului etc.;
		
		-Programeaza(List<Pacient> listaPacienti, int nrPacienti, Receptionist receptionist) care programeaza o lista de pacienti in functie de informatiiSuficiente;
		
		-TrecereaTimpului(List<Pacient> listaPacienti, int nrPacienti, Receptionist receptionist, int ziCurenta): am decis sa implementez o metoda care sa arate ordinea in care fiecare pacient ar merge la laborator/consultatii si ar fi tratat;
		
		-AfisareCostTratament (Pacient pacient) afiseaza costul tratamentului care a fost prescris unui pacient.
	
