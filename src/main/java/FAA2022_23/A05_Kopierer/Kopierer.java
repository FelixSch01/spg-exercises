package FAA2022_23.A05_Kopierer;

public class Kopierer {
    // properties
    private int papier; // max = 1000
    private boolean inOrdnung;

    // constructors
    public Kopierer() {
        this.papier = 500;
        this.inOrdnung = true;
    }

    public Kopierer(int blattanzahl) {
        this.papier = blattanzahl;
        this.inOrdnung = true;
    }

    // getters and setters
    public int getPapier() {
        return papier;
    }

    public void setPapier(int papier) {
        if (papier <= 1000)
            this.papier = papier;
    }

    public boolean isInOrdnung() {
        return inOrdnung;
    }

    public void setInOrdnung(boolean inOrdnung) {
        this.inOrdnung = inOrdnung;
    }

    // methods
    public void kopieren(int anzahl) {
        int papierNeu = this.papier - anzahl;
        if (papierNeu >= 0)
            this.papier = papierNeu;
    }

    public int papierNachfuellen(int blatt) {
        int papierNeu = this.papier + blatt;
        if (papierNeu <= 1000) {
            this.papier = papierNeu;
            return blatt;
        } else {
            this.papier = 1000;
            return 1000 - (papierNeu - blatt);
        }
    }
}
