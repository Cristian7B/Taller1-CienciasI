package co.edu.udistrital.taller1.model;

/**
 * Clase que representa un atributo con descripción y valor.
 * Sirve como clase base para otros atributos específicos.
 */
public class Atributo {
    /**
     * Descripción del atributo
     */
    private String descripcion;
    /**
     * Valor numérico del atributo
     */
    private int valor;

    public Atributo(String descripcion, int valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Atributo{" + "descripcion=" + descripcion + ", valor=" + valor + '}';
    }
}
