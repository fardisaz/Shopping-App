package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception{
        window=primaryStage;
        window.setTitle("Shopping App");


        Label label=new Label("Where do you want to go today?");
        label.setFont(new Font(20));
        ChoiceBox choiceBox=new ChoiceBox();
        choiceBox.getItems().addAll("Dm","Aldi","Rewe","Edeka","Others");
        choiceBox.setMinWidth(120);
        //choiceBox.setValue("Aldi");
        choiceBox.getSelectionModel().selectedItemProperty().addListener((v,oldValue,newValue)->{
            Store.display(newValue.toString());

        });

        GridPane grid=new GridPane();
        grid.setPadding(new Insets(10,10,10,10));
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.add(label,0,0);
        grid.add(choiceBox,1,0);

        window.setScene(new Scene(grid, 700, 500));
        window.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

}
