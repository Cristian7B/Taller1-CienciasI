/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.taller1.model;

/**
 * Atributo del candidato que usa la clase Atributo para heredar sus propiedades
 * @author crisc
 */
public class Sobornos extends Atributo{
    public Sobornos(String descripcion, int valor) {
        super(descripcion, valor);
    }

    public String getDescripcion() {
        return super.getDescripcion();
    }

    public void setDescripcion(String descripcion) {
        super.setDescripcion(descripcion);
    }

    public int getValor() {
        return super.getValor();
    }

    public void setValor(int valor) {
        super.setValor(valor);
    }

    @Override
    public String toString() {
        return "Sobornos{" +
                "descripcion='" + super.getDescripcion() + '\'' +
                ", valor='" + super.getValor() + '\'' +
                '}';
    }
}
