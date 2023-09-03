//ALVARO JOSE LEON AGUILAR 23274
//CLAES CURSO

public class Curso {
    private int nota;
    private String nombre;

    public Curso(String nombre, int nota) {
        this.nombre = nombre;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNota() {
        return nota;
    }
}
