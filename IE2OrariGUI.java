import java.util.ArrayList;
import java.util.List;

class Kursi {     //Klasa kursi me atributet grupi,dita,ora,lenda,salla.
    String Grupi;
    String Dita;
    String Ora;
    String Lenda;
    String Salla;

    //Konstruktori i klases merr vlerat per keto atribute si argumente dhe i inicializon me vlerat e dhena.
    public Kursi(String Grupi, String Dita, String Ora, String Lenda, String Salla) {
        this.Grupi = Grupi;
        this.Dita = Dita;
        this.Ora = Ora;
        this.Lenda = Lenda;
        this.Salla = Salla;
    }
}

class IE2OrariGUI {    // nje klase e quajtur "IE2OrariGUI", qe permban nje liste te objekteve te klases "Kursi" me emrin "Kurse".
    List<Kursi> Kurse;

    public IE2OrariGUI() {// Konstruktori i klases inicializon listen bosh me ane te nje instance te klases "ArrayList".
        this.Kurse = new ArrayList<>();
    }

    public void addKursi(Kursi Kursi) {
        Kurse.add(Kursi);   //Metoda "addKursi" shton nje objekt te klases "Kursi" ne listen "Kurse"
    }

    //Metoda qe shfaq orarin javor duke marr si parameter string emrin e grupit
    public String Shfaq_Orarin_Javor(String Emri_Grupit) {  
        StringBuilder rezultati = new StringBuilder();  //Krijon nje objekt te tipit StringBuilder per te mbajtur dhe ndryshuar string-un rezultat.
        for (Kursi Kursi : Kurse) {   //Per çdo objekt te tipit "Kursi" ne listen "Kurse", kryen veprimet ne vijim.
            if (Kursi.Grupi.equalsIgnoreCase(Emri_Grupit)) {  //Kontrollon nese emri i grupit te kursit perputhet me emrin e grupit te dhene si parameter. Krahasimi behet pa marre parasysh ndryshimin e madhesise se shkronjave.
                rezultati.append(Kursi.Dita).append(", ").append(Kursi.Ora)  //shtohet informacioni per kete kurs ne string-un rezultat ne nje format te percaktuar.
                        .append(", ").append(Kursi.Lenda).append(", ").append(Kursi.Salla).append("\n");
            }
        }
        return rezultati.toString();  //Kthen string-un perfundimtar duke perdorur metoden toString() e objektit StringBuilder, duke e konvertuar ate ne nje string te thjeshte.
    }

    //Metoda qe shfaq orarin ditor duke marr si parameter string emrin e grupit dhe diten 
    public String Shfaq_Orarin_Ditor(String Emri_Grupit, String Dita) {
        boolean Fundjave = Dita.equalsIgnoreCase("shtune") || Dita.equalsIgnoreCase("diele"); // Krijon nje variabel booleane, "Fundjave", e cila eshte e vertete nese dita eshte "shtune" ose "diele".
        boolean Ka_Mesim = false;  //Krijon nje variabel booleane, "Ka_Mesim", e cila fillon me vleren false. Kjo perdoret per te verifikuar nese grupi ka mesim ne diten e dhene.
        StringBuilder rezultati = new StringBuilder();

        for (Kursi Kursi : Kurse) {  // Per çdo objekt te tipit "Kursi" ne listen "Kurse", kryen veprimet ne vijim.
            if (Kursi.Grupi.equalsIgnoreCase(Emri_Grupit) && Kursi.Dita.equalsIgnoreCase(Dita)) {  //Kontrollon nese emri i grupit te kursit dhe dita e kursit perputhen me emrin e grupit dhe diten e dhene si parameter.
                rezultati.append(", ").append(Kursi.Dita).append(", ").append(Kursi.Ora)  // Nese kushti ne if eshte i vertete, shtohet informacioni per kete kurs ne string-un rezultat dhe "Ka_Mesim" behet true.
                        .append(", ").append(Kursi.Lenda).append(", ").append(Kursi.Salla).append("\n");
                Ka_Mesim = true;
            }
        }

        if (!Ka_Mesim) {  //Kontrollon nese nuk ka mesim ne diten e dhene
            if (Fundjave) {   //nese  edhte fundjave shto mesazhin
                rezultati.append(Emri_Grupit).append(" eshte pushim sepse eshte fundjave.");
            } else {  
                rezultati.append(Emri_Grupit).append(" Kontrolloni vleren e dhene.");
            }
        }

        return rezultati.toString(); // Kthen string-un perfundimtar duke perdorur metoden toString() e objektit StringBuilder, duke e konvertuar ate ne nje string te thjeshte.

    }

    //Metoda qe kerkon orarin duke marre si parametra emrin e grupit dhe emrin e lendes 
    public String Kerko_sipas_emrit(String Emri_Grupit, String emri) {
        boolean perputhje = false;   //perdoret per te verifikuar nese ka ndonje perputhje mes emrit te dhene te lendes dhe emrit te dhene te grupit.
        StringBuilder rezultati = new StringBuilder();

        for (Kursi Kursi : Kurse) {  //Per çdo objekt te tipit "Kursi" ne listen "Kurse", kryen veprimet ne vijim.
            if (Kursi.Grupi.equalsIgnoreCase(Emri_Grupit)) {  //Kontrollon nese emri i grupit te kursit perputhet me emrin e grupit te dhene si parameter.
                //Krijon nje variabel booleane, "emri_perputhet", e cila percakton nese emri i lendes perputhet me emrin e dhene per kerkim.
                // Percaktimi behet duke pare nese emri i lendes permban pjesen e emrit te dhene per kerkim, dhe krahasimi behet pa marre parasysh ndryshimin e madhesise se shkronjave.
                boolean emri_perputhet = emri.isEmpty() || Kursi.Lenda.toLowerCase().contains(emri.toLowerCase());

                if (emri_perputhet) { //Nese emri i lendes perputhet, shtohet informacioni per kete kurs ne string-un 
                    rezultati.append(Kursi.Dita).append(", ").append(Kursi.Ora)
                            .append(", ").append(Kursi.Lenda).append(", ").append(Kursi.Salla).append("\n");
                    perputhje = true;  //variabli merr vleren true
                }
            }
        }

        if (!perputhje) {  //nuk ka perputhje
            rezultati.append("Asnje lende me kete emer nuk u gjet.");
        }

        return rezultati.toString();
    }


    //Metoda qe ben kerkimin e orarit duke marr si parametra 3 string emrin e grupit dites dhe ores po ashtu printor dhe oren pasardhese 
    public String Kerko_sipas_orarit(String Emri_Grupit, String Dita, String Ora) {
        boolean perputhje = false;  //Kjo perdoret per te verifikuar nese ka ndonje perputhje mes emrit te dhene te lendes dhe emrit te dhene te grupit dhe ores
        String oraPas = null;
        StringBuilder rezultati = new StringBuilder();

        for (Kursi Kursi : Kurse) {  //Per çdo objekt te tipit "Kursi" ne listen "Kurse", kryen veprimet ne vijim.
            if (Kursi.Grupi.equalsIgnoreCase(Emri_Grupit) && Kursi.Dita.equalsIgnoreCase(Dita) &&
                    (Ora.isEmpty() || Kursi.Ora.startsWith(Ora))) {  //kontrollon nese emri i grupit perputhet dhe dita perputhet dhe nese ora nuk eshte bosh dhe ora fillon me vleren e ores se dhene
                rezultati.append(Kursi.Dita).append(", ").append(Kursi.Ora)
                        .append(", ").append(Kursi.Lenda).append(", ").append(Kursi.Salla).append("\n");
                perputhje = true;  //eshte gjetur nje perputhje mes vlerave te dhena dhe vlerave ne array list
                oraPas = Kursi.Ora;  //Vendos vleren e ores se kursit ne variablen "oraPas"
            }
        }

        if (perputhje) {  // nese gjejme nje orar me parametra si te perdoruesit kerkojme qe te shfaqim oren tjeter 
            Shfaq_Oren_Tjeter(Emri_Grupit, Dita, oraPas, rezultati); //therrasim metoden qe merr si parameter emrin e grupit,diten,oren aktuale, dhe stringun rezulatati
        } else {
            rezultati.append("Nuk u gjet asnje rezultat per te dhenat tuaja.");
        }

        return rezultati.toString();
    }

    //Metoda qe shfaq oren tjeter
    private void Shfaq_Oren_Tjeter(String Emri_Grupit, String Dita, String oraPas, StringBuilder rezultati) {
        boolean ora_tjeter = false;  //jo perdoret per te verifikuar nese ka gjetur ose jo nje lende tjeter ne te njejten dite.

        for (Kursi Kursi : Kurse) {
            if (Kursi.Grupi.equalsIgnoreCase(Emri_Grupit) && Kursi.Dita.equalsIgnoreCase(Dita) &&
                    !Kursi.Ora.equals(oraPas)) {  //Kontrollon nese emri i grupit te kursit, dita, dhe ora e kursit nuk jane te njejtat me ato te kursit te fundit te gjetur.
                rezultati.append("Lenda tjeter ne kete dite: ").append(Kursi.Ora).append(", ").append(Kursi.Lenda).append(", ")
                        .append(Kursi.Salla).append("\n");
                ora_tjeter = true; //gjetur nje lende tjeter ne kete dite me ore te ndryshme se aktualja
                break;
            }
        }

        if (!ora_tjeter) {  //nese nuk gjendet nje ore tjeter pas ores aktuale
            rezultati.append("Nuk u gjet asnje lende tjeter ne kete dite.");
        }
    }

    public Kursi[] getKurse() {
        return null;
    }
}