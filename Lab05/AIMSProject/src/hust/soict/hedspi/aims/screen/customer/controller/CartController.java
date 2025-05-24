package hust.soict.hedspi.aims.screen.customer.controller;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


import javax.naming.LimitExceededException;
import java.awt.event.ActionEvent;
import java.io.IOException;

import static hust.soict.hedspi.test.screen.customer.store.TestViewStoreScreen.store;

public class CartController {
    private static final int MAX_NUMBERS_ORDERED = 100;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    private Cart cart;

    public CartController(Store store, Cart cart) {
        this.cart = cart;
    }
    void btnViewCartPressed(ActionEvent event) {
        try {
            final String CART_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Cart.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            fxmlLoader.setController(new CartController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void addMedia(Media media) throws LimitExceededException {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED) {
            throw new LimitExceededException("ERROR: Cart is full.");
        }
        itemsOrdered.add(media);
    }
    @FXML
    public void initialize() {
        // Thiết lập liên kết giữa cột và thuộc tính của đối tượng Media
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        // Kiểm tra và gán dữ liệu từ giỏ hàng vào TableView
        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }
    }
    void updateButtonBar(Media media) {
        if (media == null) {
            // Ẩn tất cả nút khi không có media nào được chọn
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        }
        else {
            // Luôn hiển thị nút xóa khi có media được chọn
            btnRemove.setVisible(true);

            // Chỉ hiển thị nút play nếu media có thể phát được
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            }
            else {
                btnPlay.setVisible(false);
            }
        }
    }
    @FXML
    public void initialize() {
        // Thiết lập liên kết giữa các cột TableView và thuộc tính của đối tượng Media
        colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
        colMediaCategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
        colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("cost"));

        // Gán dữ liệu từ giỏ hàng vào TableView nếu có
        if (cart.getItemsOrdered() != null) {
            tblMedia.setItems(cart.getItemsOrdered());
        }

        // Ẩn các nút chức năng ban đầu
        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        // Lắng nghe sự kiện chọn item trong TableView
        tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
            @Override
            public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                updateButtonBar(newValue);
            }
        });
    }
    public class PlayerException extends Exception {
        public PlayerException(String message) {
            super(message);
        }
    }

    @FXML private TableView<Media> colMediald;
    @FXML private TableColumn<Media, String> colMediaTitle;
    @FXML private TableColumn<Media, String> colMediaCategory;
    @FXML private TableColumn<Media, Float> colMediaCost;

    private Label costLabel;

    @FXML
    private TableView<?> tblMedia;


    @FXML
    private ToggleGroup filterCategory;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;


    @FXML
    void btnRemovePressed(ActionEvent event) {
        Object media = (Media) tblMedia.getSelectionModel().getSelectedItem();
        cart.removeMedia((Media) media);
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {

    }

}
