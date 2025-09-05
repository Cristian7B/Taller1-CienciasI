/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.taller1.controller;

import java.util.ArrayList;
import java.util.Random;

import co.edu.udistrital.taller1.model.Candidato;

/**
 *
 * @author crisc
 */
public class ControllerDirectorio {
    
    private final Random random;

    public ControllerDirectorio(long semilla) {
        this.random = new Random(semilla);
    }

    public Candidato generarCandidato(int id, int m) {
        Candidato candidato = new Candidato(id, m);

        for (int i = 0; i < m; i++) {
            candidato.agregarMarcha("Marcha " + i, random.nextInt(m) + 1);
            candidato.agregarHoras("Bloqueo " + i, random.nextInt(m) + 1);
            candidato.agregarPrebenda("Prebenda " + i, random.nextInt(m) + 1);
            candidato.agregarSoborno("Soborno " + i, random.nextInt(m) + 1);
            candidato.agregarCorrupcion("Corrupción " + i, random.nextInt(m) + 1);
        }

        return candidato;
    }

    public ArrayList<Candidato> generarPoblacion(int n, int m) {
        ArrayList<Candidato> poblacion = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            poblacion.add(generarCandidato(i, m));
        }
        return poblacion;
    }

}
