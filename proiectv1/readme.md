# Documentatie proiect:
# Aplicatie programari policlinica

- Classes:

    - Pacient = clasa abstracta cu metodele si datele: nume, varsta, id, dataConsultatie, dataAnalize, tratat, informatiiSuficiente (generat random), cost tratament, tensiuneAnormala, durereMasea, inflamareGat, vedereNeclara, idMedic, apel(Receptionist), beneficiarReducere(), mergeConsultatie(Medic), faceAnalize(Receptionist), getters&setters, compareTo(Pacient);
    	Clase ce mostenesc Pacient si implementeaza metodele care sunt abstracte in Pacient (apel(Receptionist), beneficiarReducere()):
		- Copil;
		- Pensionar;
		- Adult;

    - Medic = clasa abstracta cu metodele si datele: nume, varta, Medic[], Laborator, nrMedici, setListaMedici(Medic[], int), verificaInformatiiSuficiente(Pacient), programeazaConsultatie(Pacient), programeazaAnalize(Pacient),getters&setters;
    	Clase ce mostenesc Medic si implementeaza metoda abstracta din Medic (consulta(Pacient)):
		- Pediatru;
		- Oftalmolog;
		- Cardiolog;
		- ORL;
		- Dentist;
	
    - Receptionist = clasa cu metodele si datele: nume, id, nrMaximPacientiZilnic, nrPacienti, ziDisponibila, nrPacientiUltimaZi, Vector<Integer> pacienti (aici se afla id-urile pacientilor), consulta(Pacient), getters&setters;
	
    - Laborator = clasa cu metodele si datele: nrPacientiTratati, nrPacienti, nrMaximPacientiZilnic, costAnalize, Vector<Integer> pacienti, getters&setters;
	
