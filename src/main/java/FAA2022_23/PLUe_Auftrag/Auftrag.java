package FAA2022_23.PLUe_Auftrag;

public class Auftrag {
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
