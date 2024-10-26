public class Ingrediente {
    private String nombre;
    private double cantidad;
    private String unidadMedida;
    private boolean comprado;

    public Ingrediente(String nombre, double cantidad, String unidadMedida) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.comprado = false; 
    }

    public String getNombre() {
        return nombre;
    }

    public double getCantidad() {
        return cantidad;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void marcarComoComprado() {
        comprado = true;
    }

    public void marcarComoNoComprado() {
        comprado = false;
    }

    public String mostrarEstado() {
        return nombre + ": " + (comprado ? "Comprado" : "Falta por comprar");
    }
}


