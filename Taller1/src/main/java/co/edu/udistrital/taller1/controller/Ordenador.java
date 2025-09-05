package co.edu.udistrital.taller1.controller;

import java.util.ArrayList;

import co.edu.udistrital.taller1.model.Candidato;
import co.edu.udistrital.taller1.model.Corrupcion;
import co.edu.udistrital.taller1.model.HorasClase;
import co.edu.udistrital.taller1.model.Marchas;
import co.edu.udistrital.taller1.model.Prebendas;
import co.edu.udistrital.taller1.model.Sobornos;

public class Ordenador {

    private long comparaciones = 0;
    private long intercambios = 0;


    public Ordenador() {

    }

    public void burbujaCorrupcion(ArrayList<Candidato> candidatos){

        for (Candidato candidato : candidatos) {
            ArrayList<Corrupcion> lista = candidato.getCorrupcion(); // ejemplo para edad
            int n = lista.size();

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    comparaciones++;
                    if (lista.get(j).getValor()< lista.get(j + 1).getValor()) {
                        // intercambiar
                        Corrupcion temp = lista.get(j);
                        lista.set(j, lista.get(j + 1));
                        lista.set(j + 1, temp);
                        intercambios++;
                    }
                }
            }
            
            candidato.setCorrupcion(lista); // actualizar la lista ordenada

            // Imprimir la lista ordenada
            System.out.println("Candidato ID: " + candidato.getId());
            System.out.println("Lista de Corrupción ordenada:");
            for (Corrupcion c : lista) {
                System.out.println(c);
            }
        }

        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Intercambios: " + intercambios);

    }

    public void BurbujaMarchas(ArrayList<Candidato> candidatos){
        for (Candidato candidato : candidatos) {

            ArrayList<Marchas> lista = candidato.getMarchas(); // ejemplo para edad
            int n = lista.size();

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    comparaciones++;
                    if (lista.get(j).getValor() < lista.get(j + 1).getValor()) {
                        // intercambiar
                        Marchas temp = lista.get(j);
                        lista.set(j, lista.get(j + 1));
                        lista.set(j + 1, temp);
                        intercambios++;
                    }
                }
            }
            
            candidato.setMarchas(lista); // actualizar la lista ordenada

            // Imprimir la lista ordenada
            System.out.println("Candidato ID: " + candidato.getId());
            System.out.println("Lista de marchas ordenada:");
            for (Marchas c : lista) {
                System.out.println(c);
            }
        }

        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Intercambios: " + intercambios);
    }


    public void BurbujaHorasClase(ArrayList<Candidato> candidatos){

        for (Candidato candidato : candidatos) {

            ArrayList<HorasClase> lista = candidato.getHorasClase(); // ejemplo para edad
            int n = lista.size();

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    comparaciones++;
                    if (lista.get(j).getValor() < lista.get(j + 1).getValor()) {
                        // intercambiar
                        HorasClase temp = lista.get(j);
                        lista.set(j, lista.get(j + 1));
                        lista.set(j + 1, temp);
                        intercambios++;
                    }
                }
            }
            
            candidato.setHorasClase(lista); // actualizar la lista ordenada

            // Imprimir la lista ordenada
            System.out.println("Candidato ID: " + candidato.getId());
            System.out.println("Lista de horas clase ordenada:");
            for (HorasClase c : lista) {
                System.out.println(c);
            }
        }

        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Intercambios: " + intercambios);

    }

    public void BurbujaPrebendas(ArrayList<Candidato> candidatos){

        for (Candidato candidato : candidatos) {

            ArrayList<Prebendas> lista = candidato.getPrebendas(); // ejemplo para edad
            int n = lista.size();

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    comparaciones++;
                    if (lista.get(j).getValor() < lista.get(j + 1).getValor()) {
                        // intercambiar
                        Prebendas temp = lista.get(j);
                        lista.set(j, lista.get(j + 1));
                        lista.set(j + 1, temp);
                        intercambios++;
                    }
                }
            }
            
            candidato.setPrebendas(lista); // actualizar la lista ordenada

            // Imprimir la lista ordenada
            System.out.println("Candidato ID: " + candidato.getId());
            System.out.println("Lista de prebendas ordenada:");
            for (Prebendas c : lista) {
                System.out.println(c);
            }
        }

        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Intercambios: " + intercambios);

    }


    public void BurbujaSobornos(ArrayList<Candidato> candidatos){

        for (Candidato candidato : candidatos) {

            ArrayList<Sobornos> lista = candidato.getSobornos(); // ejemplo para edad
            int n = lista.size();

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    comparaciones++;
                    if (lista.get(j).getValor() < lista.get(j + 1).getValor()) {
                        // intercambiar
                        Sobornos temp = lista.get(j);
                        lista.set(j, lista.get(j + 1));
                        lista.set(j + 1, temp);
                        intercambios++;
                    }
                }
            }
            
            candidato.setSobornos(lista);// actualizar la lista ordenada

            // Imprimir la lista ordenada
            System.out.println("Candidato ID: " + candidato.getId());
            System.out.println("Lista de Sobornos ordenada:");
            for (Sobornos c : lista) {
                System.out.println(c);
            }
        }

        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Intercambios: " + intercambios);

    }

    // Getters para comparaciones e intercambios
    public long getComparaciones() {
        return comparaciones;
    }
    public long getIntercambios() {
        return intercambios;
    }


}
