package FAA2022_23.PLUe_Auftrag;

public class Auftrag {
    private String ziel; // Ziel des Auftrags
    private int volumen; // Volumen in EUR
    private boolean erledigt; // Ob der Auftrag erledigt ist
    private int kosten;

    // ------- ctor ----------
    public Auftrag() {
        ziel = "nicht bekannt";
        volumen = 0;
        erledigt = false;
    }

    public Auftrag(String ziel, int volumen, boolean erledigt) {
        this.ziel = ziel;
        this.volumen = volumen;
        this.erledigt = erledigt;
    }

    // ------- setter -------
    public void setZiel(String ziel) {
        if(ziel != null) {
            this.ziel = ziel;
        }
        else {
            System.out.println("Fehler bei setZiel(): Wert darf nicht null sein.");
            this.ziel = "nicht bekannt";
        }
    }

    public void setVolumen(int volumen) {
        if(volumen >= 0 && volumen <= 10000) {
            this.volumen = volumen;
        }
        else {
            System.out.println("Fehler bei setVolumen(): Wert muss mindestens 0 und darf maximal 10000 sein.");
            this.volumen = 0;
        }
    }

    public void setKosten(int kosten){
        if (kosten < 0) {
            this.kosten = 0;
            System.out.printf("Der Wert von 'kosten' muss mindestens 0 sein, war aber %d", kosten);
        }
        else {
            this.kosten = kosten;
        }
    }
    public void setErledigt(boolean erledigt) {
        this.erledigt = erledigt;
    }

    // ----- getter ------
    public String getZiel() {
        return ziel;
    }

    public int getVolumen() {
        return volumen;
    }

    public boolean isErledigt() {
        return erledigt;
    }

    public int getKosten() {
        return kosten;
    }

    // ------ methoden ----------
    public void printAuftrag() {
        System.out.printf("""
                Auftragsinfos
                =============
                Ziel: %s
                Volumen: %d
                Erledigt: %
                """, ziel, volumen, erledigt);
    }

    public double provision() {
        double provision = (double)volumen * 0.2;
        if(!ziel.equals("nicht bekannt")) {
            System.out.printf("20%% Provision: %f", provision);
            return provision;
        }
        else {
            System.out.println("Keine Provision, Ziel des Auftrags nicht bekannt.");
            return 0;
        }
    }

    public double gewinn() {
        double gewinn = 0;
        if (erledigt) {
            gewinn = (double)volumen - ((double)kosten + provision());
            System.out.printf("Gewinn: %f", gewinn);
        }
        else
            System.out.println("Kein Gewinn, Auftrag nicht erledigt");
        return gewinn;
    }
}
