import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<Receta> recetasFavoritas;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.recetasFavoritas = new ArrayList<>();
    }

    public void marcarRecetaFavorita(Receta receta) {
        recetasFavoritas.add(receta);
    }

    public void eliminarRecetaFavorita(Receta receta) {
        recetasFavoritas.remove(receta);
    }

    public String mostrarRecetasFavoritas() {
        StringBuilder sb = new StringBuilder();
        sb.append("Recetas favoritas de ").append(nombre).append(":\n");
        for (Receta receta : recetasFavoritas) {
            sb.append(receta.mostrarReceta()).append("\n");
        }
        return sb.toString();
    }
}

