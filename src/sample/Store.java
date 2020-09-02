package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Store {
    private static TextField nameInput,quantityInput;
    private static TableView<Product> table;
    public static void display(String storeName ){
        Stage window=new Stage();
        window.initModality(Modality.APPLICATION_MODAL);

        VBox layout=new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        //nameColumn
        TableColumn<Product,String> nameColumn=new TableColumn<>("Item");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //needColumn
        TableColumn<Product, CheckBox> needColumn=new TableColumn<>("Need");
        needColumn.setMinWidth(200);
        needColumn.setCellValueFactory(new PropertyValueFactory<>("need"));

        //quantityColumn
        TableColumn<Product,String> quantityColumn=new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(200);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //Name input
        nameInput=new TextField();
        nameInput.setPromptText("Name");

        //Quantity input
        quantityInput=new TextField();
        quantityInput.setPromptText("Quantity");

        //Add & Delete Button
        Button addButton=new Button("Add");
        addButton.setOnAction(e ->addButtonClicked());
        Button deleteButton=new Button("Delete");
        //deleteButton.setOnAction(e-> deleteButtonClicked());

        HBox hBox=new HBox();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput,quantityInput,addButton,deleteButton);

        table=new TableView<>();
        table.setItems(getProduct(storeName));
        table.getColumns().addAll(nameColumn,needColumn,quantityColumn);

        layout.getChildren().addAll(table,hBox);
        window.setTitle("shoppingList");
        window.setScene(new Scene(layout,650,400));
        window.showAndWait();


    }

    private static ObservableList<Product> getProduct(String storeName){
        ObservableList<Product> products= FXCollections.observableArrayList();
        if(storeName=="Aldi"){
            products.add(new Product("Rice",1));
            products.add(new Product("Milk",1));
            products.add(new Product("Bread",1));
            products.add(new Product("Cucumber",1));
            products.add(new Product("Tomato",5));

        }else if(storeName=="Dm"){
            products.add(new Product("Shampoo",2));
            products.add(new Product("Soap",1));
            products.addAll(new Product("Candle",1),
                    new Product("Toothpaste",0),
                    new Product("Handcreme",1));
        }else if(storeName =="Rewe"){
            products.addAll(new Product("Bread",3),
                    new Product("Chocolate",1));
        }else if(storeName=="Edeka"){
            products.addAll(new Product("Milk",1),
                    new Product("Yogurt",1),
                    new Product("Eggs",6));

        }
        return products;
    }
    private static void addButtonClicked(){
        Product product=new Product();
        try {
            product.setName(nameInput.getText());
            CheckBox checkBox=new CheckBox();
            checkBox.setSelected(true);
            product.setNeed(checkBox);
            product.setQuantity(Integer.parseInt(quantityInput.getText()));
            table.getItems().add(product);
            nameInput.clear();
            quantityInput.clear();
        }catch (NumberFormatException e){
            System.out.println("Enter a product name");
        }

    }


}
