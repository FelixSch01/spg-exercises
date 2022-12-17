package at.spengergasse.ensurer;

// Utility Class
public abstract class Ensurer // abstract sorgt dafür, dass man es nicht instanzieren kann
{
    // Instanzattribut - Kann nicht in der Klassenmethode aufgerufen werden
    // Methode ohne static ist eine Instanzmethode
    private String name;

    // Klassenattribut
    private static String name2;

    // Pure functions
    //      Verändern nichts. Sie bekommen nur einen Wert, machen was damit und geben ihn wieder zurück

    // Klassenmethode
    // utility method
   // public static String ensureNotNullNotBlank(String str, String defaultValue)
   // {
   //     // guard statements
   //     if (str == null)
   //     {
   //         System.out.println("Fehler: String ist null");
   //         return defaultValue;
   //     }

   //     // guard statements
   //     if (str.isBlank())
   //     {
   //         System.out.println("Fehler: String ist blank");
   //         return defaultValue;
   //     }

   //     return str;
   // }

    /**
     * ensures that vlaue is not null not blank
     *
     * @throws IllegalArgumentException if value is null or blank
     * @return value otherwise
     */
    public static String ensureNotNullNotBlank(String value, String paramName) {
        

        if (value == null)
            throw new IllegalArgumentException(String.format("%s was null", paramName));

        if (value.isBlank())
            throw new IllegalArgumentException(String.format("%s was null", paramName));

        return value;

        // not null
        // not blank
        // if not throw IllegalArgumentException
    }
    
    public static <T> T ensureNotNull(T value, String paramName) throws IllegalArgumentException
    {
        if (value == null)
            throw new IllegalArgumentException(String.format("%s was null", paramName));
        return value;
    }

//    public static String ensureNotNull(String value, String paramName) throws IllegalArgumentException
//    {
//        if (value == null)
//            throw new IllegalArgumentException(String.format("%s was null", paramName));
//        return value;
//    }

    // T stands for any reference type so it can not only check for strings
}
