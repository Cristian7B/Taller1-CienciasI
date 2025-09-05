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

    private Directorio directorio;
    private ControllerCandidato controllerCandidato;

    public ControllerDirectorio(long semilla) {
        this.directorio = new Directorio();
        this.controllerCandidato = new ControllerCandidato(semilla);
    }

    /**
     * Genera una población de candidatos y los agrega al directorio
     * 
     * @param n Número de candidatos a generar
     * @param m Número de elementos por categoría
     */
    public void generarPoblacion(int n, int m) {
        ArrayList<Candidato> candidatos = controllerCandidato.generarPoblacionCandidatos(n, m);
        directorio.agregarCandidatos(candidatos);
    }

    /**
     * Agrega un candidato individual al directorio
     * 
     * @param id ID del candidato
     * @param m  Número de elementos por categoría
     */
    public void agregarCandidato(int id, int m) {
        Candidato candidato = controllerCandidato.generarCandidato(id, m);
        directorio.agregarCandidato(candidato);
    }

    /**
     * Ordena los candidatos en el directorio según el comparador dado
     * 
     * @param comparador Criterio de ordenamiento
     */
    public void ordenarCandidatos() {
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
}
