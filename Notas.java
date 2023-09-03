//ALVARO JOSE LEON AGUILAR 23274
//CLAES NOTAS

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Notas {
    private List<Float> notas = new ArrayList<>();
    private float promedio;
    private float mediana;
    private List<Float> moda = new ArrayList<>();
    private float desviacionEstandar;
    private float notaMasBaja;
    private float notaMasAlta;

    public void agregarNota(float nota) {
        notas.add(nota);
    }

    public void calcularPromedio() {
        if (!notas.isEmpty()) {
            float suma = 0;
            for (float nota : notas) {
                suma += nota;
            }
            promedio = suma / notas.size();
        } else {
            promedio = 0;
        }
    }

    public void calcularMediana() {
        if (!notas.isEmpty()) {
            List<Float> copiaNotas = new ArrayList<>(notas);
            Collections.sort(copiaNotas);
            int tamaño = copiaNotas.size();
            if (tamaño % 2 == 0) {
                mediana = (copiaNotas.get(tamaño / 2 - 1) + copiaNotas.get(tamaño / 2)) / 2.0f;
            } else {
                mediana = copiaNotas.get(tamaño / 2);
            }
        } else {
            mediana = 0;
        }
    }

    public void calcularModa() {
        if (!notas.isEmpty()) {
            Map<Float, Integer> frecuencias = new HashMap<>();
            int maxFrecuencia = 0;
            for (float nota : notas) {
                int frecuencia = frecuencias.getOrDefault(nota, 0) + 1;
                frecuencias.put(nota, frecuencia);
                if (frecuencia > maxFrecuencia) {
                    maxFrecuencia = frecuencia;
                    moda.clear();
                    moda.add(nota);
                } else if (frecuencia == maxFrecuencia && !moda.contains(nota)) {
                    moda.add(nota);
                }
            }
        }
    }

    public void calcularDesviacionEstandar() {
        if (!notas.isEmpty()) {
            float sumaDiferenciasCuadradas = 0;
            for (float nota : notas) {
                sumaDiferenciasCuadradas += Math.pow(nota - promedio, 2);
            }
            float varianza = sumaDiferenciasCuadradas / notas.size();
            desviacionEstandar = (float) Math.sqrt(varianza);
        } else {
            desviacionEstandar = 0;
        }
    }

    public void calcularNotaMasBaja() {
        if (!notas.isEmpty()) {
            notaMasBaja = Collections.min(notas);
        } else {
            notaMasBaja = 0;
        }
    }

    public void calcularNotaMasAlta() {
        if (!notas.isEmpty()) {
            notaMasAlta = Collections.max(notas);
        } else {
            notaMasAlta = 0;
        }
    }

    public void ejecutarMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenú de Notas:");
            System.out.println("1. Ingresar Nota");
            System.out.println("2. Consultar Cálculos Estadísticos");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la sede: ");
                    String sede = scanner.nextLine();
                    System.out.print("Ingrese el nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Ingrese la materia: ");
                    String materia = scanner.nextLine();
                    System.out.print("Ingrese la calificación: ");
                    float calificacion = scanner.nextFloat();
                    
                    agregarNota(calificacion);
                    break;
                case 2:
                    calcularPromedio();
                    calcularMediana();
                    calcularModa();
                    calcularDesviacionEstandar();
                    calcularNotaMasBaja();
                    calcularNotaMasAlta();

                    System.out.println("\nCálculos Estadísticos:");
                    System.out.println("Promedio: " + promedio);
                    System.out.println("Mediana: " + mediana);
                    System.out.println("Moda: " + moda);
                    System.out.println("Desviación Estándar: " + desviacionEstandar);
                    System.out.println("Nota Más Baja: " + notaMasBaja);
                    System.out.println("Nota Más Alta: " + notaMasAlta);
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        Notas notas = new Notas();
        notas.ejecutarMenu();
    }
}
