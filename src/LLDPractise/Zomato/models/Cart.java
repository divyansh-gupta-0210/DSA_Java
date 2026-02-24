package LLDPractise.Zomato.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private Restaurant restaurant;
    private List<MenuItem> items = new ArrayList<>();

    public Cart(){
        restaurant = null;
    }

    public void addItem(MenuItem item){
        if(restaurant == null){
            System.out.println("Cart: Set a res before adding items");
            return;
        }
        items.add(item);
    }

    public int getTotalCost(){
        int sum = 0;
        for(MenuItem it : items){
            sum += it.getPrice();
        }
        return sum;
    }

    public void clear(){
        items.clear();
        restaurant = null;
    }

    public boolean isEmpty(){
        return restaurant == null || items.isEmpty();
    }

    public void setRestaurant(Restaurant r) {
        restaurant = r;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<MenuItem> getItems() {
        return items;
    }

}
