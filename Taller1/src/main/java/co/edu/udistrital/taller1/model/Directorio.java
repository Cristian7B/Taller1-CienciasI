/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.taller1.model;

import java.util.ArrayList;

/**
 *
 * @author crisc
 */
public class Directorio {
    /**
     * Lista de candidatos en el directorio
     */
    private final ArrayList<Candidato> candidatos;

    public Directorio() {
        this.candidatos = new ArrayList<>();
    }

    /**
     * Agrega un candidato al directorio
     * @param candidato Candidato a agregar
     */
    public void agregarCandidato(Candidato candidato) {
        candidatos.add(candidato);
    }

    /**
     * Agrega una lista de candidatos al directorio
     * @param nuevosCandidatos Lista de candidatos a agregar
     */
    public void agregarCandidatos(ArrayList<Candidato> nuevosCandidatos) {
        candidatos.addAll(nuevosCandidatos);
    }


    /**
     * Getters & Setters
     */
    public ArrayList<Candidato> getCandidatos() {
        return new ArrayList<>(candidatos);
    }

    public int getTamaño() {
        return candidatos.size();
    }

    public void limpiarDirectorio() {
        candidatos.clear();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Directorio con ").append(candidatos.size()).append(" candidatos:\n");
        for (Candidato candidato : candidatos) {
            sb.append(candidato.toString()).append("\n");
        }
        return sb.toString();
    }
}
