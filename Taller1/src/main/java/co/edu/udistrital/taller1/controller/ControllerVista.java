package co.edu.udistrital.taller1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.udistrital.taller1.view.VentanaPrincipal;

public class ControllerVista implements ActionListener{
    private Controller controller;
    private VentanaPrincipal ventanaPrincipal;

    public ControllerVista(Controller controller) {
        this.controller = controller;
        this.ventanaPrincipal = new VentanaPrincipal(this);
        ventanaPrincipal.setVisible(true);
    }

    public void asignarOyentes() {
        ventanaPrincipal.getBtnEjecutar().addActionListener(this);
        ventanaPrincipal.getBtnEjecutar().setActionCommand("Generar y Ordenar");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("Generar y Ordenar")) {
            ventanaPrincipal.mostrarMensaje("Generando y ordenando elementos...");
            controller.generarElementos(obtenerN(), obtenerM());
            controller.ordenarElementos();
        }
    }

    public int obtenerN() {
        try {
            return Integer.parseInt(ventanaPrincipal.getN());
        } catch (NumberFormatException e) {
            ventanaPrincipal.mostrarMensaje("Por favor, ingrese un número válido.");
        }
        return 0;
    }

    public int obtenerM() {
        try {
            return Integer.parseInt(ventanaPrincipal.getM());
        } catch (NumberFormatException e) {
            ventanaPrincipal.mostrarMensaje("Por favor, ingrese un número válido.");
        }
        return 0;
    }

    public String obtenerAlgoritmo() {
        return ventanaPrincipal.getAlgoritmo();
    }

    public String obtenerDistribucion() {
        return ventanaPrincipal.getDistribucion();
    }

    public VentanaPrincipal getVentanaPrincipal() {
        return ventanaPrincipal;
    }

    public Controller getController() {
        return controller;
    }


}
