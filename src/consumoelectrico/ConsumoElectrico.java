/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package consumoelectrico;

/**
 *
 * @author lgbau
 */
package consumoelectrico;

/*
 * Autor: LUIS GADIEL HERNANDEZ BAUTISTA
 * Proyecto: Calculadora de Consumo Eléctrico
 * TDA: ConsumoElectrico
 */

public class ConsumoElectrico {

    // Atributos privados para aplicar encapsulamiento
    private String nombreAparato;
    private double potenciaWatts;
    private double horasUso;

    // Constructor con validaciones
    public ConsumoElectrico(String nombreAparato, double potenciaWatts, double horasUso) {

        if (nombreAparato == null || nombreAparato.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del aparato es obligatorio.");
        }

        if (potenciaWatts < 0) {
            throw new IllegalArgumentException("La potencia no puede ser negativa.");
        }

        if (horasUso < 0 || horasUso > 24) {
            throw new IllegalArgumentException("Las horas deben estar entre 0 y 24.");
        }

        this.nombreAparato = nombreAparato;
        this.potenciaWatts = potenciaWatts;
        this.horasUso = horasUso;
    }

    // Getter del nombre
    public String getNombreAparato() {
        return nombreAparato;
    }

    // Setter del nombre
    public void setNombreAparato(String nombreAparato) {
        if (nombreAparato != null && !nombreAparato.trim().isEmpty()) {
            this.nombreAparato = nombreAparato;
        }
    }

    // Getter de potencia
    public double getPotenciaWatts() {
        return potenciaWatts;
    }

    // Setter de potencia
    public void setPotenciaWatts(double potenciaWatts) {
        if (potenciaWatts >= 0) {
            this.potenciaWatts = potenciaWatts;
        }
    }

    // Getter de horas
    public double getHorasUso() {
        return horasUso;
    }

    // Setter de horas
    public void setHorasUso(double horasUso) {
        if (horasUso >= 0 && horasUso <= 24) {
            this.horasUso = horasUso;
        }
    }

    // Método de lógica 1:
    // Calcula el consumo en Watts por día.
    public double calcularConsumoDiario() {
        return potenciaWatts * horasUso;
    }

    // Método de lógica 2:
    // Calcula el consumo semanal.
    public double calcularConsumoSemanal() {
        return calcularConsumoSemanalRecursivo(7);
    }

    // Método recursivo.
    // Caso base: cuando quedan 0 días, termina.
    // Avance: disminuye la cantidad de días.
    private double calcularConsumoSemanalRecursivo(int dias) {

        if (dias == 0) {
            return 0;
        }

        return calcularConsumoDiario()
                + calcularConsumoSemanalRecursivo(dias - 1);
    }

    // Método de lógica 3:
    // Calcula el consumo aproximado de un mes.
    public double calcularConsumoMensual() {
        return calcularConsumoDiario() * 30;
    }

    // Método de lógica 4:
    // Calcula el costo mensual según el precio del kWh.
    public double calcularCostoMensual(double precioKwh) {

        if (precioKwh < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }

        double consumoKwh = calcularConsumoMensual() / 1000;

        return consumoKwh * precioKwh;
    }

    // Método de lógica 5:
    // Convierte el consumo mensual de Watts a kWh.
    public double convertirAKwhMensual() {
        return calcularConsumoMensual() / 1000;
    }

    // Método adicional.
    public String obtenerResumen() {

        return "Aparato: " + nombreAparato
                + "\nPotencia: " + potenciaWatts + " W"
                + "\nHoras de uso: " + horasUso
                + "\nConsumo diario: " + calcularConsumoDiario() + " Wh"
                + "\nConsumo semanal: " + calcularConsumoSemanal() + " Wh"
                + "\nConsumo mensual: " + calcularConsumoMensual() + " Wh"
                + "\nConsumo mensual: " + convertirAKwhMensual() + " kWh";
    }
}