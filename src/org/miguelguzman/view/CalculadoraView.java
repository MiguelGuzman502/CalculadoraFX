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
    private VBox view; 
    private Label pantalla; 
    private GridPane cuadroBotones;     
    private CalculadoraController controller; 
    
    public CalculadoraView() {
        controller = new CalculadoraController(); 
        
        view = new VBox(0); // Cambiado a 0 para que no haya espacios en blanco arriba
        view.setAlignment(Pos.CENTER);
        view.setStyle("-fx-background-color: #FFFFFF"); // Fondo general blanco
        
        pantalla = new Label("0");
        pantalla.setFont(Font.font("Consolas", FontWeight.BOLD, 35)); 
        pantalla.setAlignment(Pos.CENTER_RIGHT); 
        
        // Hacemos que la pantalla use todo el ancho de la calculadora (266px) y le damos más altura
        pantalla.setPrefSize(266, 80); 
        pantalla.setPadding(new Insets(0, 20, 0, 20));
        
        // Quitamos los bordes redondeados para que se vea lleno y plano arriba
        pantalla.setStyle("-fx-background-color: #2F3640; -fx-text-fill: #FFFFFF;");
        
        cuadroBotones = new GridPane();
        cuadroBotones.setHgap(10);
        cuadroBotones.setVgap(10);
        cuadroBotones.setAlignment(Pos.CENTER);
        
        // Le agregamos un margen (padding) solo a la sección de botones para que no peguen al borde blanco
        cuadroBotones.setPadding(new Insets(15));
        
        Button btnCiento = accionBoton("%");
        
        Button btnUNo = nuevoBoton("1");
        Button btnDos = nuevoBoton("2");
        Button btnTres = nuevoBoton("3");
        Button btnCuatro = nuevoBoton("4");
        Button btnCinco = nuevoBoton("5");
        Button btnSeis = nuevoBoton("6");
        Button btnSiete = nuevoBoton("7");
        Button btnOcho = nuevoBoton("8");
        Button btnNueve = nuevoBoton("9");
        Button btnCero = nuevoBoton("0");
        
        Button btnPunto = accionBoton(".");
        Button btnIgual = accionBoton("=");
        btnIgual.setPrefSize(110, 50);
        
        Button btnMas = accionBoton("+");
        Button btnMenos = accionBoton("-");
        Button btnPor = accionBoton("x");
        Button btnDiv = accionBoton("÷");
        Button btnElevar = accionBoton("^");
        Button btnRaiz = accionBoton("√");
        
        // Posiciones del GridPane
        cuadroBotones.add(btnCiento, 0, 1);
        cuadroBotones.add(btnElevar, 1, 1);
        cuadroBotones.add(btnRaiz, 2, 1);
        cuadroBotones.add(btnDiv, 3, 1);
        
        cuadroBotones.add(btnSiete, 0, 2);
        cuadroBotones.add(btnOcho, 1, 2);
        cuadroBotones.add(btnNueve, 2, 2);
        cuadroBotones.add(btnPor, 3, 2);
        
        cuadroBotones.add(btnCuatro, 0, 3);
        cuadroBotones.add(btnCinco, 1, 3);
        cuadroBotones.add(btnSeis, 2, 3);
        cuadroBotones.add(btnMenos, 3, 3);
        
        cuadroBotones.add(btnUNo, 0, 4);
        cuadroBotones.add(btnDos, 1, 4);
        cuadroBotones.add(btnTres, 2, 4);
        cuadroBotones.add(btnMas, 3, 4);
        
        cuadroBotones.add(btnCero, 0, 5);
        cuadroBotones.add(btnPunto, 1, 5);
        cuadroBotones.add(btnIgual, 2, 5);
        GridPane.setColumnSpan(btnIgual, 2);
        
        view.getChildren().addAll(pantalla, cuadroBotones);     
    }
    
    public VBox getView(){
        return view;
    }
    
    // Botones numéricos (Gris claro)
    private Button nuevoBoton(String texto){
        Button btn = new Button(texto);
        btn.setPrefSize(50, 50);
        btn.setStyle("-fx-background-color: #E0E0E0; -fx-text-fill: black; -fx-background-radius: 5px; -fx-cursor: hand;");
        
        btn.setOnMousePressed(e -> {
            btn.setStyle("-fx-background-color: #CCCCCC; -fx-text-fill: black; -fx-background-radius: 5px;");
            btn.setTranslateY(2);
        });
        
        btn.setOnMouseReleased(e -> {
            btn.setStyle("-fx-background-color: #E0E0E0; -fx-text-fill: black; -fx-background-radius: 5px;");
            btn.setTranslateY(0);
        });
        
        btn.setFont(Font.font("Consolas", FontWeight.BOLD, 20));
        btn.setOnAction(e -> controller.procesoDeEntrada(texto, pantalla));
        
        return btn;
    }
    
    // Botones de operaciones (Azul moderno)
    private Button accionBoton(String texto){
        Button btn = new Button(texto);
        btn.setPrefSize(50, 50);
        btn.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-background-radius: 5px; -fx-cursor: hand;");
        
        btn.setOnMousePressed(e -> {
            btn.setStyle("-fx-background-color: #2980B9; -fx-text-fill: white; -fx-background-radius: 5px;");
            btn.setTranslateY(2);
        });
        
        btn.setOnMouseReleased(e -> {
            btn.setStyle("-fx-background-color: #3498DB; -fx-text-fill: white; -fx-background-radius: 5px;");
            btn.setTranslateY(0);
        });
        
        btn.setFont(Font.font("Consolas", FontWeight.BOLD, 20));
        btn.setOnAction(e -> controller.procesoDeEntrada(texto, pantalla));
        
        return btn;
    }
}