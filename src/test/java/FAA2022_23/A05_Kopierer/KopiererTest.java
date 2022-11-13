package FAA2022_23.A05_Kopierer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KopiererTest {

    @Test
    void setPapier() {
        Kopierer k0 = new Kopierer(500);
        Kopierer k1 = new Kopierer(500);

        k0.setPapier(1000);
        k1.setPapier(1001);

        assertAll(
                () -> assertEquals(1000, k0.getPapier()),
                () -> assertEquals(500, k1.getPapier())
        );
    }

    @Test
    void kopieren() {
        Kopierer k0 = new Kopierer(500);
        Kopierer k1 = new Kopierer(500);

        k0.kopieren(500);
        k1.kopieren(501);

        assertAll(
                () -> assertEquals(0, k0.getPapier()),
                () -> assertEquals(500, k1.getPapier())
        );
    }

    @Test
    void papierNachfuellen() {
        Kopierer k0 = new Kopierer(500);
        Kopierer k1 = new Kopierer(500);

        assertAll(
                () -> assertEquals(500, k0.papierNachfuellen(500)),
                () -> assertEquals(1000, k0.getPapier()),
                () -> assertEquals(500, k1.papierNachfuellen(750)),
                () -> assertEquals(1000, k1.getPapier())
        );
    }
}