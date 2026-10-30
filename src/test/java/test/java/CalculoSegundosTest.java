package test.java;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import gt.edu.umes.proy.calculo.LogicaDelNegocio;

public class CalculoSegundosTest {

    @Test
    void validarParametroIncorrecto() {
        LogicaDelNegocio logica = new LogicaDelNegocio();

        String[] datos = {"1", "3", "hola", "20", "1"};

        assertThrows(IllegalArgumentException.class,
            () -> logica.calcularSegundos(datos));
    }

    @Test
    void validarCalculoSegundos() {
        LogicaDelNegocio logica = new LogicaDelNegocio();

        String[] datos = {"1", "3", "6", "20", "1"};

        long esperado = 4996860L;

        assertEquals(esperado, logica.calcularSegundos(datos));
    }
}
