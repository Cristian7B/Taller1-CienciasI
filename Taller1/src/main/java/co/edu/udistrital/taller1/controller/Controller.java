/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.taller1.controller;

import co.edu.udistrital.taller1.view.VentanaPrincipal;

/**
 *
 * @author crisc
 */
public class Controller {

    private final VentanaPrincipal ventana;

    public Controller() {
        ventana = new VentanaPrincipal(this);
        ventana.setVisible(true);
    }
    
}
