package FAA2022_23.PLUe_Auftrag;

public class Auftrag {
    private String ziel; // Ziel des Auftrags
    private int volumen; // Volumen in EUR
    private boolean erledigt; // Ob der Auftrag erledigt ist

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

    public void printAuftrag() {
        System.out.println(String.format("""
                Auftragsinfos
                =============
                Ziel: %s
                Volumen: %d
                Erledigt: %
                """, ziel, volumen, erledigt));
    }
}
