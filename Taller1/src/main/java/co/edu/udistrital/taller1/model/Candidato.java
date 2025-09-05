/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.taller1.model;

import java.util.ArrayList;

/**
 *
 * @author crisc
 */
public class Candidato {

    private final int id;
    private final ArrayList<Marchas> marchas;
    private final ArrayList<HorasClase> horasClase;
    private final ArrayList<Prebendas> prebendas;
    private final ArrayList<Sobornos> sobornos;
    private final ArrayList<Corrupcion> corrupcion;

    public Candidato(int id, int m) {
        this.id = id;
        this.marchas = new ArrayList<>(m);
        this.horasClase = new ArrayList<>(m);
        this.prebendas = new ArrayList<>(m);
        this.sobornos = new ArrayList<>(m);
        this.corrupcion = new ArrayList<>(m);
    }

    public void agregarMarcha(String desc, int valor) {
        marchas.add(new Marchas(desc, valor));
    }

    public void agregarHoras(String desc, int valor) {
        horasClase.add(new HorasClase(desc, valor));
    }

    public void agregarPrebenda(String desc, int valor) {
        prebendas.add(new Prebendas(desc, valor));
    }

    public void agregarSoborno(String desc, int valor) {
        sobornos.add(new Sobornos(desc, valor));
    }

    public void agregarCorrupcion(String desc, int valor) {
        corrupcion.add(new Corrupcion(desc, valor));
    }

    // Getters
    public int getId() {
        return id;
    }

    public ArrayList<Marchas> getMarchas() {
        return new ArrayList<>(marchas);
    }

    public ArrayList<HorasClase> getHorasClase() {
        return new ArrayList<>(horasClase);
    }

    public ArrayList<Prebendas> getPrebendas() {
        return new ArrayList<>(prebendas);
    }

    public ArrayList<Sobornos> getSobornos() {
        return new ArrayList<>(sobornos);
    }

    public ArrayList<Corrupcion> getCorrupcion() {
        return new ArrayList<>(corrupcion);
    }
    public void setCorrupcion(ArrayList<Corrupcion> corrupcion) {
        this.corrupcion.clear();
        this.corrupcion.addAll(corrupcion);
    }

    public void setMarchas(ArrayList<Marchas> marchas) {
        this.marchas.clear();
        this.marchas.addAll(marchas);
    }

    public void setHorasClase(ArrayList<HorasClase> horasClase) {
        this.horasClase.clear();
        this.horasClase.addAll(horasClase);
    }

    public void setPrebendas(ArrayList<Prebendas> prebendas) {
        this.prebendas.clear();
        this.prebendas.addAll(prebendas);
    }

    public void setSobornos(ArrayList<Sobornos> sobornos) {
        this.sobornos.clear();
        this.sobornos.addAll(sobornos);
    }

    @Override
    public String toString() {
        return "Candidato " + id +
                "\n  Marchas=" + marchas +
                "\n  HorasClase=" + horasClase +
                "\n  Prebendas=" + prebendas +
                "\n  Sobornos=" + sobornos +
                "\n  Corrupcion=" + corrupcion;
    }

}
