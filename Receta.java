import java.util.ArrayList;
import java.util.List;

public class Receta {
    private String nombre;
    private List<Ingrediente> ingredientes;
    private String instrucciones;
    private boolean favorita;

    public Receta(String nombre, String instrucciones) {
        this.nombre = nombre;
        this.instrucciones = instrucciones;
        this.ingredientes = new ArrayList<>();
        this.favorita = false;
    }

    public void agregarIngrediente(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public void eliminarIngrediente(Ingrediente ingrediente) {
        ingredientes.remove(ingrediente);
    }

    public String mostrarReceta() {
        StringBuilder sb = new StringBuilder();
        sb.append("Receta: ").append(nombre).append("\nIngredientes:\n");
        for (Ingrediente ing : ingredientes) {
            sb.append("- ").append(ing.getNombre()).append(": ").append(ing.getCantidad()).append(" ").append(ing.getUnidadMedida()).append("\n");
        }
        sb.append("Instrucciones: ").append(instrucciones).append("\n");
        return sb.toString();
    }

    public void marcarComoFavorita() {
        this.favorita = true;
    }

    public void quitarDeFavorita() {
        this.favorita = false;
    }

    public boolean isFavorita() {
        return favorita;
    }

    public String getNombre() {
        return nombre;
    }
}


