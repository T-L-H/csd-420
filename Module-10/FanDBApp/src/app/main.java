// Tevyah Hanley 12/13/2025 M10 Programming Assignment
// This program creates a JavaFX application that connects to a MySQL database to view and update fan information.

package app;

import app.db.MySqlFanDao;
import app.ui.FanController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class main extends Application {

    @Override
    public void start(Stage stage) {
        String url = "jdbc:mysql://127.0.0.1:3307/databasedb?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
        String user = "student1";
        String pass = "pass";

        FanController c = new FanController(new MySqlFanDao(url, user, pass));

        GridPane root = new GridPane();
        root.setPadding(new Insets(14));
        root.setHgap(10);
        root.setVgap(10);

        int r = 0;
        root.add(new Label("ID:"), 0, r);              root.add(c.idField, 1, r++);
        root.add(new Label("First Name:"), 0, r);      root.add(c.firstField, 1, r++);
        root.add(new Label("Last Name:"), 0, r);       root.add(c.lastField, 1, r++);
        root.add(new Label("Favorite Team:"), 0, r);   root.add(c.teamField, 1, r++);

        root.add(c.displayBtn, 0, r);
        root.add(c.updateBtn, 1, r++);
        root.add(c.status, 0, r, 2, 1);

        stage.setTitle("Fans Viewer / Updater");
        stage.setScene(new Scene(root, 420, 260));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
