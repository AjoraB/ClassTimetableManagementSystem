import java.util.ArrayList;
import java.util.List;

class Kursi {
    String Grupi;
    String Dita;
    String Ora;
    String Lenda;
    String Salla;

    public Kursi(String Grupi, String Dita, String Ora, String Lenda, String Salla) {
        this.Grupi = Grupi;
        this.Dita = Dita;
        this.Ora = Ora;
        this.Lenda = Lenda;
        this.Salla = Salla;
    }
}

public class OrariIE{
    List<Kursi> Kurse;

    public OrariIE() {
        this.Kurse = new ArrayList<>();
    }

    public void addKursi(Kursi Kursi) {
        Kurse.add(Kursi);
    }
//Metoda Shfaq_Orarin_Javor shfaq orarin javor per nje grup te caktuar. duke marr si parameter emrin e grupit //psh ie-anglish1...
    public void Shfaq_Orarin_Javor(String Emri_Grupit) {
        for (Kursi Kursi : Kurse) {
            if (Kursi.Grupi.toLowerCase().equals(Emri_Grupit.toLowerCase())) {
                System.out.println(Kursi.Grupi + ", " + Kursi.Dita + ", " + Kursi.Ora + ", " +
                        Kursi.Lenda + ", " + Kursi.Salla);
            }
        }
    }
  //Shfaq orarin e kursit duke kerkuar nepermjet dites nese ka kurs mesimor ne ate dite printo kursin nese nuk ka kontrollohet nese eshte fundjave ose nese grupi nuk ka kurs mesimor ate dite
    public void Shfaq_Orarin_Ditor(String Emri_Grupit, String Dita) {
        boolean Fundjave = Dita.equalsIgnoreCase("shtune") || Dita.equalsIgnoreCase("diele");
        boolean Ka_Mesim = false; //flag

        for (Kursi Kursi : Kurse) {
            if (Kursi.Grupi.equalsIgnoreCase(Emri_Grupit) && Kursi.Dita.equalsIgnoreCase(Dita)) {
                System.out.println(Kursi.Grupi + ", " + Kursi.Dita + ", " + Kursi.Ora + ", " +
                        Kursi.Lenda + ", " + Kursi.Salla);
                Ka_Mesim = true;  // kur ka te pakten nje orar mesimi ne diten e zgjedhur nga perdoriuesi var merr vleren true
            }
        }

        if (!Ka_Mesim) {    //ekzekutohet blloku kur nuk ka mesim 
            if (Fundjave) {
                System.out.println(Emri_Grupit + " eshte pushim sepse eshte fundjave.");
            } else {
                System.out.println(Emri_Grupit + " eshte i lire ne kete dite.");
            }
        }
    }
    //Kerkohet te gjendet kursi duke kerkur me emrin e lendes 
    public void Kerko_sipas_emrit(String Emri_Grupit, String emri) {
        boolean perputhje = false;

        for (Kursi Kursi : Kurse) {                     //kontrollohet te gjithe elementet kurse te listes Kursi
            if (Kursi.Grupi.equalsIgnoreCase(Emri_Grupit)) { 
                boolean emri_perputhet = emri.isEmpty() || Kursi.Lenda.toLowerCase().contains(emri.toLowerCase());//kerkimi case insensitive

                if (emri_perputhet) {                 //emri i lendes ne grupin qe kerkon perdoruesi gjendet 
                    System.out.println(Kursi.Grupi + ", " + Kursi.Dita + ", " + Kursi.Ora + ", " +
                            Kursi.Lenda + ", " + Kursi.Salla);
                    perputhje = true;
                }
            }
        }

        if (!perputhje) {                     // emri i lendes ne grupin e kerkimit nuk gjendet 
            System.out.println("Asnje lende me kete emer nuk u gjet.");
        }
    }

    //kerkojme kursin sipas dites se mesimit dhe orarit te mesimit 
    public void Kerko_sipas_orarit(String Emri_Grupit, String Dita, String Ora) {
    boolean perputhje = false;           // flag ndryshon gjendje kur gjendet elementi 
    String oraPas = null;                // var qe mban oren pasardhese e inicializuar bosh si fillim

    for (Kursi Kursi : Kurse) {   
        if (Kursi.Grupi.equalsIgnoreCase(Emri_Grupit) && Kursi.Dita.equalsIgnoreCase(Dita) &&
                (Ora.isEmpty() || Kursi.Ora.startsWith(Ora))) {
            System.out.println(Kursi.Grupi + ", " + Kursi.Dita + ", " + Kursi.Ora + ", " +
                    Kursi.Lenda + ", " + Kursi.Salla);  // printojme kursin qe ka emrin e grupit diten dhe orarin te njejte me kerkimin e perdoruesit
            perputhje = true;  // gjejme elemente keshtu qe ndryshon gjendje
            oraPas = Kursi.Ora;  // ruajme oren e kursit aktual 
        }
    }

    if (perputhje) {   //nese gjendet kursi me diten dhe oren e percaktuar therritet metoda per te gjetur orarin pasardhes
        computeAndDisplayOtherLecture(Emri_Grupit, Dita, oraPas);
    } else {
        System.out.println("Nuk u gjet asnje lende e ngjashme.");
    }
}

private void computeAndDisplayOtherLecture(String Emri_Grupit, String Dita, String oraPas) {
    boolean ora_tjeter = false; //flag ndryshon gjendje nese gjenden elemente 

    for (Kursi Kursi : Kurse) {   //kerkojme cdo element kurse te Kursi qe te kete emrin e grupit dhe diten e grupit te njejte me kerkimin e perdoruesit por me ore te ndryshme
        if (Kursi.Grupi.equalsIgnoreCase(Emri_Grupit) && Kursi.Dita.equalsIgnoreCase(Dita) &&
                !Kursi.Ora.equals(oraPas)) {   
            System.out.println("Lenda tjeter ne kete dite: " + Kursi.Grupi + ", " + Kursi.Dita + ", " +
                    Kursi.Ora + ", " + Kursi.Lenda + ", " + Kursi.Salla);
            ora_tjeter = true;  // flag ndryshon gjendje sepse u gjeten elemente te njejte
            break; // ndalojme pasi gjejme elemntin e pare me ore te ndryshme nga te dhenat e perdoruesit
        }
    }

    if (!ora_tjeter) {  
        System.out.println("Nuk u gjet asnje lende tjeter ne kete dite.");
    }
}

public Kursi[] getKurse() {
    return null;
}
}
