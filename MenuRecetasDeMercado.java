import java.util.ArrayList;
import java.util.List;

public class MenuRecetasDeMercado {
    private List<MenuDiario> menus;
    private List<Receta> recetario;
    private List<Ingrediente> mercado;

    public MenuRecetasDeMercado() {
        this.menus = new ArrayList<>();
        this.recetario = new ArrayList<>();
        this.mercado = new ArrayList<>();
    }

    public void agregarReceta(Receta receta) {
        recetario.add(receta);
    }

    public void agregarMenuDiario(MenuDiario menu) {
        menus.add(menu);
    }

    public void agregarIngredienteMercado(Ingrediente ingrediente) {
        mercado.add(ingrediente);
    }

    public void generarListaCompras() {
        System.out.println("Lista de compras generada:");
        for (Ingrediente ing : mercado) {
            if (!ing.isComprado()) {
                System.out.println(ing.getNombre() + ": " + ing.getCantidad() + " " + ing.getUnidadMedida());
            }
        }
    }

    public String mostrarEstadoMercado() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estado del mercado:\n");
        for (Ingrediente ing : mercado) {
            sb.append(ing.mostrarEstado()).append("\n");
        }
        return sb.toString();
    }

    public List<Receta> getRecetas() {
        return recetario;
    }
}



