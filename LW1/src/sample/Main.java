package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

/**
 * Main class that includes variables and methods to create JafaFx application
 * If you have some question about JavaFx application:
 * @see javafx.application.Application
 *
 * @author Aliaksei Shchahrykovich
 * @version 1.00
 */
public class Main extends Application{

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("LabWork1");
        primaryStage.setResizable(false);

        /**
         * GridPane consist of rows and columns. In this implementation columns are represented by simple VBox.
         * @see VBox
         * @see GridPane
         */
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setPadding(new Insets(25,25,25,25));

        Scene scene = new Scene(grid,500,100);
        primaryStage.setScene(scene);

        TextField[] textFields = {new TextField(), new TextField(), new TextField()};


        Button btn1to2 = new Button("Копировать 1 в 2");
        Button btn2to3 = new Button("Копировать 2 в 3");
        btn1to2.setOnAction(new MouseListener<MouseEvent>(){


            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }
            public void mouseExited(MouseEvent e){

            }

                                @Override
                                public void mousePressed(MouseEvent e) {

                                }
                            }
        );

        btn2to3.setOnAction(new EventHandler<ActionEvent>() {
            /**
             * Method that handle event from central button
             * @param event
             */
            @Override
            public void handle(ActionEvent event) {
                textFields[2].setText(textFields[1].getText());
            }
        });

        VBox vbClmn1 = new VBox(10);
        vbClmn1.getChildren().addAll(new Label("1"), textFields[0], btn1to2);
        vbClmn1.setAlignment(Pos.CENTER);
        vbClmn1.setMaxWidth(115);

        VBox vbClmn2 = new VBox(10);
        vbClmn2.getChildren().addAll(new Label("2"), textFields[1], btn2to3);
        vbClmn2.setAlignment(Pos.CENTER);
        vbClmn2.setMaxWidth(115);

        VBox vbClmn3 = new VBox(11);
        vbClmn3.getChildren().addAll(new Label("3"), textFields[2]);
        vbClmn3.setAlignment(Pos.TOP_CENTER);
        vbClmn3.setMaxWidth(115);

        grid.add(vbClmn1,0,0);
        grid.add(vbClmn2,1,0);
        grid.add(vbClmn3,2,0);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
