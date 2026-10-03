/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consumoelectrico;

/*
 * Autor: LUIS GADIEL HERNANDEZ BAUTISTA
 * Clase hija para demostrar herencia.
 */

public class ConsumoDomestico extends ConsumoElectrico {

    private String categoria;

    public ConsumoDomestico(String nombreAparato,
            double potenciaWatts,
            double horasUso,
            String categoria) {

        super(nombreAparato, potenciaWatts, horasUso);

        if (categoria == null || categoria.trim().isEmpty()) {
            this.categoria = "General";
        } else {
            this.categoria = categoria;
        }
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        if (categoria != null && !categoria.trim().isEmpty()) {
            this.categoria = categoria;
        }
    }

    // Método propio de la clase hija.
    public String mostrarCategoria() {
        return "Categoría: " + categoria;
    }

    // Sobrescritura de método.
    @Override
    public String obtenerResumen() {

        return super.obtenerResumen()
                + "\n" + mostrarCategoria();
    }
}