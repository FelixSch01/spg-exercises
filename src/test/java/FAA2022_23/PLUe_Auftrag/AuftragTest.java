package FAA2022_23.PLUe_Auftrag;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AuftragTest {
    @Test
    @DisplayName("Test setZiel")
    public void testSetZiel() {
        Auftrag a1 = new Auftrag();
        Auftrag a2 = new Auftrag();
        Auftrag a3 = new Auftrag();

        a1.setZiel("test");
        a2.setZiel(null);
        a3.setZiel("");

        assertAll(() -> assertEquals("test", a1.getZiel()),
                () -> assertEquals("nicht bekannt", a2.getZiel()),
                () -> assertEquals("", a3.getZiel()));


    }



}