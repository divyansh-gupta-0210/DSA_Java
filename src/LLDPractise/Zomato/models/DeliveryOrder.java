package LLDPractise.Zomato.models;

public class DeliveryOrder extends Order{

    private String userAddress;

    public DeliveryOrder(){
        userAddress = "";
    }

    @Override
    public String getType(){
        return "Delivery";
    }

    public void setUserAddress(String address) {
        userAddress = address;
    }

    public String getUserAddress() {
        return userAddress;
    }

}
