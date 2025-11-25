// Tevyah Hanley 11/25/2025 M7 Programming Assignment
// This program will make some really cool cicrles using CSS

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage primaryStage) {

        VBox leftBox = new VBox();
        leftBox.setPrefSize(80, 250);
        leftBox.getStyleClass().add("border"); 

        Circle leftCircle = new Circle(40);
        leftCircle.getStyleClass().add("plaincircle");
        leftBox.getChildren().add(leftCircle);

        Circle c1 = new Circle(40);
        c1.getStyleClass().add("plaincircle");

        Circle c2 = new Circle(40);
        c2.setId("redcircle");

        Circle c3 = new Circle(40);
        c3.setId("greencircle");

        HBox circles = new HBox(20, c1, c2, c3);

        HBox root = new HBox(20, leftBox, circles);

        Scene scene = new Scene(root, 500, 250);
        scene.getStylesheets().add("mystyle.css");

        primaryStage.setTitle("My Really Cool Circles!");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Minimal test
        System.out.println("Please say the CSS worked... " + !scene.getStylesheets().isEmpty());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
