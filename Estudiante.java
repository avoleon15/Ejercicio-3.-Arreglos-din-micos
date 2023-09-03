//ALVARO JOSE LEON AGUILAR 23274
//CLAES ESTUDIANTE

import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private int carnet;
    private List<Curso> cursos = new ArrayList<>();

    public Estudiante(String nombre, int carnet) {
        this.nombre = nombre;
        this.carnet = carnet;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCarnet() {
        return carnet;
    }

    public void setCurso(Curso curso) {
        cursos.add(curso);
    }

    public int getCantidadCursos() {
        return cursos.size();
    }

    public float getPromedio() {
        if (cursos.isEmpty()) {
            return 0.0f;
        }
        float suma = 0;
        for (Curso curso : cursos) {
            suma += curso.getNota();
        }
        return suma / cursos.size();
    }
}
