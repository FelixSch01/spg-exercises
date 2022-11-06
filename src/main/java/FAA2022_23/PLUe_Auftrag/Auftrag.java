package FAA2022_23.PLUe_Auftrag;

public class Auftrag {
    private String ziel; // Ziel des Auftrags
    private int volumen; // Volumen in EUR
    private boolean erledigt; // Ob der Auftrag erledigt ist

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
}
