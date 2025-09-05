/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.taller1.controller;

import java.util.ArrayList;

import co.edu.udistrital.taller1.model.Candidato;
import co.edu.udistrital.taller1.model.Directorio;

/**
 *
 * @author crisc
 */
public class ControllerDirectorio {

    private final Directorio directorio;
    private final ControllerCandidato controllerCandidato;

    public ControllerDirectorio(long semilla) {
        this.directorio = new Directorio();
        this.controllerCandidato = new ControllerCandidato(semilla);
    }

    /**
     * Genera una población de candidatos y los agrega al directorio
     * 
     * @param n            Número de candidatos a generar
     * @param m            Número de elementos por categoría
     * @param distribucion Tipo de distribución para los valores
     */
    public void generarPoblacion(int n, int m, String distribucion) {
        ArrayList<Candidato> candidatos = controllerCandidato.generarPoblacionCandidatos(n, m, distribucion);
        directorio.agregarCandidatos(candidatos);
    }

    /**
     * Genera una población de candidatos y los agrega al directorio (versión de
     * compatibilidad)
     * 
     * @param n Número de candidatos a generar
     * @param m Número de elementos por categoría
     */
    public void generarPoblacion(int n, int m) {
        generarPoblacion(n, m, "uniforme");
    }

    /**
     * Agrega un candidato individual al directorio
     * 
     * @param id           ID del candidato
     * @param m            Número de elementos por categoría
     * @param distribucion Tipo de distribución para los valores
     */
    public void agregarCandidato(int id, int m, String distribucion) {
        Candidato candidato = controllerCandidato.generarCandidato(id, m, distribucion);
        directorio.agregarCandidato(candidato);
    }

    /**
     * Agrega un candidato individual al directorio (versión de compatibilidad)
     * 
     * @param id ID del candidato
     * @param m  Número de elementos por categoría
     */
    public void agregarCandidato(int id, int m) {
        agregarCandidato(id, m, "uniforme");
    }

    /**
     * Ordena los candidatos en el directorio según el comparador dado
     * 
     * @param comparador Criterio de ordenamiento
     */
    public double ordenarCandidatos(String comparador) {
        double tiempo = 0;

        switch (comparador.toLowerCase()) {
            case "burbuja" -> tiempo = controllerCandidato.ordenarBurbuja(directorio.getCandidatos());
            case "seleccion" -> tiempo = controllerCandidato.ordenarSeleccion(directorio.getCandidatos());
            case "insercion" -> tiempo = controllerCandidato.ordenarInsercion(directorio.getCandidatos());
            case "mergesort" -> tiempo = controllerCandidato.ordenarMergeSort(directorio.getCandidatos());
            case "quicksort" -> tiempo = controllerCandidato.ordenarQuickSort(directorio.getCandidatos());
            default -> throw new IllegalArgumentException("Algoritmo de ordenamiento no reconocido: " + comparador);
        }
        return tiempo;
    }


    /**
     * Obtiene todos los candidatos del directorio
     * 
     * @return Lista de candidatos
     */
    public ArrayList<Candidato> obtenerCandidatos() {
        return directorio.getCandidatos();
    }

    /**
     * Obtiene el número de candidatos en el directorio
     * 
     * @return Número de candidatos
     */
    public int obtenerTamañoDirectorio() {
        return directorio.getTamaño();
    }

    /**
     * Limpia el directorio eliminando todos los candidatos
     */
    public void limpiarDirectorio() {
        directorio.limpiarDirectorio();
    }

    /**
     * Obtiene el directorio completo
     * 
     * @return El directorio
     */
    public Directorio getDirectorio() {
        return directorio;
    }

    /// Obtener el controlador de candidatos
    /// @return ControllerCandidato
    public ControllerCandidato getControllerCandidato() {
        return controllerCandidato;
    }
}
