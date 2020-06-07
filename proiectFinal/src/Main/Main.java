package Main;

import Pacienti.Adult;
import Pacienti.Copil;
import Pacienti.Pacient;
import Pacienti.Pensionar;
import PersonalMedical.*;
import Services.Service;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Service MyService = new Service();


        try {
            //incarcarea personalului medical
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_schema", "root", "1234");
            Statement mySt = myConn.createStatement();
            ResultSet myRs = mySt.executeQuery("SELECT COUNT(*) FROM personalmedical");
            myRs.next();
            int nrMedici = myRs.getInt("COUNT(*)");
            Medic[] listaMedici = new Medic[nrMedici];
            int idx = 0;

            myRs = mySt.executeQuery("SELECT * FROM personalmedical");
            while (myRs.next()) {
                int nrMaximPacientiZilnic = myRs.getInt("nrMaximPacientiZilnic");
                int specializare = myRs.getInt("specializare");
                String nume = myRs.getString("nume");
                if (specializare == 1) {
                    listaMedici[idx] = new Pediatru(nume, nrMaximPacientiZilnic);
                }
                if (specializare == 2) {
                    listaMedici[idx] = new Dentist(nume, nrMaximPacientiZilnic);
                }
                if (specializare == 3) {
                    listaMedici[idx] = new Oftalmolog(nume, nrMaximPacientiZilnic);
                }
                if (specializare == 4) {
                    listaMedici[idx] = new Orl(nume, nrMaximPacientiZilnic);
                }
                if (specializare == 5) {
                    listaMedici[idx] = new Cardiolog(nume, nrMaximPacientiZilnic);
                }
                idx++;
            }

            //incarcarea datelor laboratorului
            myRs = mySt.executeQuery("SELECT * FROM laborator");
            myRs.next();
            Laborator laborator = new Laborator(myRs.getInt("nrMaximPacienti"), myRs.getInt("cost"));


            //un intermediar care de fapt face ce in realitate face un receptionist
            //daca un pacient are date suficiente, ii programeaza o consultatie,
            //altfel, ii programeaza o vizita la laborator pentru analize
            Receptionist receptionist = MyService.crearePoliclinica(listaMedici, 10, laborator);


            //incarcarea listei de pacienti
            List<Pacient> listaPacienti = new ArrayList<>();
            myRs = mySt.executeQuery("SELECT COUNT(*) FROM pacienti");
            myRs.next();
            int nrPacienti = myRs.getInt("COUNT(*)");
            listaPacienti = MyService.incarcaPacienti(mySt,myRs);


            //serviciu de stergere a unui pacient
            //MyService.stergePacient(listaPacienti,nrPacienti,mySt);

            //programam toti pacientii
            //MyService.programeaza(listaPacienti, nrPacienti, receptionist);

            //afisam toti pacientii inregistrati si programati, fie la laborator, fie la consultatie
            //MyService.afisarePacienti(listaPacienti, 10);

            //simulam procesul de trecere a timpului: toti pacientii care trebuie sa viziteze laboratorul o vor face iar apoi
            //vor fi programati la o vizita la medic; fiecare pacient apoi este consultat si i se prescrie un tratament
            //MyService.trecereaTimpului(listaPacienti, nrPacienti, receptionist, 0);

            //serviciu ce afiseaza costul tratamentului pentru un pacient
            //MyService.afisareCostTratament(listaPacienti.get(0));

            //cream JFrameul home
            JFrame home = new JFrame("Policlinica - home");
            home.setSize(new Dimension(800, 400));
            home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            home.setLayout(new BorderLayout());
            JLabel topHome = new JLabel("Alegeti o operatie:");
            JPanel centerHome = new JPanel();
            centerHome.setLayout(new GridLayout(1,2));
            JButton gestionareScreen = new JButton("Gestionare baza de date pacienti");
            JButton programeaza = new JButton("Programeaza toti pacientii");
            JButton trecereaTimpului = new JButton("Simuleaza trecerea timpului");
            centerHome.add(gestionareScreen);
            centerHome.add(programeaza);
            centerHome.add(trecereaTimpului);
            home.add(topHome, BorderLayout.NORTH);
            home.add(centerHome, BorderLayout.CENTER);
            home.setVisible(true);

            //cream JFrameul de gestionare
            JFrame gestionare = new JFrame("Policlinica - gestionare baza de date pacienti");
            gestionare.setSize(800,400);
            gestionare.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gestionare.setLayout(new BorderLayout());
            JLabel topGestionare = new JLabel("Introduceti datele si alegeti tipul operatiei:");
            gestionare.setVisible(false);
            JPanel introducereDate = new JPanel();
            introducereDate.setLayout(new GridLayout(6,2));
            JLabel nume = new JLabel("Nume: ");
            JTextField numeIntrodus = new JTextField(20);
            JLabel varsta = new JLabel("Varsta: ");
            JTextField varstaIntrodusa = new JTextField(20);
            JLabel afectiunea = new JLabel("Afectiune: ");
            JTextField afectiuneaIntrodusa = new JTextField(20);
            JLabel numeNou = new JLabel("Nume nou (doar pentru editare): ");
            JTextField numeNouIntrodus = new JTextField(20);
            JLabel varstaNoua = new JLabel("Varsta noua (doar pentru editare): ");
            JTextField varstaNouaIntrodusa = new JTextField(20);
            JLabel afectiuneaNoua = new JLabel("Afectiune noua (doar pentru editare): ");
            JTextField afectiuneaNouaIntrodusa = new JTextField(20);
            introducereDate.add(nume);
            introducereDate.add(numeIntrodus);
            introducereDate.add(varsta);
            introducereDate.add(varstaIntrodusa);
            introducereDate.add(afectiunea);
            introducereDate.add(afectiuneaIntrodusa);
            introducereDate.add(numeNou);
            introducereDate.add(numeNouIntrodus);
            introducereDate.add(varstaNoua);
            introducereDate.add(varstaNouaIntrodusa);
            introducereDate.add(afectiuneaNoua);
            introducereDate.add(afectiuneaNouaIntrodusa);
            JPanel butoane = new JPanel();
            JButton butonAdauga = new JButton("Adauga pacient");
            JButton butonEditeaza = new JButton("Editeaza pacient");
            JButton butonSterge = new JButton("Sterge pacient");
            JButton butonCost = new JButton("Calcul cost tratament");
            JButton butonData = new JButton("Data programarii");
            JButton butonInapoi = new JButton("Inapoi");
            butoane.add(butonAdauga);
            butoane.add(butonEditeaza);
            butoane.add(butonSterge);
            butoane.add(butonCost);
            butoane.add(butonData);
            butoane.add(butonInapoi);
            gestionare.add(topGestionare,BorderLayout.NORTH);
            gestionare.add(introducereDate,BorderLayout.CENTER);
            gestionare.add(butoane,BorderLayout.SOUTH);

            gestionareScreen.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    home.setVisible(false);
                    gestionare.setVisible(true);

                }
            });

            List<Pacient> finalListaPacienti = listaPacienti;
            programeaza.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    JOptionPane.showMessageDialog(home, "Pacientii au fost programati cu succes!");
                    try {
                        MyService.programeaza(finalListaPacienti,nrPacienti,receptionist);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            trecereaTimpului.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    JOptionPane.showMessageDialog(home, "Simularea s-a incheiat!");
                    try {
                        MyService.trecereaTimpului(finalListaPacienti,nrPacienti,receptionist,0);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

            butonInapoi.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    home.setVisible(true);
                    gestionare.setVisible(false);

                }
            });

            butonAdauga.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    String nume = numeIntrodus.getText();
                    int varsta = Integer.parseInt(varstaIntrodusa.getText());
                    int afectiune = Integer.parseInt(afectiuneaIntrodusa.getText());
                    MyService.adaugaPacient(finalListaPacienti,nrPacienti,mySt,nume,varsta,afectiune);
                }
            });

            butonEditeaza.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    String nume = numeIntrodus.getText();
                    int varsta = Integer.parseInt(varstaIntrodusa.getText());
                    int afectiune = Integer.parseInt(afectiuneaIntrodusa.getText());
                    String numeNou = numeNouIntrodus.getText();
                    int varstaNoua = Integer.parseInt(varstaNouaIntrodusa.getText());
                    int afectiuneNoua = Integer.parseInt(afectiuneaNouaIntrodusa.getText());
                    MyService.editeazaPacient(finalListaPacienti,nrPacienti,mySt,nume,varsta,afectiune,numeNou,varstaNoua,afectiuneNoua);
                }
            });

            butonCost.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    String nume = numeIntrodus.getText();
                    int varsta = Integer.parseInt(varstaIntrodusa.getText());
                    int afectiune = Integer.parseInt(afectiuneaIntrodusa.getText());
                    String cost = null;
                    try {
                        cost = MyService.costTratament(finalListaPacienti,nrPacienti,nume,varsta,afectiune);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(home, "Costul tratamentului este:" + cost);
                }
            });

            butonData.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    String nume = numeIntrodus.getText();
                    int varsta = Integer.parseInt(varstaIntrodusa.getText());
                    int afectiune = Integer.parseInt(afectiuneaIntrodusa.getText());
                    String cost = null;
                    try {
                        cost = MyService.dataProgramarii(finalListaPacienti,nrPacienti,nume,varsta,afectiune);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    JOptionPane.showMessageDialog(home, "Data programarii este:" + cost);
                }
            });

            butonSterge.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    String nume = numeIntrodus.getText();
                    int varsta = Integer.parseInt(varstaIntrodusa.getText());
                    int afectiune = Integer.parseInt(afectiuneaIntrodusa.getText());
                    MyService.stergePacient(finalListaPacienti,nrPacienti,mySt,nume,varsta,afectiune);
                }
            });
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
