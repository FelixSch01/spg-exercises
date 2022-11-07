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
        if (raum != null && raum.length() > 0)
            this.raum = raum;
    }

    public double getRestzeit() {
        return restzeit;
    }

    public void setRestzeit(double restzeit) {
        double adjusted_restzeit = this.restzeit + restzeit;
        if (adjusted_restzeit <= 1000.0 && adjusted_restzeit > 0)
            this.restzeit = adjusted_restzeit;
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
        setRestzeit(restzeit + 50);
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
