package org.miguelguzman.controller;

import javafx.scene.control.Label;

public class CalculadoraController {
    private String primerValor = "";
    private String signoMatematico = "";
    private String segundoValor = "";
    private boolean limpiarAlDigitar = false;

    public CalculadoraController() {
    }

    public void registrarAccion(String simbolo, Label visor) {
        // Manejo de números y punto decimal
        if (simbolo.matches("[0-9]") || simbolo.equals(".")) {
            if (limpiarAlDigitar) {
                primerValor = "";
                limpiarAlDigitar = false;
            }
            
            if (signoMatematico.isEmpty()) {
                if (simbolo.equals(".") && primerValor.contains(".")) return;
                primerValor += simbolo;
            } else {
                if (simbolo.equals(".") && segundoValor.contains(".")) return;
                segundoValor += simbolo;
            }
            actualizarVisor(visor);
        } 
        // Procesamiento del resultado (=)
        else if (simbolo.equals("=")) {
            if (!primerValor.isEmpty() && !segundoValor.isEmpty() && !signoMatematico.isEmpty()) {
                double digito1 = Double.parseDouble(primerValor);
                double digito2 = Double.parseDouble(segundoValor);
                double resultadoFinal = 0;

                switch (signoMatematico) {
                    case "+": resultadoFinal = digito1 + digito2; break;
                    case "-": resultadoFinal = digito1 - digito2; break;
                    case "x": resultadoFinal = digito1 * digito2; break;
                    case "÷": 
                        if (digito2 != 0) {
                            resultadoFinal = digito1 / digito2;
                        } else {
                            visor.setText("Error");
                            reiniciarValores();
                            return;
                        }
                        break;
                }

                if (resultadoFinal % 1 == 0) {
                    primerValor = String.valueOf((long) resultadoFinal);
                } else {
                    primerValor = String.valueOf(resultadoFinal);
                }
                
                signoMatematico = "";
                segundoValor = "";
                limpiarAlDigitar = true;
                visor.setText(primerValor);
            }
        } 
        // Selección del operador matemático
        else {
            if (!primerValor.isEmpty()) {
                signoMatematico = simbolo;
                limpiarAlDigitar = false;
            }
        }
    }

    private void actualizarVisor(Label visor) {
        if (signoMatematico.isEmpty()) {
            visor.setText(primerValor.isEmpty() ? "0" : primerValor);
        } else {
            visor.setText(segundoValor.isEmpty() ? "0" : segundoValor);
        }
    }

    private void reiniciarValores() {
        primerValor = "";
        signoMatematico = "";
        segundoValor = "";
        limpiarAlDigitar = false;
    }
}