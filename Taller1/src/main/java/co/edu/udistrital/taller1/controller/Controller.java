/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.taller1.controller;

/**
 *
 * @author crisc
 */
public class Controller {
    private final ControllerVista controllerVista;
    private final ControllerDirectorio controllerDirectorio;

    public Controller() {
        this.controllerVista = new ControllerVista(this);
        this.controllerDirectorio = new ControllerDirectorio(System.currentTimeMillis()); // Semilla basada en tiempo
    }

    
    /**
     * Genera elementos (candidatos) en el directorio según los parámetros
     * especificados
     * 
     * @param N Número de candidatos a generar
     * @param M Número de elementos por candidato
     */
    public void generarElementos(int N, int M) {
        try {
            String distribucion = controllerVista.obtenerDistribucion();

            controllerVista.getVentanaPrincipal()
                    .mostrarMensaje("Generando " + N + " candidatos con " + M
                            + " elementos cada uno usando distribución: " + distribucion);

            controllerDirectorio.limpiarDirectorio();
            controllerDirectorio.generarPoblacion(N, M, distribucion);
            controllerVista.getVentanaPrincipal().mostrarMensaje("Generación completada. Total candidatos: " +
                controllerDirectorio.obtenerTamañoDirectorio());

        } catch (Exception e) {
            controllerVista.getVentanaPrincipal().mostrarMensaje("Error al generar elementos: " + e.getMessage());
        }
    }

    /**
     * Ordena los elementos en el directorio usando el algoritmo especificado
     * 
     * @param algoritmo El nombre del algoritmo de ordenamiento a usar
     * @return El tiempo tomado para ordenar en milisegundos, o -1 si hubo un error
     */
    public double ordenarElementos(String algoritmo) {
        try {
            double tiempo = controllerDirectorio.ordenarCandidatos(algoritmo);
            controllerVista.getVentanaPrincipal().mostrarMensaje("Candidatos ordenados correctamente. usando: " + algoritmo );
            return tiempo;

        } catch (Exception e) {
            controllerVista.getVentanaPrincipal().mostrarMensaje("Error al ordenar elementos: " + e.getMessage());
        }
        return -1;
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
