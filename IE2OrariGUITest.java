import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class IE2OrariGUITest extends Application {
    public static void main(String[] args) {
        launch(args);     // Kjo eshte metoda kryesore (main) e programit Java. launch(args) perdoret per te filluar nje aplikacion JavaFX.
    }

    @Override        //tregon se nje metode ne nje klase permireson nje metode ekzistuese te trasheguar nga nje prind 
    public void start(Stage primaryStage) {
        Krijo_Orarini();

        GridPane grid = new GridPane();       // Krijon nje objekt te tipit GridPane, i cili  perdoret per te organizuar elementet ne forme te rrjetit ose tabele.
        grid.setPadding(new Insets(10, 10, 10, 10));     //Ne kete rast, ka nje hapesire prej 10 pikselash ne te gjitha anet (siper, poshte, majtas, dhe djathtas).
        grid.setVgap(8);   //Percakton distancen vertikale ne kete rast eshte 8 piksel
        grid.setHgap(10);    //  Percakton distancen vertikale qe ne kete rast eshte 10 pikesela

        ComboBox<String> Zgjidhni_Grupin_Kuti = new ComboBox<>();  //Krijon nje kuti dropdown
        Zgjidhni_Grupin_Kuti.getItems().addAll("IE-Anglisht1", "IE-Anglisht2");  // shton elementet qe perdoruesi mund te zgjedhi ne kete rast  "IE-Anglisht1", "IE-Anglisht2"
        Zgjidhni_Grupin_Kuti.setPromptText("Zgjidhni Grupin");   //Vendos nje tekst shpjegues brenda kutis se grupit

        ComboBox<String> Kuti_Kerkimi = new ComboBox<>();     //Krijon nje kuti dropdown
        Kuti_Kerkimi.getItems().addAll("Shfaq orarin javor", "Shfaq orarin per nje dite te caktuar",  //Shton elementet qe perdoruesi mund te zgjedhe
                "Kerko sipas emrit te lendes", "Kerko sipas dites dhe orarit");
        Kuti_Kerkimi.setPromptText("Zgjidh llojin e kerkimit");  //shton tekstin ndihmes/shpjegues  brenda kutise
  
        Label Kuti_Dita = new Label("Dita:");    // krijon nje objekt me tekstin Dita
        TextField Fusha_Dita = new TextField();     //Krijon nje kuti ku perdoruesi mund te shkruaj text
        Fusha_Dita.setDisable(true);       // Perdoruesi nuk mund te redaktoj tekstin ne kete kuti

        Label Kuti_Lenda = new Label("Lenda:"); // krijon nje objekt qe lexon lenda
        TextField Fusha_Lenda = new TextField();    // krijon nje kuti ku perdoruesi mund te shkruaj text
        Fusha_Lenda.setDisable(true);    // Perdoruesi nuk mund te redaktoj tekstin ne kete kuti

        Label Kuti_Ora = new Label("Ora:");    // krijon nje objekt qe lexon ora
        TextField Fusha_Ora = new TextField();      //Krijon nje kuti ku perdoruesi mund te shkruaj text

        Button Butoni_Kerko = new Button("Kerko");   //Krijon nje buton me emrin kerko
        Button Butoni_Pastro = new Button("Fshij");   //Krijon nje buton me emrin fshij

        TextArea Zone_Teksti = new TextArea();         //Krijon nje hapsire ku mund te vendosen shume rreshta text
        Zone_Teksti.setEditable(false);          //E bejme kte zone teksti te paeditueshme

     
        Kuti_Kerkimi.setOnAction(event -> {               
            String Kerkimi_Zgjedhur = Kuti_Kerkimi.getValue();  //vlera e kutis se kerkimit e zgjedhur nga perdoruesi ruhet ne variabling Kerkimi_zgjedhur

           //Caktivizon komponentet ne nderfaqen e perdoruesit
            Fusha_Dita.setDisable(true);
            Fusha_Lenda.setDisable(true);
            Fusha_Ora.setDisable(true);

           //  Me Cfare fushash mund te nderveproj perdoruesi ne varesi te zgjedhjes se llojit te kerkimit
            if (Kerkimi_Zgjedhur != null) { 
                switch (Kerkimi_Zgjedhur) {
                    case "Shfaq orarin javor":     // Perdoruesi nuk ndervepron me asnje nga fushat
    
                        break;
                    case "Shfaq orarin per nje dite te caktuar":
                        Fusha_Dita.setDisable(false);  //Perdoruesi ndervepron me fushen e dites
                        break;
                    case "Kerko sipas emrit te lendes":
                        Fusha_Lenda.setDisable(false);   //Perdoruesi ndervepron me fushen e lendes
                        break;
                    case "Kerko sipas dites dhe orarit":
                        Fusha_Dita.setDisable(false);   //Perdoruesi ndervepron me fushen e dites dhe te ores
                        Fusha_Ora.setDisable(false);
                        break;
                    default:
                        Zone_Teksti.setText("Fushe e pavlefshme kerkimi.");
                        break;
                }
            }
        });

        Butoni_Kerko.setOnAction(event -> {
            String Grupi_Zgjedhur = Zgjidhni_Grupin_Kuti.getValue(); //Ruan opsionin e zgjedhur nga kutia grupi ne var Grupi_Zgjedhur
            String Kerkimi_Zgjedhur = Kuti_Kerkimi.getValue();    //Ruan opsionin e zgjedhur nga kutia e kerkimit ne variablin kerkimi_Zgjedhur
            String Dita_Shkruajtur = Fusha_Dita.getText();       //Ruan tekstin e shkruajtur ne fushen dita ne variablin Dita_Shkruajtur
            String Lenda_Zgjedhur = Fusha_Lenda.getText();        //Ruan tekstin e shkruajtur ne fushen lenda ne variablin Lenda_Shkruajtur
            String Ora_Zgjedhur = Fusha_Ora.getText();      //Ruan tekstin e shkruajtur ne fushen ora ne variablin Ora_Shkruajtur

            if (Grupi_Zgjedhur == null || Kerkimi_Zgjedhur == null) {
                Platform.runLater(() -> Zone_Teksti.setText("Ju lutem zgjidhni grupin dhe menyren e kerkimit."));  //Nese grupi ose menyra e kerkimit nuk zgjidhen afishohet mesazhi
                return;
            }

            IE2OrariGUI IE2OrariGUI = Krijo_Orarini();       // Nje funksion qe kthen nje objekt te klases IE2OrariGUI.
            switch (Kerkimi_Zgjedhur) {
                case "Shfaq orarin javor":
                    if (Grupi_Zgjedhur != null) {
                        Platform.runLater(() -> {
                            Zone_Teksti.setText("");   //Fshin cdo vlere te meparshme qe mund te kishte kutia e tekstit
                            Zone_Teksti.appendText(IE2OrariGUI.Shfaq_Orarin_Javor(Grupi_Zgjedhur)); 
                        });//Thirret metoda nga IE2OrariGUI qe shfaq orarin javor te grupit te zgjedhur dhe kjo e dhene e kthyer shtohet ne ui
                    }
                    break;
                    case "Shfaq orarin per nje dite te caktuar":
                    if (Grupi_Zgjedhur != null) {
                        Platform.runLater(() -> {
                            Zone_Teksti.setText(""); //Fshi te dhenat e meparshme 
                            if (Dita_Shkruajtur.isEmpty()) {     // Kontrollo nese Dita_Shkruajtur eshte e zbrazet dhe ndrysho pamjen e kutise se tekstit ne e kuqe
                                Fusha_Dita.setStyle("-fx-border-color: red;");
                            } else {
                                Fusha_Dita.setStyle("-fx-border-color: inherit;"); // Nese Dita_Shkruajtur nuk eshte e zbrazet, rikthe stilen normale te kutise se tekstit
                                Zone_Teksti.appendText(IE2OrariGUI.Shfaq_Orarin_Ditor(Grupi_Zgjedhur, Dita_Shkruajtur));  
                            }  //Thirret metoda nga IE2OrariGUI qe shfaq orarin ditor te grupit te zgjedhur dhe kjo e dhene e kthyer shtohet ne ui
                        });
                    }
                    break;
                    case "Kerko sipas emrit te lendes":
                    if (Grupi_Zgjedhur != null) {
                        Platform.runLater(() -> {
                            Zone_Teksti.setText(""); // Kontrollo nese Lenda_Zgjedhur eshte e zbrazet dhe ndrysho pamjen e kutise se tekstit ne e kuqe
                            if (Lenda_Zgjedhur.isEmpty()) {
                                Fusha_Lenda.setStyle("-fx-border-color: red;");
                            } else {               // Nese Lenda_Zgjedhur nuk eshte e zbrazet, rikthe stilen normale te kutise se tekstit
                                Fusha_Lenda.setStyle("-fx-border-color: inherit;");
                                Zone_Teksti.appendText(IE2OrariGUI.Kerko_sipas_emrit(Grupi_Zgjedhur, Lenda_Zgjedhur));
                            }//Thirret metoda nga IE2OrariGUI qe shfaq orarin sipas emrit  te grupit te zgjedhur dhe kjo e dhene e kthyer shtohet ne ui
                        });
                    }
                    break;
                    case "Kerko sipas dites dhe orarit":
                    if (Grupi_Zgjedhur != null) {
                        Platform.runLater(() -> {
                            Zone_Teksti.setText(""); // Pastro rezultatet e meparshme
                
                            // Kontrollo nese Dita_Shkruajtur dhe Ora_Zgjedhur jane te zbrazeta dhe ndrysho pamjen e kutise se tekstit ne e kuqe
                            if (Dita_Shkruajtur.isEmpty() || Ora_Zgjedhur.isEmpty()) {
                                if (Dita_Shkruajtur.isEmpty()) {
                                    Fusha_Dita.setStyle("-fx-border-color: red;");
                                } else {
                                    Fusha_Dita.setStyle("-fx-border-color: inherit;");
                                }
                
                                if (Ora_Zgjedhur.isEmpty()) {
                                    Fusha_Ora.setStyle("-fx-border-color: red;");
                                } else {
                                    Fusha_Ora.setStyle("-fx-border-color: inherit;");
                                }
                            } else {
                                // Nese te dy fushat nuk jane te zbrazeta, rikthe stilen normale te kutise se tekstit
                                Fusha_Dita.setStyle("-fx-border-color: inherit;");
                                Fusha_Ora.setStyle("-fx-border-color: inherit;");
                                Zone_Teksti.appendText(IE2OrariGUI.Kerko_sipas_orarit(Grupi_Zgjedhur, Dita_Shkruajtur, Ora_Zgjedhur));
                            }///Thirret metoda nga IE2OrariGUI qe shfaq orarin sipas emrit  te grupit te zgjedhur dhe kjo e dhene e kthyer shtohet ne ui 
                        });
                    }
                    break;
                default:
                    Platform.runLater(() -> Zone_Teksti.setText("Fushe e pavlefshme kerkimi."));
                }
        });

        Butoni_Pastro.setOnAction(event -> {         //i japim funksionin butonit pastro pastron cdo fushe
            Zgjidhni_Grupin_Kuti.setValue(null); 
            Kuti_Kerkimi.setValue(null);
            Fusha_Dita.clear();
            Fusha_Lenda.clear();
            Fusha_Ora.clear();
            Zone_Teksti.clear();
        });

       //Shto komponentet ne grid
        grid.add(new Label("Zgjidh grupin:"), 0, 0);  //shton nje etiket me emrin Zgjidh grupin ne kordinatat (0,0)
        grid.add(Zgjidhni_Grupin_Kuti, 1, 0);  //shto kutine per te zgjedhur grupin
        grid.add(new Label("Zgjidh metoden e kerkimit:"), 0, 1); // shto nje etiket ne kordinatat (0,1)
        grid.add(Kuti_Kerkimi, 1, 1);  
        grid.add(Kuti_Dita, 0, 2);
        grid.add(Fusha_Dita, 1, 2);
        grid.add(Kuti_Lenda, 0, 3);
        grid.add(Fusha_Lenda, 1, 3);
        grid.add(Kuti_Ora, 0, 4);
        grid.add(Fusha_Ora, 1, 4);
        grid.add(Butoni_Kerko, 0, 5);
        grid.add(Butoni_Pastro, 1, 5);
        grid.add(new Label("Rezultati:"), 0, 6);
        grid.add(Zone_Teksti, 1, 6, 2, 1);

        //vendosim skenen dhe stagein 
        Scene scene = new Scene(grid, 600, 400);
        primaryStage.setTitle("Orari mesimor");  //titulli i skenes
        primaryStage.setScene(scene); //Vendos skenen ne dritaren kryesore 
        primaryStage.show();   //Shfaq dritaren ne ekran
    }

    // Krijojme objektin 
    private IE2OrariGUI Krijo_Orarini() {
        IE2OrariGUI ie2Orari = new IE2OrariGUI();
        ie2Orari.addKursi(new Kursi("IE-Anglisht1", "Hene", "8:30-9:20", "Bazat e statistikes (seminar)", "B306"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht1", "Hene", "10:30-12:20", "Bazat e statistikes", "B306"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht1", "Mart", "8:30-11:20", "Arkitekture Kompjuteri", "B405"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht1", "Mart", "11:30-13:20", "Arkitekture Kompjuteri (seminar)", "B306"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht1", "Merkur", "8:30-10:20", "Mikroekonomi", "B504"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht1", "Merkur", "10:30-12:20", "Mikroekonomi (seminar)", "A107"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht1", "Merkur", "12:30-14:20", "Matematik e Zbatuar (seminar)", "B305"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht1", "Enjte", "10:30-12:20", "Matematik e Zbatuar", "B204"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht1", "Enjte", "12:30-14:20", "Programim Java", "A104"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht1", "Premte", "9:30-11:20", "Programim Java (seminar)", "A107"));

        ie2Orari.addKursi(new Kursi("IE-Anglisht2", "Hene", "10:30-12:20", "Bazat e statistikes", "B306"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht2", "Mart", "8:30-11:20", "Arkitekture Kompjuteri", "B405"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht2", "Mart", "11:30-13:20", "Arkitekture Kompjuteri (seminar)", "B306"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht2", "Merkur", "8:30-10:20", "Mikroekonomi", "B504"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht2", "Merkur", "10:30-12:20", "Bazat e Statistikes (seminar)", "GL210"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht2", "Merkur", "12:30-14:20", "Mikroekonomi (seminar)", "A208"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht2", "Enjte", "8:30-10:20", "Matematik e Zbatuar (seminar)", "B204"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht2", "Enjte", "10:30-12:20", "Matematik e Zbatuar", "B204"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht2", "Enjte", "12:30-14:20", "Programim Java", "A104"));
        ie2Orari.addKursi(new Kursi("IE-Anglisht2", "Premte", "9:30-11:20", "Programim Java (seminar)", "A107"));

        return ie2Orari;
    }
}   