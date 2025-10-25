// Tevyah Hanley 10/25/2025 M11.3 Programming Assignment
// This program randomly displays four playing card images and refreshes them when a button is clicked.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.*;

public class main extends Application {
    @Override
    public void start(Stage stage) {
        HBox cardBox = new HBox(10);
        Button refresh = new Button("Refresh");
        VBox root = new VBox(10, cardBox, refresh);
        refresh.setOnAction(e -> {
            cardBox.getChildren().clear();
            List<Integer> cards = new ArrayList<>();
            for (int i = 1; i <= 52; i++) cards.add(i);
            Collections.shuffle(cards);
            for (int i = 0; i < 4; i++)
                cardBox.getChildren().add(new ImageView(new Image(new java.io.File("cards/" + cards.get(i) + ".png").toURI().toString())));
        });
        refresh.fire();
        stage.setScene(new Scene(root));
        stage.setTitle("main");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}

