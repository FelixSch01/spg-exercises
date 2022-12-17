package FAA2022_23.Uebungen_22_11_19;

public class Ensurer {
    // Utility method: Should be static
    public static String ensureNotNullNotBlank(String str, String defaultValue) {
        if(str == null) {
            // throw new IllegalArgumentException("..");
            System.out.println("Fehler: String ist null");
            return defaultValue;
        }
        if(str.isBlank()) {
            // throw new IllegalArgumentException("..");
            System.out.println("Fehler: String ist blank");
            return defaultValue;
        }
        return str;
    }
}
