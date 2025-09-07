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


    public void insercionCorrupcion(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<Corrupcion> lista = candidato.getCorrupcion(); 
            int n = lista.size();

            System.out.println("Corrupcion sin ordenar:");
            for (Corrupcion corrupcion : lista) {
                System.out.println(corrupcion);
            }


            for (int i = 1; i < n; i++) {
                Corrupcion key = lista.get(i);
                int j = i - 1;

                while (j >= 0) {
                    comparaciones++;
                    System.out.println("Comparando " + lista.get(j).getValor() + " con " + key.getValor());
                    if (lista.get(j).getValor() > key.getValor()) {
                        System.out.println("Intercambiando " + lista.get(j).getValor() + " con " + key.getValor());
                        lista.set(j + 1, lista.get(j));
                        j--;
                        intercambios++;
                    } else {
                        break;
                    }
                }
                System.out.println("Insertando " + key.getValor() + " en la posición " + (j + 1));
                lista.set(j + 1, key);
            }
            candidato.setCorrupcion(lista);
            System.out.println("-------------Candidato: " + candidato.getId());
            System.out.println("Corrupcion ordenada:");
            for (Corrupcion corrupcion : lista) {
                System.out.println(corrupcion);
            }

        }
    }

    public void insercionHorasClase(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<HorasClase> lista = candidato.getHorasClase(); 
            int n = lista.size();

            for (int i = 1; i < n; i++) {
                HorasClase key = lista.get(i);
                int j = i - 1;

                while (j >= 0) {
                    comparaciones++;
                    if (lista.get(j).getValor() > key.getValor()) {
                        lista.set(j + 1, lista.get(j));
                        j--;
                        intercambios++;
                    } else {
                        break;
                    }
                }
                lista.set(j + 1, key);
            }
            candidato.setHorasClase(lista);
        }
    }

    public void insercionMarchas(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<Marchas> lista = candidato.getMarchas(); 
            int n = lista.size();

            for (int i = 1; i < n; i++) {
                Marchas key = lista.get(i);
                int j = i - 1;

                while (j >= 0) {
                    comparaciones++;
                    if (lista.get(j).getValor() > key.getValor()) {
                        lista.set(j + 1, lista.get(j));
                        j--;
                        intercambios++;
                    } else {
                        break;
                    }
                }
                lista.set(j + 1, key);
            }
            candidato.setMarchas(lista);
        }
    }


    public void insercionPrebendas(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<Prebendas> lista = candidato.getPrebendas(); 
            int n = lista.size();

            for (int i = 1; i < n; i++) {
                Prebendas key = lista.get(i);
                int j = i - 1;

                while (j >= 0) {
                    comparaciones++;
                    if (lista.get(j).getValor() > key.getValor()) {
                        lista.set(j + 1, lista.get(j));
                        j--;
                        intercambios++;
                    } else {
                        break;
                    }
                }
                lista.set(j + 1, key);
            }
            candidato.setPrebendas(lista);
        }
    }


    public void insercionSobornos(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<Sobornos> lista = candidato.getSobornos(); 
            int n = lista.size();

            for (int i = 1; i < n; i++) {
                Sobornos key = lista.get(i);
                int j = i - 1;

                while (j >= 0) {
                    comparaciones++;
                    if (lista.get(j).getValor() > key.getValor()) {
                        lista.set(j + 1, lista.get(j));
                        j--;
                        intercambios++;
                    } else {
                        break;
                    }
                }
                lista.set(j + 1, key);
            }
            candidato.setSobornos(lista);
        }
    }


    public void seleccionCorrupcion(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<Corrupcion> lista = candidato.getCorrupcion(); 
            int n = lista.size();

            for (int i = 0; i < n - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < n; j++) {
                    comparaciones++;
                    if (lista.get(j).getValor() < lista.get(minIdx).getValor()) {
                        minIdx = j;
                    }
                }
                if (minIdx != i) {
                    Corrupcion temp = lista.get(i);
                    lista.set(i, lista.get(minIdx));
                    lista.set(minIdx, temp);
                    intercambios++;
                }
            }
            candidato.setCorrupcion(lista); 
        }
    }


    public void seleccionHorasClase(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<HorasClase> lista = candidato.getHorasClase(); 
            int n = lista.size();

            for (int i = 0; i < n - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < n; j++) {
                    comparaciones++;
                    if (lista.get(j).getValor() < lista.get(minIdx).getValor()) {
                        minIdx = j;
                    }
                }
                if (minIdx != i) {
                    HorasClase temp = lista.get(i);
                    lista.set(i, lista.get(minIdx));
                    lista.set(minIdx, temp);
                    intercambios++;
                }
            }
            candidato.setHorasClase(lista); 
        }
    }

    public void seleccionMarchas(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<Marchas> lista = candidato.getMarchas(); 
            int n = lista.size();

            for (int i = 0; i < n - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < n; j++) {
                    comparaciones++;
                    if (lista.get(j).getValor() < lista.get(minIdx).getValor()) {
                        minIdx = j;
                    }
                }
                if (minIdx != i) {
                    Marchas temp = lista.get(i);
                    lista.set(i, lista.get(minIdx));
                    lista.set(minIdx, temp);
                    intercambios++;
                }
            }
            candidato.setMarchas(lista); 
        }
    }

    public void seleccionPrebendas(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<Prebendas> lista = candidato.getPrebendas(); 
            int n = lista.size();

            for (int i = 0; i < n - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < n; j++) {
                    comparaciones++;
                    if (lista.get(j).getValor() < lista.get(minIdx).getValor()) {
                        minIdx = j;
                    }
                }
                if (minIdx != i) {
                    Prebendas temp = lista.get(i);
                    lista.set(i, lista.get(minIdx));
                    lista.set(minIdx, temp);
                    intercambios++;
                }
            }
            candidato.setPrebendas(lista); 
        }
    }

    public void seleccionSobornos(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<Sobornos> lista = candidato.getSobornos(); 
            int n = lista.size();

            for (int i = 0; i < n - 1; i++) {
                int minIdx = i;
                for (int j = i + 1; j < n; j++) {
                    comparaciones++;
                    if (lista.get(j).getValor() < lista.get(minIdx).getValor()) {
                        minIdx = j;
                    }
                }
                if (minIdx != i) {
                    Sobornos temp = lista.get(i);
                    lista.set(i, lista.get(minIdx));
                    lista.set(minIdx, temp);
                    intercambios++;
                }
            }
            candidato.setSobornos(lista); 
        }
    }

    public void quicksortCorrupcion(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<Corrupcion> lista = candidato.getCorrupcion(); 
            quickSortCorrupcion(lista, 0, lista.size() - 1);
            candidato.setCorrupcion(lista); 
        }
    }

    private void quickSortCorrupcion(ArrayList<Corrupcion> lista, int low, int high) {
        if (low < high) {
            int pi = partitionCorrupcion(lista, low, high);
            quickSortCorrupcion(lista, low, pi - 1);
            quickSortCorrupcion(lista, pi + 1, high);
        }
    }

    public int partitionCorrupcion(ArrayList<Corrupcion> lista, int low, int high) {
        Corrupcion pivot = lista.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            comparaciones++;
            if (lista.get(j).getValor() <= pivot.getValor()) { 
                i++;
                Corrupcion temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
                intercambios++;
            }
        }
        Corrupcion temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(high));
        lista.set(high, temp);
        intercambios++;
        return i + 1;
    }


    public void quicksortHorasClase(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<HorasClase> lista = candidato.getHorasClase(); 
            quickSortHorasClase(lista, 0, lista.size() - 1);
            candidato.setHorasClase(lista); 
        }
    }

    private void quickSortHorasClase(ArrayList<HorasClase> lista, int low, int high) {
        if (low < high) {
            int pi = partitionHorasClase(lista, low, high);
            quickSortHorasClase(lista, low, pi - 1);
            quickSortHorasClase(lista, pi + 1, high);
        }
    }
    public int partitionHorasClase(ArrayList<HorasClase> lista, int low, int high) {
        HorasClase pivot = lista.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            comparaciones++;
            if (lista.get(j).getValor() <= pivot.getValor()) { 
                i++;
                HorasClase temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
                intercambios++;
            }
        }
        HorasClase temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(high));
        lista.set(high, temp);
        intercambios++;
        return i + 1;
    }

    public void quicksortMarchas(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<Marchas> lista = candidato.getMarchas(); 
            quickSortMarchas(lista, 0, lista.size() - 1);
            candidato.setMarchas(lista); 
        }
    }

    private void quickSortMarchas(ArrayList<Marchas> lista, int low, int high) {
        if (low < high) {
            int pi = partitionMarchas(lista, low, high);
            quickSortMarchas(lista, low, pi - 1);
            quickSortMarchas(lista, pi + 1, high);
        }
    }

    public int partitionMarchas(ArrayList<Marchas> lista, int low, int high) {
        Marchas pivot = lista.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            comparaciones++;
            if (lista.get(j).getValor() <= pivot.getValor()) { 
                i++;
                Marchas temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
                intercambios++;
            }
        }
        Marchas temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(high));
        lista.set(high, temp);
        intercambios++;
        return i + 1;
    }

    public void quicksortPrebendas(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<Prebendas> lista = candidato.getPrebendas(); 
            quickSortPrebendas(lista, 0, lista.size() - 1);
            candidato.setPrebendas(lista); 
        }
    }

    private void quickSortPrebendas(ArrayList<Prebendas> lista, int low, int high) {
        if (low < high) {
            int pi = partitionPrebendas(lista, low, high);
            quickSortPrebendas(lista, low, pi - 1);
            quickSortPrebendas(lista, pi + 1, high);
        }
    }

    public int partitionPrebendas(ArrayList<Prebendas> lista, int low, int high) {
        Prebendas pivot = lista.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            comparaciones++;
            if (lista.get(j).getValor() <= pivot.getValor()) { 
                i++;
                Prebendas temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
                intercambios++;
            }
        }
        Prebendas temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(high));
        lista.set(high, temp);
        intercambios++;
        return i + 1;
    }

    public void quicksortSobornos(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<Sobornos> lista = candidato.getSobornos(); 
            quickSortSobornos(lista, 0, lista.size() - 1);
            candidato.setSobornos(lista); 
        }
    }

    private void quickSortSobornos(ArrayList<Sobornos> lista, int low, int high) {
        if (low < high) {
            int pi = partitionSobornos(lista, low, high);
            quickSortSobornos(lista, low, pi - 1);
            quickSortSobornos(lista, pi + 1, high);
        }
    }

    public int partitionSobornos(ArrayList<Sobornos> lista, int low, int high) {
        Sobornos pivot = lista.get(high);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            comparaciones++;
            if (lista.get(j).getValor() <= pivot.getValor()) { 
                i++;
                Sobornos temp = lista.get(i);
                lista.set(i, lista.get(j));
                lista.set(j, temp);
                intercambios++;
            }
        }
        Sobornos temp = lista.get(i + 1);
        lista.set(i + 1, lista.get(high));
        lista.set(high, temp);
        intercambios++;
        return i + 1;
    }

    public void mergeSortcorrupcion(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<Corrupcion> lista = candidato.getCorrupcion(); 
            ordenarCorrupcionMergeSort(lista);
            candidato.setCorrupcion(lista);
        }    
    }

    public void ordenarCorrupcionMergeSort(ArrayList<Corrupcion> lista) {
        if (lista.size() < 2) {
            return;
        }
        int mid = lista.size() / 2;
        ArrayList<Corrupcion> left = new ArrayList<>(lista.subList(0, mid));
        ArrayList<Corrupcion> right = new ArrayList<>(lista.subList(mid, lista.size()));

        ordenarCorrupcionMergeSort(left);
        ordenarCorrupcionMergeSort(right);

        mergeCorrupcion(lista, left, right);
    }

    private void mergeCorrupcion(ArrayList<Corrupcion> lista, ArrayList<Corrupcion> left,
            ArrayList<Corrupcion> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            comparaciones++;
            if (left.get(i).getValor() <= right.get(j).getValor()) { 
                lista.set(k++, left.get(i++));
            } else {
                lista.set(k++, right.get(j++));
            }
            intercambios++;
        }
        while (i < left.size()) {
            lista.set(k++, left.get(i++));
            intercambios++;
        }
        while (j < right.size()) {
            lista.set(k++, right.get(j++));
            intercambios++;
        }
    }

    public void mergeSortHorasClase(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<HorasClase> lista = candidato.getHorasClase(); 
            ordenarHorasClaseMergeSort(lista);
            candidato.setHorasClase(lista);
        }

    }

    public void ordenarHorasClaseMergeSort(ArrayList<HorasClase> lista) {
        if (lista.size() < 2) {
            return;
        }
        int mid = lista.size() / 2;
        ArrayList<HorasClase> left = new ArrayList<>(lista.subList(0, mid));
        ArrayList<HorasClase> right = new ArrayList<>(lista.subList(mid, lista.size()));

        ordenarHorasClaseMergeSort(left);
        ordenarHorasClaseMergeSort(right);

        mergeHorasClase(lista, left, right);
    }

    private void mergeHorasClase(ArrayList<HorasClase> lista, ArrayList<HorasClase> left,
            ArrayList<HorasClase> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            comparaciones++;
            if (left.get(i).getValor() <= right.get(j).getValor()) { 
                lista.set(k++, left.get(i++));
            } else {
                lista.set(k++, right.get(j++));
            }
            intercambios++;
        }
        while (i < left.size()) {
            lista.set(k++, left.get(i++));
            intercambios++;
        }
        while (j < right.size()) {
            lista.set(k++, right.get(j++));
            intercambios++;
        }
    }

    public void mergeSortMarchas(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<Marchas> lista = candidato.getMarchas(); 
            ordenarMarchasMergeSort(lista);
            candidato.setMarchas(lista);
        }
    }

    public void ordenarMarchasMergeSort(ArrayList<Marchas> lista) {
        if (lista.size() < 2) {
            return;
        }
        int mid = lista.size() / 2;
        ArrayList<Marchas> left = new ArrayList<>(lista.subList(0, mid));
        ArrayList<Marchas> right = new ArrayList<>(lista.subList(mid, lista.size()));

        ordenarMarchasMergeSort(left);
        ordenarMarchasMergeSort(right);

        mergeMarchas(lista, left, right);
    }


    private void mergeMarchas(ArrayList<Marchas> lista, ArrayList<Marchas> left,
            ArrayList<Marchas> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            comparaciones++;
            if (left.get(i).getValor() <= right.get(j).getValor()) { 
                lista.set(k++, left.get(i++));
            } else {
                lista.set(k++, right.get(j++));
            }
            intercambios++;
        }
        while (i < left.size()) {
            lista.set(k++, left.get(i++));
            intercambios++;
        }
        while (j < right.size()) {
            lista.set(k++, right.get(j++));
            intercambios++;
        }
    }


    public void mergeSortPrebendas(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<Prebendas> lista = candidato.getPrebendas(); 
            ordenarPrebendasMergeSort(lista);
            candidato.setPrebendas(lista);
        }
    }

    public void ordenarPrebendasMergeSort(ArrayList<Prebendas> lista) {
        if (lista.size() < 2) {
            return;
        }
        int mid = lista.size() / 2;
        ArrayList<Prebendas> left = new ArrayList<>(lista.subList(0, mid));
        ArrayList<Prebendas> right = new ArrayList<>(lista.subList(mid, lista.size()));

        ordenarPrebendasMergeSort(left);
        ordenarPrebendasMergeSort(right);

        mergePrebendas(lista, left, right);
    }

    private void mergePrebendas(ArrayList<Prebendas> lista, ArrayList<Prebendas> left,
            ArrayList<Prebendas> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            comparaciones++;
            if (left.get(i).getValor() <= right.get(j).getValor()) { 
                lista.set(k++, left.get(i++));
            } else {
                lista.set(k++, right.get(j++));
            }
            intercambios++;
        }
        while (i < left.size()) {
            lista.set(k++, left.get(i++));
            intercambios++;
        }
        while (j < right.size()) {
            lista.set(k++, right.get(j++));
            intercambios++;
        }
    }

    public void mergeSortSobornos(ArrayList<Candidato> candidatos) {
        for (Candidato candidato : candidatos) {
            ArrayList<Sobornos> lista = candidato.getSobornos(); 
            ordenarSobornosMergeSort(lista);
            candidato.setSobornos(lista);
        }
    }

    public void ordenarSobornosMergeSort(ArrayList<Sobornos> lista) {
        if (lista.size() < 2) {
            return;
        }
        int mid = lista.size() / 2;
        ArrayList<Sobornos> left = new ArrayList<>(lista.subList(0, mid));
        ArrayList<Sobornos> right = new ArrayList<>(lista.subList(mid, lista.size()));

        ordenarSobornosMergeSort(left);
        ordenarSobornosMergeSort(right);

        mergeSobornos(lista, left, right);
    }

    private void mergeSobornos(ArrayList<Sobornos> lista, ArrayList<Sobornos> left,
            ArrayList<Sobornos> right) {
        int i = 0, j = 0, k = 0;
        while (i < left.size() && j < right.size()) {
            comparaciones++;
            if (left.get(i).getValor() <= right.get(j).getValor()) { 
                lista.set(k++, left.get(i++));
            } else {
                lista.set(k++, right.get(j++));
            }
            intercambios++;
        }
        while (i < left.size()) {
            lista.set(k++, left.get(i++));
            intercambios++;
        }
        while (j < right.size()) {
            lista.set(k++, right.get(j++));
            intercambios++;
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

        mergePrebendasCandidato(candidatos, left, right);
    }


    private void mergePrebendasCandidato(ArrayList<Candidato> candidatos, ArrayList<Candidato> left,
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
        quickSortSobornosCandidato(candidatos, 0, candidatos.size() - 1);
    }

    private void quickSortSobornosCandidato(ArrayList<Candidato> candidatos, int low, int high) {
        if (low < high) {
            int pi = partitionSobornosCandidato(candidatos, low, high);
            quickSortSobornosCandidato(candidatos, low, pi - 1);
            quickSortSobornosCandidato(candidatos, pi + 1, high);
        }
    }

    private int partitionSobornosCandidato(ArrayList<Candidato> candidatos, int low, int high) {
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
