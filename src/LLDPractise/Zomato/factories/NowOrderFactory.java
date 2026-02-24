package LLDPractise.Zomato.factories;

import LLDPractise.Zomato.Strategy.PaymentStrategy;
import LLDPractise.Zomato.models.*;
import LLDPractise.Zomato.utils.TimeUtils;

import java.util.List;

public class NowOrderFactory implements OrderFactory{

    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> items,
                             PaymentStrategy paymentStrategy, int totalCost, String orderType)
    {
        Order order = null;
        if(orderType.equals("Delivery")){
            DeliveryOrder deliveryOrder = new DeliveryOrder();
            deliveryOrder.setUserAddress(user.getAddress());
            order = deliveryOrder;
        }
        else{
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
            order = pickupOrder;
        }
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setItems(items);
        order.setPaymentStrategy(paymentStrategy);
        order.setScheduled(TimeUtils.getCurrentTime());
        order.setTotal(totalCost);
        return order;
    }

}
