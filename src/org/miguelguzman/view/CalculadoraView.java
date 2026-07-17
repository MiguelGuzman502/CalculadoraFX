package org.miguelguzman.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label; 
import javafx.scene.layout.GridPane; 
import javafx.scene.layout.VBox; 
import javafx.scene.text.Font;       
import javafx.scene.text.FontWeight;  
import org.miguelguzman.controller.CalculadoraController;

public class CalculadoraView {
    private VBox contenedorPrincipal; 
    private Label panelNumerico; 
    private GridPane mallaBotones;     
    private CalculadoraController coreController; 
    
    public CalculadoraView() {
        coreController = new CalculadoraController(); 
        
        contenedorPrincipal = new VBox(0); 
        contenedorPrincipal.setAlignment(Pos.CENTER);
        contenedorPrincipal.setStyle("-fx-background-color: #ECEFF1;"); 
        
        panelNumerico = new Label("0");
        panelNumerico.setFont(Font.font("Segoe UI", FontWeight.BOLD, 36)); 
        panelNumerico.setAlignment(Pos.CENTER_RIGHT); 
        panelNumerico.setPrefSize(266, 85); 
        panelNumerico.setPadding(new Insets(0, 20, 0, 20));
        panelNumerico.setStyle("-fx-background-color: #1A1A24; -fx-text-fill: #00FFCC;"); 
        
        mallaBotones = new GridPane();
        mallaBotones.setHgap(12);
        mallaBotones.setVgap(12);
        mallaBotones.setAlignment(Pos.CENTER);
        mallaBotones.setPadding(new Insets(18));
        
        Button btnLimpiar = new Button("C");
        btnLimpiar.setPrefSize(50, 50);
        btnLimpiar.setStyle("-fx-background-color: #D32F2F; -fx-text-fill: white; -fx-background-radius: 8px; -fx-cursor: hand;");
        btnLimpiar.setFont(Font.font("Segoe UI", FontWeight.BOLD, 18));
        btnLimpiar.setOnAction(e -> coreController.registrarAccion("C", panelNumerico));

        Button btnPorcentaje = crearBotonOperacion("%");
        Button btnPotencia = crearBotonOperacion("^");
        Button btnRadical = crearBotonOperacion("√");
        Button btnDivision = crearBotonOperacion("÷");
        Button btnMultiplicacion = crearBotonOperacion("x");
        Button btnResta = crearBotonOperacion("-");
        Button btnSuma = crearBotonOperacion("+");
        
        Button btnResultado = new Button("=");
        btnResultado.setPrefSize(112, 50);
        btnResultado.setStyle("-fx-background-color: #26A69A; -fx-text-fill: white; -fx-background-radius: 8px; -fx-cursor: hand;");
        btnResultado.setFont(Font.font("Segoe UI", FontWeight.BOLD, 18));
        btnResultado.setOnAction(e -> coreController.registrarAccion("=", panelNumerico));
        
        Button btn7 = crearBotonNumero("7");
        Button btn8 = crearBotonNumero("8");
        Button btn9 = crearBotonNumero("9");
        Button btn4 = crearBotonNumero("4");
        Button btn5 = crearBotonNumero("5");
        Button btn6 = crearBotonNumero("6");
        Button btn1 = crearBotonNumero("1");
        Button btn2 = crearBotonNumero("2");
        Button btn3 = crearBotonNumero("3");
        Button btn0 = crearBotonNumero("0");
        Button btnPunto = crearBotonOperacion(".");

        mallaBotones.add(btnLimpiar, 0, 0);
        mallaBotones.add(btnRadical, 1, 0);
        mallaBotones.add(btnPotencia, 2, 0);
        mallaBotones.add(btnPorcentaje, 3, 0);
    
        mallaBotones.add(btn7, 0, 1);
        mallaBotones.add(btn8, 1, 1);
        mallaBotones.add(btn9, 2, 1);
        mallaBotones.add(btnDivision, 3, 1);
        
        mallaBotones.add(btn4, 0, 2);
        mallaBotones.add(btn5, 1, 2);
        mallaBotones.add(btn6, 2, 2);
        mallaBotones.add(btnMultiplicacion, 3, 2);
        
        mallaBotones.add(btn1, 0, 3);
        mallaBotones.add(btn2, 1, 3);
        mallaBotones.add(btn3, 2, 3);
        mallaBotones.add(btnResta, 3, 3);
        
        mallaBotones.add(btn0, 0, 4);
        mallaBotones.add(btnPunto, 1, 4);
        mallaBotones.add(btnSuma, 2, 4);
        mallaBotones.add(btnResultado, 3, 4); 
        
        contenedorPrincipal.getChildren().addAll(panelNumerico, mallaBotones);     
    }
    
    public VBox getView(){
        return contenedorPrincipal;
    }
    
    private Button crearBotonNumero(String digito){
        Button boton = new Button(digito);
        boton.setPrefSize(50, 50);
        boton.setStyle("-fx-background-color: #FFFFFF; -fx-text-fill: #37474F; -fx-background-radius: 8px; -fx-cursor: hand;");
        boton.setFont(Font.font("Segoe UI", FontWeight.BOLD, 18));
        boton.setOnAction(e -> coreController.registrarAccion(digito, panelNumerico));
        return boton;
    }
    
    private Button crearBotonOperacion(String signo){
        Button boton = new Button(signo);
        boton.setPrefSize(50, 50);
        boton.setStyle("-fx-background-color: #26A69A; -fx-text-fill: white; -fx-background-radius: 8px; -fx-cursor: hand;");
        boton.setFont(Font.font("Segoe UI", FontWeight.BOLD, 18));
        boton.setOnAction(e -> coreController.registrarAccion(signo, panelNumerico));
        return boton;
    }
}