package org.proyecto1;

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter

public class Inscripcion {
    private Set <Materia> materiasACursar;
    private boolean fueAprobada;
    private Alumno alumno;
    private LocalDateTime fechaDeEvaluacion;

    public boolean fueAprobada() {
        boolean resultado =  materiasACursar.
                stream().
                allMatch(m -> m.cumpleCorrelativas(alumno.getMateriasAprobadas()));
        fueAprobada = resultado;
        return resultado;

    }


}