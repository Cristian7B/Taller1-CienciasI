/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.taller1.model;

/**
 * Atributo del candidato que usa la clase Atributo para heredar sus propiedades
 * @author crisc
 */
public class Marchas extends Atributo{
    public Marchas(String descripcion, int valor) {
        super(descripcion, valor);
    }

    @Override
    public String getDescripcion() {
        return super.getDescripcion();
    }

    @Override
    public void setDescripcion(String descripcion) {
        super.setDescripcion(descripcion);
    }

    @Override
    public int getValor() {
        return super.getValor();
    }

    @Override
    public void setValor(int valor) {
        super.setValor(valor);
    }

    @Override
    public String toString() {
        return "Marchas{" +
                "descripcion='" + super.getDescripcion() + '\'' +
                ", valor='" + super.getValor() + '\'' +
                '}';
    }
}
