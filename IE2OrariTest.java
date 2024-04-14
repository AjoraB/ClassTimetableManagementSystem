import java.util.Scanner;

public class IE2OrariTest {
    public static void main(String[] args) {
        OrariIE OrariIE = Krijo_Orarini();  //Ky kod krijon nje instance te klases OrariIE dhe i cakton vleren e kthyer nga funksioni Krijo_Orarini() ne nje variabel me emrin OrariIE.

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Opsionet:");
            System.out.println("1. Shfaq orarin javor");
            System.out.println("2. Shfaq orarin per nje dite te caktuar");
            System.out.println("3. Kerko sipas emrit te lendes");
            System.out.println("4. Kerko sipas dites dhe orarit ");
            System.out.print("Zgjidh nje nga opsionet (1-4): ");
            int zgjedhja = scanner.nextInt();  //Ruan zgjedhjen e perdoruesin ne variablin zgjedhja

            System.out.print("Vendos grupin ( IE-Anglisht1, IE-Anglisht2): ");
            String Emri_Grupit = scanner.next(); // ruan vleren e vendosur nga perdoruesi ne variablin Emri_Grupit

            switch (zgjedhja) {    // Cfare ndodh ne cdo rast te zgjedhjes qe ben perdoruesi
                case 1:
                    OrariIE.Shfaq_Orarin_Javor(Emri_Grupit);  // Nga klasa OrariIE therrasim metoden qe merr si parameter emrin e grupit 
                    break;
                case 2:
                    System.out.print("Vendos nje dite  (psh Marte):  ");
                    String Dita = scanner.next();               // Ruani diten ne variablin Dita
                    OrariIE.Shfaq_Orarin_Ditor(Emri_Grupit, Dita);            //Nga klasa OrariIE therrasim metoden qe shfaq orarin ditor dhe merr si parameter emrin e grupit dhe diten
                    break;
                case 3:
                    System.out.print("Vendos emrin e lendes: ");
                    String emriSearch = scanner.next();               //Ruan ne variablin emeriSearch vleren qe jep perdoruesi
                    OrariIE.Kerko_sipas_emrit(Emri_Grupit, emriSearch);      //Nga klasa OrariIE therrasim metoden qe shfaq orarin sipas emrit te lendes dhe merr si parameter emrin e grupit dhe lenden
                    break;
                case 4:
                    System.out.print("Vendos diten dhe oren (hh:mm): ");
                    String dita = scanner.next();         //Ruan ne variablin dita diten e dhene nga perdoruesi
                    String OraSearch = scanner.next();       // Ruan ne variablin orasearch oren e dhene nga perdoruesi
                    OrariIE.Kerko_sipas_orarit(Emri_Grupit, dita, OraSearch);      //therret nga klasa OrariIE metoden qe kerkon sipas ores dhe dites dhe merr 3 parametra emrin e grupit,diten,oren
                    break;
                default:
                    System.out.println("Zgjedhje jo e vlefshme");
            }
        }
    }
private static OrariIE Krijo_Orarini() {
        OrariIE ie2Orari = new OrariIE();    //Ky rresht i kodit krijon nje instance te re te klases OrariIE dhe i cakton ate ne variablen ie2Orari.

        //Shtohen objektet e kursit ne orar qe kane atributet e grupi, dita,ora,lenda,salla
     
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