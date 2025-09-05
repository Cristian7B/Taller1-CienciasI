package co.edu.udistrital.taller1.model;

class Marchas {
    private String descripcion;
    private long valor;

    public Marchas(String descripcion, long valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return descripcion + ": " + valor;
    }
}

class HorasClase {
    private String descripcion;
    private int valor;

    public HorasClase(String descripcion, int valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return descripcion + ": " + valor;
    }
}

class Prebendas {
    private String descripcion;
    private int valor;

    public Prebendas(String descripcion, int valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return descripcion + ": " + valor;
    }
}

class Sobornos {
    private String descripcion;
    private int valor;

    public Sobornos(String descripcion, int valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return descripcion + ": " + valor;
    }
}

class Corrupcion {
    private String descripcion;
    private int valor;

    public Corrupcion(String descripcion, int valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return descripcion + ": " + valor;
    }
}