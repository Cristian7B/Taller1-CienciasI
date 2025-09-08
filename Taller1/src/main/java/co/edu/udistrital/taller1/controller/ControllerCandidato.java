/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.taller1.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import co.edu.udistrital.taller1.model.Candidato;

/**
 *
 * @author crisc
 */
public class ControllerCandidato {
    /**
     * Atributo para generar números aleatorios
     */
    private final Random random;
    /**
     * Atributo para ordenar candidatos
     */
    private final Ordenador ordenador;

    public ControllerCandidato(long semilla) {
        this.random = new Random(semilla);
        this.ordenador = new Ordenador();
    }

    /**
     * Genera un candidato individual con datos según la distribución especificada
     * 
     * @param id           El ID del candidato
     * @param m            El número de elementos por cada categoría
     * @param distribucion Tipo de distribución: "uniforme", "casi_ordenada",
     *                     "inverso"
     * @return Un nuevo candidato con datos generados según la distribución
     */
    public Candidato generarCandidato(int id, int m, String distribucion) {
        Candidato candidato = new Candidato(id, m);

        ArrayList<Integer> valoresMarchas = generarValoresSegunDistribucion(m, distribucion);
        ArrayList<Integer> valoresHoras = generarValoresSegunDistribucion(m, distribucion);
        ArrayList<Integer> valoresPrebendas = generarValoresSegunDistribucion(m, distribucion);
        ArrayList<Integer> valoresSobornos = generarValoresSegunDistribucion(m, distribucion);
        ArrayList<Integer> valoresCorrupcion = generarValoresSegunDistribucion(m, distribucion);

        for (int i = 0; i < m; i++) {
            candidato.agregarMarcha("Marcha " + i, valoresMarchas.get(i));
            candidato.agregarHoras("Bloqueo " + i, valoresHoras.get(i));
            candidato.agregarPrebenda("Prebenda " + i, valoresPrebendas.get(i));
            candidato.agregarSoborno("Soborno " + i, valoresSobornos.get(i));
            candidato.agregarCorrupcion("Corrupción " + i, valoresCorrupcion.get(i));
        }

        return candidato;
    }

    /**
     * Genera valores según el tipo de distribución especificado
     * 
     * @param m            El número de elementos a generar
     * @param distribucion Tipo de distribución
     * @return Lista de valores generados
     */
    private ArrayList<Integer> generarValoresSegunDistribucion(int m, String distribucion) {
        ArrayList<Integer> valores = new ArrayList<>();

        valores = switch (distribucion) {
            case "Aleatoria" -> generarDistribucionUniforme(m);
            case "Casi ordenada" -> generarDistribucionCasiOrdenada(m);
            case "Inversa" -> generarDistribucionInversa(m);
            default -> generarDistribucionUniforme(m);
        };
        return valores;
    }

    /**
     * Genera una distribución uniforme (completamente aleatoria)
     * 
     * @param m Número de elementos
     * @return Lista con valores aleatorios
     */
    private ArrayList<Integer> generarDistribucionUniforme(int m) {
        ArrayList<Integer> valores = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            valores.add(random.nextInt(m) + 1);
        }
        return valores;
    }

    /**
     * Genera una distribución casi ordenada (mayormente ordenada con algunas
     * inversiones)
     * 
     * @param m Número de elementos
     * @return Lista con valores casi ordenados
     */
    private ArrayList<Integer> generarDistribucionCasiOrdenada(int m) {
        ArrayList<Integer> valores = new ArrayList<>();

        for (int i = 1; i <= m; i++) {
            valores.add(i);
        }
        int numInversiones = Math.max(1, m / 10 + random.nextInt(m / 5));

        for (int i = 0; i < numInversiones; i++) {
            int pos1 = random.nextInt(m);
            int pos2 = random.nextInt(m);

            Collections.swap(valores, pos1, pos2);
        }

        return valores;
    }

    public void resetContadores() {
        ordenador.resetContadores();
    }

    /**
     * Genera una distribución en orden inverso (descendente)
     * 
     * @param m Número de elementos
     * @return Lista con valores en orden descendente
     */
    private ArrayList<Integer> generarDistribucionInversa(int m) {
        ArrayList<Integer> valores = new ArrayList<>();

        for (int i = m; i >= 1; i--) {
            valores.add(i);
        }

        return valores;
    }

    /**
     * Genera una población de candidatos
     * 
     * @param n            Número de candidatos a generar
     * @param m            Número de elementos por categoría para cada candidato
     * @param distribucion Tipo de distribución para los valores
     * @return Lista de candidatos generados
     */
    public ArrayList<Candidato> generarPoblacionCandidatos(int n, int m, String distribucion) {
        ArrayList<Candidato> poblacion = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            poblacion.add(generarCandidato(i, m, distribucion));
        }
        return poblacion;
    }

    /**
     * Genera una población de candidatos (versión de compatibilidad - usa
     * distribución uniforme)
     * 
     * @param n Número de candidatos a generar
     * @param m Número de elementos por categoría para cada candidato
     * @return Lista de candidatos generados
     */
    public ArrayList<Candidato> generarPoblacionCandidatos(int n, int m) {
        return generarPoblacionCandidatos(n, m, "uniforme");
    }

    /**
     * Ordena una lista de candidatos usando el algoritmo de burbuja
     * 
     * @param candidatos Lista de candidatos a ordenar
     */
    public double ordenarBurbuja(ArrayList<Candidato> candidatos) {
        long inicio = System.nanoTime();

        ordenador.burbujaCorrupcion(candidatos);
        ordenador.BurbujaMarchas(candidatos);
        ordenador.BurbujaHorasClase(candidatos);
        ordenador.BurbujaPrebendas(candidatos);
        ordenador.BurbujaSobornos(candidatos);

        ordenador.ordenarCandidatosBurbuja(candidatos);
        long fin = System.nanoTime();
        System.out.println("Tiempo de burbuja: " + (fin - inicio) / 1_000_000.0 + " ms");
        return (fin - inicio) / 1_000_000.0; // retorna el tiempo en ms
    }

    /**
     * Ordena una lista de candidatos usando el algoritmo de selección
     * 
     * @param candidatos Lista de candidatos a ordenar
     */

    public double ordenarSeleccion(ArrayList<Candidato> candidatos) {
        long inicio = System.nanoTime();

        ordenador.seleccionCorrupcion(candidatos);
        ordenador.seleccionMarchas(candidatos);
        ordenador.seleccionHorasClase(candidatos);
        ordenador.seleccionPrebendas(candidatos);
        ordenador.seleccionSobornos(candidatos);

        ordenador.ordenarCandidatosSeleccion(candidatos);
        long fin = System.nanoTime();
        return (fin - inicio) / 1_000_000.0; // retorna el tiempo en ms

    }

    /**
     * Ordena una lista de candidatos usando el algoritmo de inserción
     * 
     * @param candidatos Lista de candidatos a ordenar
     */
    public double ordenarInsercion(ArrayList<Candidato> candidatos) {
        long inicio = System.nanoTime();

        ordenador.insercionCorrupcion(candidatos);
        ordenador.insercionMarchas(candidatos);
        ordenador.insercionHorasClase(candidatos);
        ordenador.insercionPrebendas(candidatos);
        ordenador.insercionSobornos(candidatos);

        ordenador.ordenarCandidatosInsercion(candidatos);
        long fin = System.nanoTime();
        return (fin - inicio) / 1_000_000.0; // retorna el tiempo en ms
    }

    /**
     * Ordena una lista de candidatos usando el algoritmo Merge Sort
     * 
     * @param candidatos Lista de candidatos a ordenar
     */

    public double ordenarMergeSort(ArrayList<Candidato> candidatos) {
        long inicio = System.nanoTime();

        ordenador.mergeSortcorrupcion(candidatos);
        ordenador.mergeSortHorasClase(candidatos);
        ordenador.mergeSortMarchas(candidatos);
        ordenador.mergeSortPrebendas(candidatos);
        ordenador.mergeSortSobornos(candidatos);

        ordenador.ordenarCandidatosMergeSort(candidatos);
        long fin = System.nanoTime();
        return (fin - inicio) / 1_000_000.0; // retorna el tiempo en ms

    }

    /**
     * Ordena una lista de candidatos usando el algoritmo Quick Sort
     * 
     * @param candidatos Lista de candidatos a ordenar
     */
    public double ordenarQuickSort(ArrayList<Candidato> candidatos) {
        long inicio = System.nanoTime();

        ordenador.quicksortCorrupcion(candidatos);
        ordenador.quicksortHorasClase(candidatos);
        ordenador.quicksortMarchas(candidatos);
        ordenador.quicksortPrebendas(candidatos);
        ordenador.quicksortSobornos(candidatos);

        ordenador.ordenarCandidatosQuickSort(candidatos);
        long fin = System.nanoTime();
        return (fin - inicio) / 1_000_000.0; // retorna el tiempo en ms

    }

    /*
     * * Getters para comparaciones e intercambios
     */
    public long getComparaciones() {
        return ordenador.getComparaciones();
    }

    public long getIntercambios() {
        return ordenador.getIntercambios();
    }

}
