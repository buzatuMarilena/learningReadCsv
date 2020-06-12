package midQuizz;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MidQuizz extends Application {

    /**
     * MID QUIZZ
     * You need to design an application that allows the possibility to calculate the surface and
     * perimeter for multiple types of shape: rectangle, square, circle and triangle.
     *  
     */


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Marilena Deseneaza");

        Circle circle = new Circle(60,260,50);

        /**
         * Add cerc
         * */

        Label lblRazaCerc = new Label("Raza Cerc: ");
        lblRazaCerc.setTextFill(Color.GREEN);

        TextField txtRazaCerc = new TextField();
        txtRazaCerc.setMaxWidth(50);

        TextArea displayRezultatCerc = new TextArea();
        displayRezultatCerc.setMinSize(210,30);
        displayRezultatCerc.setMaxSize(210,30);
        displayRezultatCerc.setEditable(false);

        Button btnCalculArieCerc = new Button();
        btnCalculArieCerc.setText("Calculeaza");
        btnCalculArieCerc.setOnAction(e -> {
            if(txtRazaCerc.getText().isEmpty()){
                displayRezultatCerc.setText("Introdu raza");
            }else{
                displayRezultatCerc.setText( calculCERC(txtRazaCerc.getText()));
            }
        });


        /**
         * Add dreptunghi
         * */
        Rectangle dreptunghi = new Rectangle(10, 100, 100, 50);

        Label lblDreptunghi = new Label("Lungime & Latime: ");
        lblDreptunghi.setTextFill(Color.GREEN);

        TextField txtLungimeDreptunghi = new TextField();
        txtLungimeDreptunghi.setMaxWidth(50);

        TextField txtLatimeDreptunghi = new TextField();
        txtLatimeDreptunghi.setMaxWidth(50);

        TextArea displayRezultatDreptunghi = new TextArea();
        displayRezultatDreptunghi.setMinSize(210,30);
        displayRezultatDreptunghi.setMaxSize(210,30);
        displayRezultatDreptunghi.setEditable(false);

        Button btnCalculDreptunghi = new Button();
        btnCalculDreptunghi.setText("Calculeaza");
        btnCalculDreptunghi.setOnAction(e -> {
            if(txtLatimeDreptunghi.getText().isEmpty() || txtLungimeDreptunghi.getText().isEmpty()){
                displayRezultatDreptunghi.setText("Introdu datele");
            }else{
                displayRezultatDreptunghi.setText( calculDREPTUNGHI(txtLatimeDreptunghi.getText(),txtLungimeDreptunghi.getText()));
            }
        });

        /**
         * Add triunghi
         * */

        Polyline triangle = new Polyline(50, 0,  0, 50,100, 50, 50, 0);
        triangle.setFill(Color.BLACK);

        Label lblTriunghi = new Label("Baza Inaltime L1 L2 ");
        lblTriunghi.setTextFill(Color.GREEN);

        TextField txtBaza = new TextField();
        txtBaza.setMaxWidth(50);
        TextField txtInaltime = new TextField();
        txtInaltime.setMaxWidth(50);
        TextField txtL1 = new TextField();
        txtL1.setMaxWidth(50);
        TextField txtL2 = new TextField();
        txtL2.setMaxWidth(50);

        TextArea displayRezultatTriunghi = new TextArea();
        displayRezultatTriunghi.setMinSize(210,30);
        displayRezultatTriunghi.setMaxSize(210,30);
        displayRezultatTriunghi.setEditable(false);

        Button btnCalculTriunghi = new Button();
        btnCalculTriunghi.setText("Calculeaza");
        btnCalculTriunghi.setOnAction(e ->{
            if(txtBaza.getText().isEmpty() || txtInaltime.getText().isEmpty()||txtL1.getText().isEmpty()||txtL2.getText().isEmpty())
                displayRezultatTriunghi.setText("Introdu datele");
            else
                displayRezultatTriunghi.setText(calculTRIUNGHI(txtBaza.getText(),txtInaltime.getText(),txtL1.getText(),txtL2.getText()));
        });


        /**
         * Add patrat
         * */

        Rectangle patrat = new Rectangle(10, 350, 100, 100);

        Label lblPatrat = new Label("Lungime Latura: ");
        lblPatrat.setTextFill(Color.GREEN);

        TextField txtLaturaPatrat = new TextField();
        txtLaturaPatrat.setMaxWidth(50);

        TextArea displayRezultatPatrat = new TextArea();
        displayRezultatPatrat.setMinSize(210,30);
        displayRezultatPatrat.setMaxSize(210,30);
        displayRezultatPatrat.setEditable(false);

        Button btnCalculPatrat = new Button();
        btnCalculPatrat.setText("Calculeaza");
        btnCalculPatrat.setOnAction(e -> {
            if(txtLaturaPatrat.getText().isEmpty()){
                displayRezultatPatrat.setText("Introdu datele");
            }else{
                displayRezultatPatrat.setText( calculDREPTUNGHI(txtLaturaPatrat.getText(),txtLaturaPatrat.getText()));
            }
        });



        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(30);
        //Coloana 1
        grid.add(circle,0,0);
        grid.add(dreptunghi, 0 ,1);
        grid.add(triangle,0,2);
        grid.add(patrat, 0 ,3);

        //Rand 1 cerc
        grid.add(lblRazaCerc, 1,0);
        grid.add(txtRazaCerc, 2,0);
        grid.add(btnCalculArieCerc, 6,0);
        grid.add(displayRezultatCerc, 7,0);

        //Rand2 dreptunghi
        grid.add(lblDreptunghi, 1,1);
        grid.add(txtLatimeDreptunghi, 2,1);
        grid.add(txtLungimeDreptunghi, 3,1);
        grid.add(btnCalculDreptunghi, 6,1);
        grid.add(displayRezultatDreptunghi, 7,1);

        //Rand3 triunghi
        grid.add(lblTriunghi, 1,2);
        grid.add(txtBaza, 2,2);
        grid.add(txtInaltime, 3,2);
        grid.add(txtL1, 4,2);
        grid.add(txtL2, 5,2);
        grid.add(btnCalculTriunghi, 6,2);
        grid.add(displayRezultatTriunghi, 7,2);

        //Rand2 patrat
        grid.add(lblPatrat, 1,3);
        grid.add(txtLaturaPatrat, 2,3);
        grid.add(btnCalculPatrat, 6,3);
        grid.add(displayRezultatPatrat, 7,3);





        Group root = new Group(grid);

        // Group root = new Group(circle, dreptunghi, triangle,patrat, hbox);

        Scene scene = new Scene(root, 1200, 600);


//
//        HBox hbox = new HBox();
//        javafx.scene.control.Label label1 = new javafx.scene.control.Label("Test");
//        hbox.setSpacing(110);
//        hbox.getChildren().add(label1);
//        ((Group)scene.getRoot()).getChildren().add(hbox);

        primaryStage.setScene(scene);


        primaryStage.show();

    }

    /**
     * CERC
     * arie : π * r^2
     * circumferinta c=2*πr
     */

    public static String calculCERC(String raza){

        Integer intRaza = Integer.valueOf(raza);
        return "Aria: π"+intRaza*intRaza+" Circumferinta: π"+2*intRaza;
    }

    public static String calculDREPTUNGHI(String latime, String lungime){
        Integer intLatime = Integer.valueOf(latime);
        Integer intLungime = Integer.valueOf(lungime);
        return "Aria: "+intLatime*intLungime+" Perimetrul: "+2*(intLatime+intLungime);
    }

    public static String calculTRIUNGHI(String baza, String inaltime, String l1, String l2){
        Integer intBaza = Integer.valueOf(baza);
        Integer intInaltime = Integer.valueOf(inaltime);
        Integer intL1 = Integer.valueOf(l1);
        Integer intL2 = Integer.valueOf(l2);
        return "Aria: "+(double)(intBaza*intInaltime)/2+" Perimetrul: "+ (intBaza+intL1+intL2);
    }

    public static void main(String args[]){
        launch(args);
    }
}
