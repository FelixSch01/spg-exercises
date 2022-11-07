package FAA2022_23.A03_Beamer;

public class Beamer {
    // properties
    private boolean eingeschaltet;
    private String raum;
    private double restzeit; // in h

    // getters and setters
    public boolean isEingeschaltet() {
        return eingeschaltet;
    }

    public String getRaum() {
        return raum;
    }

    public void setRaum(String raum) {
        this.raum = raum;
    }

    public double getRestzeit() {
        return restzeit;
    }

    public void setRestzeit(double restzeit) {
        this.restzeit = restzeit;
    }

    // methods
    public void einschalten() {
        if (!eingeschaltet) {
            eingeschaltet = !eingeschaltet;
            restzeit--;
        }
    }

    public void ausschalten() {
        if (eingeschaltet)
            eingeschaltet = !eingeschaltet;
    }

    public void reparieren() {
        double adjusted_restzeit = restzeit + 50;
        if (adjusted_restzeit < 1000.0)
            restzeit = adjusted_restzeit;
    }

    public void runterwerfen() {
        restzeit = 0;
    }

    public String toString() {
        return String.format("""
                Eingeschaltet: %s
                Raum:          %s
                Restzeit:      %b
                """, eingeschaltet, raum, restzeit);
    }
}
