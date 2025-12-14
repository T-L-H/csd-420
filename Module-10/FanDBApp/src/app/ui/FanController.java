package app.ui;

import app.db.Fan;
import app.db.FanDao;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;
import java.util.Optional;

public class FanController {

    private final FanDao dao;

    public final TextField idField = new TextField();
    public final TextField firstField = new TextField();
    public final TextField lastField = new TextField();
    public final TextField teamField = new TextField();

    public final Button displayBtn = new Button("Display");
    public final Button updateBtn = new Button("Update");

    public final Label status = new Label();

    public FanController(FanDao dao) {
        this.dao = dao;
        displayBtn.setOnAction(e -> onDisplay());
        updateBtn.setOnAction(e -> onUpdate());
    }

    private Integer readId() {
        String raw = idField.getText().trim();
        if (raw.isEmpty()) {
            status.setText("Enter an ID.");
            return null;
        }
        try {
            int id = Integer.parseInt(raw);
            if (id <= 0) {
                status.setText("ID must be a positive integer.");
                return null;
            }
            return id;
        } catch (NumberFormatException ex) {
            status.setText("ID must be an integer.");
            return null;
        }
    }

    public void onDisplay() {
        Integer id = readId();
        if (id == null) return;

        try {
            Optional<Fan> fanOpt = dao.findById(id);
            if (fanOpt.isEmpty()) {
                firstField.clear();
                lastField.clear();
                teamField.clear();
                status.setText("No record found for ID " + id);
                return;
            }

            Fan f = fanOpt.get();
            firstField.setText(nvl(f.getFirstname()));
            lastField.setText(nvl(f.getLastname()));
            teamField.setText(nvl(f.getFavoriteteam()));
            status.setText("Loaded ID " + id);

        } catch (SQLException ex) {
            status.setText("DB error: " + ex.getMessage());
        }
    }

    public void onUpdate() {
        Integer id = readId();
        if (id == null) return;

        Fan fan = new Fan(
                id,
                firstField.getText().trim(),
                lastField.getText().trim(),
                teamField.getText().trim()
        );

        try {
            boolean ok = dao.update(fan);
            status.setText(ok ? ("Updated ID " + id) : ("Update failed (ID not found): " + id));
        } catch (SQLException ex) {
            status.setText("DB error: " + ex.getMessage());
        }
    }

    private static String nvl(String s) {
        return s == null ? "" : s;
    }
}
