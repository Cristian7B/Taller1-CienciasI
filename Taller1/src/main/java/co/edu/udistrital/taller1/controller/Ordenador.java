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

    public void resetContadores() {
        this.comparaciones = 0;
        this.intercambios = 0;
    }

    public void burbujaCorrupcion(ArrayList<Candidato> candidatos) {

        for (Candidato candidato : candidatos) {
            ArrayList<Corrupcion> lista = candidato.getCorrupcion(); 
            int n = lista.size();

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    comparaciones++;
                    if (lista.get(j).getValor() < lista.get(j + 1).getValor()) {
                        // intercambiar
                        Corrupcion temp = lista.get(j);
                        lista.set(j, lista.get(j + 1));
                        lista.set(j + 1, temp);
                        intercambios++;
                    }
                }
            }

            candidato.setCorrupcion(lista); 

        }


    }

    public void BurbujaMarchas(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {

            ArrayList<Marchas> lista = candidato.getMarchas(); 
            int n = lista.size();

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    comparaciones++;
                    if (lista.get(j).getValor() < lista.get(j + 1).getValor()) {
                        Marchas temp = lista.get(j);
                        lista.set(j, lista.get(j + 1));
                        lista.set(j + 1, temp);
                        intercambios++;
                    }
                }
            }

            candidato.setMarchas(lista); 

        }

    }

    public void BurbujaHorasClase(ArrayList<Candidato> candidatos) {

        for (Candidato candidato : candidatos) {

            ArrayList<HorasClase> lista = candidato.getHorasClase(); 
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

            candidato.setHorasClase(lista); 


        }


    }

    public void BurbujaPrebendas(ArrayList<Candidato> candidatos) {

        for (Candidato candidato : candidatos) {

            ArrayList<Prebendas> lista = candidato.getPrebendas(); 
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

            candidato.setPrebendas(lista); 

        }


    }

    public void BurbujaSobornos(ArrayList<Candidato> candidatos) {

        for (Candidato candidato : candidatos) {

            ArrayList<Sobornos> lista = candidato.getSobornos(); 
            int n = lista.size();

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    comparaciones++;
                    if (lista.get(j).getValor() < lista.get(j + 1).getValor()) {
                        Sobornos temp = lista.get(j);
                        lista.set(j, lista.get(j + 1));
                        lista.set(j + 1, temp);
                        intercambios++;
                    }
                }
            }

            candidato.setSobornos(lista);

        }


    }

    public void ordenarCandidatosBurbuja(ArrayList<Candidato> candidatos) {
        int n = candidatos.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparaciones++;
                int corrupcionJ = candidatos.get(j).getCorrupcion().get(0).getValor();
                int corrupcionJ1 = candidatos.get(j + 1).getCorrupcion().get(0).getValor();

                if (corrupcionJ < corrupcionJ1) { 
                    Candidato temp = candidatos.get(j);
                    candidatos.set(j, candidatos.get(j + 1));
                    candidatos.set(j + 1, temp);
                    intercambios++;
                }
            }
        }
    }

    public void ordenarCandidatosSeleccion(ArrayList<Candidato> candidatos) {
        int n = candidatos.size();
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                comparaciones++;
                int horasMin = candidatos.get(minIdx).getHorasClase().get(0).getValor();
                int horasJ = candidatos.get(j).getHorasClase().get(0).getValor();

                if (horasJ < horasMin) { 
                    minIdx = j;
                }
            }
            if (minIdx != i) {
                Candidato temp = candidatos.get(i);
                candidatos.set(i, candidatos.get(minIdx));
                candidatos.set(minIdx, temp);
                intercambios++;
            }
        }
    }

    public void ordenarCandidatosInsercion(ArrayList<Candidato> candidatos) {
        int n = candidatos.size();
        for (int i = 1; i < n; i++) {
            Candidato key = candidatos.get(i);
            int marchasKey = key.getMarchas().get(0).getValor();
            int j = i - 1;

            while (j >= 0) {
                comparaciones++;
                int marchasJ = candidatos.get(j).getMarchas().get(0).getValor();
                if (marchasJ > marchasKey) { // Orden ascendente
                    candidatos.set(j + 1, candidatos.get(j));
                    j--;
                    intercambios++;
                } else {
                    break;
                }
            }
            candidatos.set(j + 1, key);
        }
    }

    public void ordenarCandidatosMergeSort(ArrayList<Candidato> candidatos) {
        if (candidatos.size() < 2) {
            return;
        }
        int mid = candidatos.size() / 2;
        ArrayList<Candidato> left = new ArrayList<>(candidatos.subList(0, mid));
        ArrayList<Candidato> right = new ArrayList<>(candidatos.subList(mid, candidatos.size()));

        ordenarCandidatosMergeSort(left);
        ordenarCandidatosMergeSort(right);

        mergePrebendas(candidatos, left, right);
    }

    private void mergePrebendas(ArrayList<Candidato> candidatos, ArrayList<Candidato> left,
            ArrayList<Candidato> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            comparaciones++;
            int prebendasLeft = left.get(i).getPrebendas().get(0).getValor();
            int prebendasRight = right.get(j).getPrebendas().get(0).getValor();

            if (prebendasLeft >= prebendasRight) { 
                candidatos.set(k++, left.get(i++));
            } else {
                candidatos.set(k++, right.get(j++));
            }
            intercambios++;
        }
        while (i < left.size()) {
            candidatos.set(k++, left.get(i++));
            intercambios++;
        }
        while (j < right.size()) {
            candidatos.set(k++, right.get(j++));
            intercambios++;
        }
    }

    public void ordenarCandidatosQuickSort(ArrayList<Candidato> candidatos) {
        quickSortSobornos(candidatos, 0, candidatos.size() - 1);
    }

    private void quickSortSobornos(ArrayList<Candidato> candidatos, int low, int high) {
        if (low < high) {
            int pi = partitionSobornos(candidatos, low, high);
            quickSortSobornos(candidatos, low, pi - 1);
            quickSortSobornos(candidatos, pi + 1, high);
        }
    }

    private int partitionSobornos(ArrayList<Candidato> candidatos, int low, int high) {
        Candidato pivot = candidatos.get(high);
        int sobornosPivot = pivot.getSobornos().get(0).getValor();
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            comparaciones++;
            int sobornosJ = candidatos.get(j).getSobornos().get(0).getValor();
            if (sobornosJ <= sobornosPivot) { // Orden ascendente
                i++;
                Candidato temp = candidatos.get(i);
                candidatos.set(i, candidatos.get(j));
                candidatos.set(j, temp);
                intercambios++;
            }
        }
        Candidato temp = candidatos.get(i + 1);
        candidatos.set(i + 1, candidatos.get(high));
        candidatos.set(high, temp);
        intercambios++;
        return i + 1;
    }

    public long getComparaciones() {
        return comparaciones;
    }

    public long getIntercambios() {
        return intercambios;
    }

}
