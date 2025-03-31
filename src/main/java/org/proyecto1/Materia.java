package org.proyecto1;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter

public class Materia {
    private String nombre;
    private Set <Materia> correlativas;

    public boolean cumpleCorrelativas(Set <Materia> materias) {
        return materias.containsAll(correlativas);
    }

}
