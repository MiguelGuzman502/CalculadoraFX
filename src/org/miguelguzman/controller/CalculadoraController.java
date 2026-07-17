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
                    case "^": resultadoFinal = Math.pow(digito1, digito2); break;
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
        else if (simbolo.equals("√")) {
            if (!primerValor.isEmpty() && signoMatematico.isEmpty()) {
                double evaluarRadical = Double.parseDouble(primerValor);
                if (evaluarRadical >= 0) {
                    double raizObtenida = Math.sqrt(evaluarRadical);
                    primerValor = (raizObtenida % 1 == 0) ? String.valueOf((long) raizObtenida) : String.valueOf(raizObtenida);
                    limpiarAlDigitar = true;
                    visor.setText(primerValor);
                } else {
                    visor.setText("Error");
                    reiniciarValores();
                }
            }
        }
        else if (simbolo.equals("%")) {
            if (!primerValor.isEmpty() && signoMatematico.isEmpty()) {
                double calculoPorcentaje = Double.parseDouble(primerValor) / 100;
                primerValor = String.valueOf(calculoPorcentaje);
                limpiarAlDigitar = true;
                visor.setText(primerValor);
            }
        }
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