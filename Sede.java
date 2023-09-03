//ALVARO JOSE LEON AGUILAR 23274
//CLAES SEDE

import java.util.ArrayList;
import java.util.List;

public class Sede {
    private String campus;
    private List<Estudiante> estudiantes = new ArrayList<>();

    public Sede(String campus) {
        this.campus = campus;
    }

    public String getCampus() {
        return campus;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}
