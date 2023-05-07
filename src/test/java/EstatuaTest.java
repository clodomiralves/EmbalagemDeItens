import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import embalagens.Estatua;
import embalagens.ItemASerEmbaladoIF;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EstatuaTest {
    Estatua estatua;

    @BeforeEach
    void setUp() throws Exception {
        estatua = new Estatua("marmore", 50, 40, 3000);
    }

    @Test
    void testEstatua() {
        assertEquals("marmore", estatua.getMaterial());
        assertEquals(50, estatua.getBase());
        assertEquals(40, estatua.getAltura());
        assertEquals(3000, estatua.getPeso());

        try {
            Estatua outraEstatua = new Estatua("", 33, 22, 2334);
            fail("Deve lancar excecao");
        } catch (Exception e) {
            assertEquals("Material tem que ser informado", e.getMessage());
        }

        try {
            Estatua outraEstatua = new Estatua(null, 33, 22, 2334);
            fail("Deve lancar excecao");
        } catch (Exception e) {
            assertEquals("Material tem que ser informado", e.getMessage());
        }

        try {
            Estatua outraEstatua = new Estatua("vidro", 0, 22, 2334);
            fail("Deve lancar excecao");
        } catch (Exception e) {
            assertEquals("Base/altura tem que ser maior que zero", e.getMessage());
        }

        try {
            Estatua outraEstatua = new Estatua("vidro", 10, 0, 2334);
            fail("Deve lancar excecao");
        } catch (Exception e) {
            assertEquals("Base/altura tem que ser maior que zero", e.getMessage());
        }

        try {
            Estatua outraEstatua = new Estatua("vidro", -10, 22, 2334);
            fail("Deve lancar excecao");
        } catch (Exception e) {
            assertEquals("Base/altura tem que ser maior que zero", e.getMessage());
        }

        try {
            Estatua outraEstatua = new Estatua("vidro", 10, -10, 2334);
            fail("Deve lancar excecao");
        } catch (Exception e) {
            assertEquals("Base/altura tem que ser maior que zero", e.getMessage());
        }

        try {
            Estatua outraEstatua = new Estatua("vidro", 10, 22, 0);
            fail("Deve lancar excecao");
        } catch (Exception e) {
            assertEquals("Peso tem que ser maior que zero", e.getMessage());
        }

        try {
            Estatua outraEstatua = new Estatua("vidro", 10, 10, -23);
            fail("Deve lancar excecao");
        } catch (Exception e) {
            assertEquals("Peso tem que ser maior que zero", e.getMessage());
        }
    }

    @Test
    void testGetArea() {
        assertEquals(estatua.getBase() * estatua.getAltura() / 2, estatua.getArea());
    }

    @Test
    void testEqualsObject() throws Exception {
        Estatua outraEstatua = new Estatua("vidro", 50, 40, 3000);
        assertFalse(estatua.equals(outraEstatua));

        outraEstatua = new Estatua("marmore", 51, 40, 3000);
        assertFalse(estatua.equals(outraEstatua));

        outraEstatua = new Estatua("marmore", 50, 41, 3000);
        assertFalse(estatua.equals(outraEstatua));

        outraEstatua = new Estatua("marmore", 50, 40, 3001);
        assertFalse(estatua.equals(outraEstatua));

        outraEstatua = new Estatua("marmore", 50, 40, 3000);
        assertTrue(estatua.equals(outraEstatua));
    }

    @Test
    void testToString() {
        // dependendo da maquina substituir o . por ,
        // assertEquals("Estatua de marmore, com área 1000,0 e peso de 3000,0 gramas.",
        // estatua.toString());
        assertEquals("Estatua de marmore, com área 1000.0 e peso de 3000.0 gramas.", estatua.toString());
    }

    @Test
    void testImplementacaoDaInterface() {
        ItemASerEmbaladoIF item = estatua;
        assertEquals(3000, item.getPeso());
        assertEquals("marmore", item.getMaterial());
        assertEquals(1000, item.getArea());
    }

}
