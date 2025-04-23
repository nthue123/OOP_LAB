package hust.soict.hespi.aims.cart;

import hust.soict.hespi.aims.media.DigitalVideoDisc;
import hust.soict.hespi.aims.media.Media;

import java.util.ArrayList;
import java.util.Scanner;

public class Cart {
    Scanner input = new Scanner(System.in);
    public static final int MAX_QUANTITY = 20;
    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    public void addMedia(Media item) {
        if (itemsOrdered.size() < MAX_QUANTITY && !itemsOrdered.contains(item)) {
            itemsOrdered.add(item);
        } else {
            System.out.println("The cart is almost full");
        }
    }

    public void removeMedia(Media item){
        if(!itemsOrdered.isEmpty()){
            if(itemsOrdered.contains(item)){
                itemsOrdered.remove(item);
            }
            else System.out.println("The item is not in the cart");
        }
        else {
            System.out.println("The cart is empty");
        }
    }

    public float totalCost(){
        float total = 0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
        }
        return total;
    }

    public void displayCart(){
        System.out.println("******************CART******************");
        System.out.println("Ordered Items: ");
        for(int i = 0; i < itemsOrdered.size(); i++){
            System.out.println(i + 1 + ". " + itemsOrdered.get(i).toString());
        }
        System.out.println("****************************************");
    }

    public Media idSearch(int id){
        for(Media item : itemsOrdered)
        {
            if(item.getId() == id)
            {
                return item;
            }
        }
        System.out.println("No ID matched");
        return null;
    }

    public Media titleSearch (String tittle) {
        for (Media item: itemsOrdered) {
            if (item.getTitle().equals(tittle)) {
                return item;
            }
        }
        System.out.println("No title matched");
        return null;
    }

    public void empty () {
        itemsOrdered = new ArrayList<>();
    }

    public void sortByTitle() {
        itemsOrdered.sort(Media.COMPARE_BY_TITLE_COST);
    }

    public void sortByPrice() {
        itemsOrdered.sort(Media.COMPARE_BY_COST_TITLE);
    }
}
