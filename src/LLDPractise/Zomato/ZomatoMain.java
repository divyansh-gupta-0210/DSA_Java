package LLDPractise.Zomato;

import LLDPractise.Zomato.Strategy.UPIPaymentStrategy;
import LLDPractise.Zomato.models.*;

public class ZomatoMain {
    public static void main(String[] args) {

        ZomatoApp zomato = new ZomatoApp();

        User user = new User(101, "Aditya", "Delhi");
        System.out.println("User: " + user.getName() + " is active.");

        java.util.List<Restaurant> restaurantList = zomato.searchRestaurants("Delhi");

        if (restaurantList.isEmpty()) {
            System.out.println("No restaurants found!");
            return;
        }

        System.out.println("Found Restaurants:");
        for (Restaurant restaurant : restaurantList) {
            System.out.println(" - " + restaurant.getName());
        }

        zomato.selectRestaurant(user, restaurantList.get(0));
        System.out.println("Selected restaurant: " + restaurantList.get(0).getName());

        zomato.addToCart(user, "P1");
        zomato.addToCart(user, "P2");

        zomato.printUserCart(user);

        // User checkout the cart
        Order order = zomato.checkoutNow(user, "Delivery", new UPIPaymentStrategy("1234567890"));

        // User pays for the cart. If payment is successful, notification is sent.
        zomato.payForOrder(user, order);
    }
}
