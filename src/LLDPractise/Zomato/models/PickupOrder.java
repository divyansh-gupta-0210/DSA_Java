package LLDPractise.Zomato.models;

public class PickupOrder extends Order{

    private String restaurantAddress;

    @Override
    public String getType(){
        return "PickUp";
    }

    public void setRestaurantAddress(String address){
        this.restaurantAddress = address;
    }
    public String getRestaurantAddress(){
        return restaurantAddress;
    }

}
