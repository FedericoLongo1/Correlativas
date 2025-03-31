package org.proyecto1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class InscripcionTest {

    @Test
    @DisplayName("Alumno tiene todas las correlativas y puede inscribirse a la materia")
    public void testInscripcion() {
        Alumno alumno = new Alumno();
        Materia ingles1 = new Materia();
        Materia analisisDeSistemas = new Materia();
        Materia disenioDeSistemas = new Materia();
        Inscripcion inscripcion = new Inscripcion();

        alumno.setNombre("Federico");
        alumno.setApellido("Longo");
        alumno.setMateriasAprobadas(Set.of(ingles1,analisisDeSistemas));

        ingles1.setNombre("ingles1");
        analisisDeSistemas.setNombre("analisisDeSistemas");
        disenioDeSistemas.setNombre("disenioDeSistemas");
        disenioDeSistemas.setCorrelativas(Set.of(ingles1, analisisDeSistemas));

        inscripcion.setAlumno(alumno);
        inscripcion.setMateriasACursar(Set.of(disenioDeSistemas));

       Assertions.assertTrue(inscripcion.fueAprobada());
    }

    @Test
    @DisplayName("Alumno no tiene todas las correlativas y no puede inscribirse a la materia")
    public void testInscripcionFallida() {
        Alumno alumno = new Alumno();
        Materia ingles1 = new Materia();
        Materia analisisDeSistemas = new Materia();
        Materia disenioDeSistemas = new Materia();
        Inscripcion inscripcion = new Inscripcion();

        alumno.setNombre("Federico");
        alumno.setApellido("Longo");
        alumno.setMateriasAprobadas(Set.of(analisisDeSistemas));

        ingles1.setNombre("ingles1");
        analisisDeSistemas.setNombre("analisisDeSistemas");
        disenioDeSistemas.setNombre("disenioDeSistemas");
        disenioDeSistemas.setCorrelativas(Set.of(ingles1, analisisDeSistemas));

        inscripcion.setAlumno(alumno);
        inscripcion.setMateriasACursar(Set.of(disenioDeSistemas));

        Assertions.assertFalse(inscripcion.fueAprobada());
    }

    @Test
    @DisplayName("No se asigna un alumno a la inscripcion, por lo que se genera una excepcion")
    public void testExcepcion() {
        Materia ingles1 = new Materia();
        Materia analisisDeSistemas = new Materia();
        Materia disenioDeSistemas = new Materia();
        Inscripcion inscripcion = new Inscripcion();


        ingles1.setNombre("ingles1");
        analisisDeSistemas.setNombre("analisisDeSistemas");
        disenioDeSistemas.setNombre("disenioDeSistemas");
        disenioDeSistemas.setCorrelativas(Set.of(ingles1, analisisDeSistemas));


        inscripcion.setMateriasACursar(Set.of(disenioDeSistemas));

        Assertions.assertThrows(NullPointerException.class, inscripcion::fueAprobada);
    }
}