/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.taller1.controller;

import co.edu.udistrital.taller1.model.Candidato;

/**
 *
 * @author crisc
 */
public class Controller {
    private ControllerVista controllerVista;
    private ControllerDirectorio controllerDirectorio;

    public Controller() {
        this.controllerVista = new ControllerVista(this);
        this.controllerDirectorio = new ControllerDirectorio(System.currentTimeMillis()); // Semilla basada en tiempo
    }

    public void generarElementos(int N, int M) {
        try {
            // Obtener la distribución seleccionada por el usuario
            String distribucion = controllerVista.obtenerDistribucion();

            controllerVista.getVentanaPrincipal()
                    .mostrarMensaje("Generando " + N + " candidatos con " + M
                            + " elementos cada uno usando distribución: " + distribucion);

            controllerDirectorio.limpiarDirectorio();
            controllerDirectorio.generarPoblacion(N, M, distribucion);
            controllerVista.getVentanaPrincipal().mostrarMensaje("Generación completada. Total candidatos: " +
                    controllerDirectorio.obtenerTamañoDirectorio());

            for (Candidato c : controllerDirectorio.getDirectorio().getCandidatos()) {
                System.out.println(c);
            }

        } catch (Exception e) {
            controllerVista.getVentanaPrincipal().mostrarMensaje("Error al generar elementos: " + e.getMessage());
        }
    }

    public void ordenarElementos() {
        try {
            controllerVista.getVentanaPrincipal().mostrarMensaje("Candidatos ordenados correctamente.");

        } catch (Exception e) {
            controllerVista.getVentanaPrincipal().mostrarMensaje("Error al ordenar elementos: " + e.getMessage());
        }
    }

    /**
     * Obtiene el controlador del directorio
     * 
     * @return ControllerDirectorio
     */
    public ControllerDirectorio getControllerDirectorio() {
        return controllerDirectorio;
    }
}
