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

        assertAll(
                () -> assertEquals("test", a1.getZiel()),
                () -> assertEquals("nicht bekannt", a2.getZiel()),
                () -> assertEquals("", a3.getZiel())
        );
    }

    @Test
    @DisplayName("Test setKosten")
    public void testSetKosten() {
        Auftrag a1 = new Auftrag();
        Auftrag a2 = new Auftrag();
        Auftrag a3 = new Auftrag();

        a1.setKosten(50);
        a2.setKosten(0);
        a3.setKosten(-1);

        assertAll(
                () -> assertEquals(50, a1.getKosten()),
                () -> assertEquals(0, a2.getKosten()),
                () -> assertEquals(0, a3.getKosten())
        );
    }

    @Test
    @DisplayName("Test setVolumen")
    public void testSetVolumen() {
        Auftrag a1 = new Auftrag();
        Auftrag a2 = new Auftrag();
        Auftrag a3 = new Auftrag();
        Auftrag a4 = new Auftrag();

        a1.setVolumen(-1);
        a2.setVolumen(0);
        a3.setVolumen(10000);
        a4.setVolumen(10001);

        assertAll(
                () -> assertEquals(0, a1.getVolumen()),
                () -> assertEquals(0, a2.getVolumen()),
                () -> assertEquals(10000, a3.getVolumen()),
                () -> assertEquals(0, a4.getVolumen())
        );
    }

    @Test
    @DisplayName("Test provision()")
    public void testProvision() {
        Auftrag a1 = new Auftrag("Test", 420, false);
        Auftrag a2 = new Auftrag();

        assertAll(
                () -> assertEquals(84, a1.provision()),
                () -> assertEquals(0, a2.provision())
        );
    }

    @Test
    @DisplayName("Test gewinn")
    public void testGewinn() {
        Auftrag a1 = new Auftrag();
        Auftrag a2 = new Auftrag();
        Auftrag a3 = new Auftrag();

        a1.setErledigt(false);
        a1.setVolumen(500);
        a1.setKosten(200);

        a2.setErledigt(true);
        a2.setVolumen(500);
        a2.setKosten(200);
        a2.setZiel("Profit");

        a3.setErledigt(true);
        a3.setVolumen(500);
        a3.setKosten(0);

        assertAll(
                () -> assertEquals(0, a1.gewinn()),
                () -> assertEquals(200, a2.gewinn()),
                () -> assertEquals(500, a3.gewinn())
        );
    }

}