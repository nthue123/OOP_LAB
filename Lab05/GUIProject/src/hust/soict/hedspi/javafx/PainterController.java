package hust.soict.hedspi.javafx;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        drawingAreaPane.getChildren().clear();
    }

    @FXML
    void drawingAreaMouseDragged(ActionEvent event) {
        Color color;
        if (eraserRadioButton.isSelected()) {
            color = Color.WHITE; // Màu nền = xóa
        } else {
            color = Color.BLACK; // Bút vẽ
        }
        Circle newCỉrcle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
        drawingAreaPane.getChildren().add(newCircle);

    }

}
