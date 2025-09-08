package co.edu.udistrital.taller1.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import co.edu.udistrital.taller1.view.VentanaPrincipal;
/**
 *
 * @author crisc
 */
public class ControllerVista implements ActionListener{
    /**
     * Atributo para usar el controlador principal
     */
    private final Controller controller;
    /**
     * Atributo para usar la ventana principal
     */
    private final VentanaPrincipal ventanaPrincipal;
    /**
     * Atributo para almacenar el tiempo de ejecución
     */
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

    
    /**
     * Maneja los eventos de los botones
     * @param e El evento generado
     */
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
                long intercambios = controller.getControllerDirectorio().getControllerCandidato().getIntercambios();
                String informacionGanador = controller.getControllerDirectorio().getDirectorio().getCandidatos().get(controller.getControllerDirectorio().getDirectorio().getCandidatos().size() - 1).getNombreCandidato();

                mostrarResultado(algoritmo, comparaciones, intercambios,  tiempo, informacionGanador);

                controller.getControllerDirectorio().getControllerCandidato().resetContadores();
            } else {
                ventanaPrincipal.mostrarMensaje("Por favor, ingrese valores válidos.");
            }
        }
    }


    /**
     * Muestra el resultado en la tabla y el ganador en un mensaje
     * @param algoritmo El algoritmo usado
     * @param comparaciones Número de comparaciones realizadas
     * @param intercambios Número de intercambios realizados
     * @param tiempo Tiempo de ejecución en milisegundos
     * @param informacionGanador Información del candidato ganador
     */
    public void mostrarResultado(String algoritmo, long comparaciones, long intercambios, double tiempo, String informacionGanador) {
        ventanaPrincipal.agregarResultado(algoritmo, comparaciones, intercambios, tiempo);
        ventanaPrincipal.mostrarGanador("El ganador al concurso de la ASO es: " + informacionGanador);
    }

    /**
     * Valida que los elementos N y M sean mayores a cero
     * @return true si ambos son mayores a cero, false en caso contrario
     */
    public boolean validarElementos() {
        return obtenerN() > 0 && obtenerM() > 0;
    }

    /**
     * Obtiene el valor de N desde la interfaz
     * @return El valor de N, o 0 si no es un número válido
     */
    public int obtenerN() {
        try {
            return Integer.parseInt(ventanaPrincipal.getN());
        } catch (NumberFormatException e) {}
        return 0;
    }

    /**
     * Obtiene el valor de M desde la interfaz
     * @return El valor de M, o 0 si no es un número válido
     */
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
