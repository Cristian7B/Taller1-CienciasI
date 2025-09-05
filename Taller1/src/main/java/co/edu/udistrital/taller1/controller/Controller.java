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
    private ControllerVista controllerVista;

    public Controller() {
        this.controllerVista = new ControllerVista(this);
    }

    public void generarElementos(int N, int M) {
        String algoritmo = controllerVista.obtenerAlgoritmo();
        String distribucion = controllerVista.obtenerDistribucion();
        controllerVista.getVentanaPrincipal().mostrarMensaje("Generando elementos..." + N + " " + M + " " + algoritmo + " " + distribucion);
    }

    public void ordenarElementos() {
    }

}
