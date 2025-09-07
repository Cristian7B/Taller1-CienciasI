package co.edu.udistrital.taller1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.udistrital.taller1.view.VentanaPrincipal;
/**
 *
 * @author crisc
 */
public class ControllerVista implements ActionListener{
    private final Controller controller;
    private final VentanaPrincipal ventanaPrincipal;
    private double tiempo;

    public ControllerVista(Controller controller) {
        this.controller = controller;
        this.ventanaPrincipal = new VentanaPrincipal(this);
        ventanaPrincipal.setVisible(true);
        asignarOyentes();
    }

    /**
     * Asigna los oyentes a los botones de la interfaz
     */
    public final void asignarOyentes() {
        ventanaPrincipal.getBtnEjecutar().addActionListener(this);
        ventanaPrincipal.getBtnEjecutar().setActionCommand("Generar y Ordenar");
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();
        if (comando.equals("Generar y Ordenar")) {
            if (validarElementos()) {
                String algoritmo = obtenerAlgoritmo();
                ventanaPrincipal.mostrarMensaje(obtenerDistribucion());
                controller.generarElementos(obtenerN(), obtenerM());
                tiempo = controller.ordenarElementos(algoritmo);
                long comparaciones = controller.getControllerDirectorio().getControllerCandidato().getComparaciones();
                Long intercambios = controller.getControllerDirectorio().getControllerCandidato().getIntercambios();
                mostrarResultado(algoritmo, comparaciones, intercambios, (long) tiempo);
            } else {
                ventanaPrincipal.mostrarMensaje("Por favor, ingrese valores válidos.");
            }
        }
    }

    public void mostrarResultado(String algoritmo, long comparaciones, long intercambios, long tiempo) {
    ventanaPrincipal.agregarResultado(algoritmo, comparaciones, intercambios, tiempo);
}

    public boolean validarElementos() {
        return obtenerN() > 0 && obtenerM() > 0;
    }

    public int obtenerN() {
        try {
            return Integer.parseInt(ventanaPrincipal.getN());
        } catch (NumberFormatException e) {}
        return 0;
    }

    public int obtenerM() {
        try {
            return Integer.parseInt(ventanaPrincipal.getM());
        } catch (NumberFormatException e) {}
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

    public double getTiempo() {
        return tiempo;
    }


}
