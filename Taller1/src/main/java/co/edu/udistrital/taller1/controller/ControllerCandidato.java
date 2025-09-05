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

    

    private final Random random;
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

        // Generar valores para cada atributo según la distribución
        ArrayList<Integer> valoresMarchas = generarValoresSegunDistribucion(m, distribucion);
        ArrayList<Integer> valoresHoras = generarValoresSegunDistribucion(m, distribucion);
        ArrayList<Integer> valoresPrebendas = generarValoresSegunDistribucion(m, distribucion);
        ArrayList<Integer> valoresSobornos = generarValoresSegunDistribucion(m, distribucion);
        ArrayList<Integer> valoresCorrupcion = generarValoresSegunDistribucion(m, distribucion);

        // Agregar los valores al candidato
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

        switch (distribucion) {
            case "Aleatoria":
                valores = generarDistribucionUniforme(m);
                break;
            case "Casi ordenada":
                valores = generarDistribucionCasiOrdenada(m);
                break;
            case "Inversa":
                valores = generarDistribucionInversa(m);
                break;
            default:
                valores = generarDistribucionUniforme(m);
                break;
        }

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

        // Crear una secuencia ordenada
        for (int i = 1; i <= m; i++) {
            valores.add(i);
        }

        // Hacer algunas inversiones aleatorias (aproximadamente 10-20% del total)
        int numInversiones = Math.max(1, m / 10 + random.nextInt(m / 5));

        for (int i = 0; i < numInversiones; i++) {
            int pos1 = random.nextInt(m);
            int pos2 = random.nextInt(m);

            // Intercambiar elementos
            Collections.swap(valores, pos1, pos2);
        }

        return valores;
    }

    /**
     * Genera una distribución en orden inverso (descendente)
     * 
     * @param m Número de elementos
     * @return Lista con valores en orden descendente
     */
    private ArrayList<Integer> generarDistribucionInversa(int m) {
        ArrayList<Integer> valores = new ArrayList<>();

        // Crear secuencia en orden descendente
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
}
