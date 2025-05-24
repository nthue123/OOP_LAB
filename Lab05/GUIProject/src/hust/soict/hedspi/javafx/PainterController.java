package hust.soict.hedspi.javafx;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.awt.event.ActionEvent;

public class PainterController {
    private Paint currentColor = Color.BLACK;
    @FXML
    private RadioButton eraserRadioButton;
    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(javafx.scene.input.MouseEvent event) {
        Color color;
        if (eraserRadioButton.isSelected()) {
            color = Color.WHITE; // Màu nền = xóa
        } else {
            color = Color.BLACK; // Bút vẽ
        }
        Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        drawingAreaPane.getChildren().add(newCircle);

    }

}
