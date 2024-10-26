import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuDiario {
    private Date fecha;
    private List<Receta> recetas;

    public MenuDiario(Date fecha) {
        this.fecha = fecha;
        this.recetas = new ArrayList<>();
    }

    public void agregarReceta(Receta receta) {
        recetas.add(receta);
    }

    public void eliminarReceta(Receta receta) {
        if (recetas.remove(receta)) {
            System.out.println("La Receta fue eliminada del menú.");
        } else {
            System.out.println("La receta no se encuentra en el menú.");
        }
    }

    public String mostrarMenu() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menú del día ").append(fecha.toString()).append(":\n");

        if (recetas.isEmpty()) {
            sb.append("No hay recetas en el menú.\n");
        } else {
            for (Receta receta : recetas) {
                sb.append("- ").append(receta.mostrarReceta()).append("\n");
            }
        }

        return sb.toString();
    }

    public List<Receta> getRecetas() {
        return recetas;
    }
}

