package hust.soict.hedspi.aims.store;

import hust.soict.hespi.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public Media getMedia(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equals(title)) {
                return media;
            }
        }
        return null;
    }

    public void addMedia(Media item) {
        if (!itemsInStore.contains(item)) {
            itemsInStore.add(item);
            System.out.println("The item has been added");
        } else {
            System.out.println("The item existed");
        }
    }

    public void removeMedia(Media item){
        if(!itemsInStore.isEmpty()){
            if(itemsInStore.contains(item)){
                itemsInStore.remove(item);
                System.out.println("The item has been removed");
            }
            System.out.println("The item is not in the cart");
        }
        else {
            System.out.println("The cart is empty");
        }
    }

    public void removeMedia (String title) {
        itemsInStore.remove(getMedia(title));
    }

    public void print() {
        System.out.println("Items in store: ");
        for (Media media : itemsInStore) {
            System.out.println(media.toString());
        }
    }

}