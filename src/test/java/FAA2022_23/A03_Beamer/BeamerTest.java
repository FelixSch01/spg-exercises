package FAA2022_23.A03_Beamer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BeamerTest {

    @Test
    void setRestzeit() {
        Beamer b1 = new Beamer();
        Beamer b2 = new Beamer();
        Beamer b3 = new Beamer();

        b1.setRestzeit(1000.0);
        b2.setRestzeit(1000.1);
        b3.setRestzeit(-0.1);

        assertAll(
                () -> assertEquals(1000.0, b1.getRestzeit()),
                () -> assertEquals(0.0, b2.getRestzeit()),
                () -> assertEquals(0.0, b3.getRestzeit())
        );
    }

    @Test
    void reparieren() {
        Beamer b1 = new Beamer();
        Beamer b2 = new Beamer();

        b1.setRestzeit(1000.0);
        b1.reparieren();
        b2.reparieren();

        assertAll(
                () -> assertEquals(1000.0, b1.getRestzeit()),
                () -> assertEquals(50.0, b2.getRestzeit())
        );
    }

    @Test
    void runterwerfen() {
        Beamer b1 = new Beamer();
        Beamer b2 = new Beamer();

        b1.setRestzeit(1000.0);
        b1.runterwerfen();
        b2.runterwerfen();

        assertAll(
                () -> assertEquals(0.0, b1.getRestzeit()),
                () -> assertEquals(0.0, b2.getRestzeit())
        );
    }

    @Test
    void testToString() {
        Beamer b1 = new Beamer();

        b1.einschalten();
        b1.setRestzeit(500.0);
        b1.setRaum("Test");

        String expected = """
                Eingeschaltet: true
                Raum:          Test
                Restzeit:      500.000000
                """;

        assertEquals(expected, b1.toString());
    }
}