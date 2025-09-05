/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udistrital.taller1.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import co.edu.udistrital.taller1.controller.ControllerVista;
/**
 *
 * @author crisc
 */
public class VentanaPrincipal extends javax.swing.JFrame {

    // Componentes
    private final JTextField txtN;
    private final JTextField txtM;
    private final JComboBox<String> cmbAlgoritmo;
    private final JComboBox<String> cmbDistribucion;
    private final JButton btnEjecutar;
    private final JTable tablaResultados;
    private final DefaultTableModel modeloTabla;
    private final ControllerVista controllerVista;

    public VentanaPrincipal(ControllerVista controllerVista) {
        this.controllerVista = controllerVista;

        setTitle("Comparación de Algoritmos de Ordenamiento");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Panel principal
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(panel);

        // Panel superior con BorderLayout
        JPanel panelSuperior = new JPanel(new BorderLayout(10, 10));

        // Panel de inputs (a la izquierda)
        JPanel panelInputs = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // márgenes

        // Fila 1 - N y M
        gbc.gridx = 0; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        panelInputs.add(new JLabel("Número de candidatos (N):"), gbc);

        gbc.gridx = 1; gbc.gridy = 0; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtN = new JTextField(10);
        panelInputs.add(txtN, gbc);

        gbc.gridx = 2; gbc.gridy = 0; gbc.anchor = GridBagConstraints.EAST;
        panelInputs.add(new JLabel("Valor máximo de atributos (M):"), gbc);

        gbc.gridx = 3; gbc.gridy = 0; gbc.fill = GridBagConstraints.HORIZONTAL;
        txtM = new JTextField(10);
        panelInputs.add(txtM, gbc);

        // Fila 2 - Algoritmo
        gbc.gridx = 0; gbc.gridy = 1; gbc.anchor = GridBagConstraints.EAST;
        panelInputs.add(new JLabel("Algoritmo de ordenamiento:"), gbc);

        gbc.gridx = 1; gbc.gridy = 1; gbc.gridwidth = 3;
        cmbAlgoritmo = new JComboBox<>(new String[]{"Burbuja", "Inserción", "Selección", "MergeSort", "QuickSort"});
        cmbAlgoritmo.setPreferredSize(new Dimension(200, 25));
        panelInputs.add(cmbAlgoritmo, gbc);
        gbc.gridwidth = 1;

        // Fila 3 - Distribución
        gbc.gridx = 0; gbc.gridy = 2; gbc.anchor = GridBagConstraints.EAST;
        panelInputs.add(new JLabel("Distribución de datos:"), gbc);

        gbc.gridx = 1; gbc.gridy = 2; gbc.gridwidth = 3;
        cmbDistribucion = new JComboBox<>(new String[]{"Aleatoria", "Casi ordenada", "Inversa"});
        cmbDistribucion.setPreferredSize(new Dimension(200, 25));
        panelInputs.add(cmbDistribucion, gbc);
        gbc.gridwidth = 1;

        // Botón ejecutar (a la derecha)
        btnEjecutar = new JButton("Generar y Ordenar");
        btnEjecutar.setPreferredSize(new Dimension(200, 20));

        // Agregar inputs y botón al panel superior
        panelSuperior.add(panelInputs, BorderLayout.CENTER);
        panelSuperior.add(btnEjecutar, BorderLayout.EAST);

        // Agregar panel superior al principal
        panel.add(panelSuperior, BorderLayout.NORTH);

        // Tabla de resultados
        String[] columnas = {"Algoritmo", "Comparaciones", "Intercambios", "Tiempo (ms)"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tablaResultados = new JTable(modeloTabla);
        tablaResultados.setRowHeight(25);

        JScrollPane scroll = new JScrollPane(tablaResultados);
        panel.add(scroll, BorderLayout.CENTER);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public String getN() { return txtN.getText(); }
    public String getM() { return txtM.getText(); }
    public String getAlgoritmo() { return (String) cmbAlgoritmo.getSelectedItem(); }
    public String getDistribucion() { return (String) cmbDistribucion.getSelectedItem(); }
    public JButton getBtnEjecutar() { return btnEjecutar; }

    public void agregarResultado(String algoritmo, long comparaciones, long intercambios, long tiempo) {
        modeloTabla.addRow(new Object[]{algoritmo, comparaciones, intercambios, tiempo});
    }
}

