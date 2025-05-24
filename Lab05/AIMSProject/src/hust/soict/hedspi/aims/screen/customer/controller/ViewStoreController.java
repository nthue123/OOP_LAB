package hust.soict.hedspi.aims.screen.customer.controller;
import hust.soict.hedspi.aims.cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;

public class ViewStoreController {
    private Store store;
    private Cart cart;

    public ViewStoreController(Store store) {
        this.store = store;
    }
    public void ItemController(Cart cart) {
        this.cart = cart;
    }
    @FXML
    private GridPane gridPane;

    @FXML
    void Scoll(ActionEvent event) {

    }
    @FXML
    public void initialize() {
        final String ITEM_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Item.fxml";
        int column = 0;
        int row = 1;

        for(int i = 0; i < store.getItemsInStore().size(); i++) {
            try {
                FXMLLoader fxmlloader = new FXMLLoader();
                fxmlloader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));

                hust.soict.hedspi.aims.screen.customer.controller.ItemController itemController = new ItemController(cart);
                fxmlloader.setController(itemController);

                AnchorPane anchorPane = new AnchorPane();
                anchorPane = fxmlloader.load();

                itemController.setData(store.getItemsInStore().get(i));

                if (column == 3) {
                    column = 0;
                    row++;
                }

                gridPane.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(20, 10, 10, 10));

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
