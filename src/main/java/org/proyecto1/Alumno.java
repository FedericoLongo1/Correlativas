package org.proyecto1;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter

public class Alumno{
    private String nombre;
    private String apellido;
    private Set<Materia> materiasAprobadas;
    private Inscripcion inscripcion;

    public void agregarMateriaAprobadas(Materia materia){
        this.materiasAprobadas.add(materia);
    }


}
