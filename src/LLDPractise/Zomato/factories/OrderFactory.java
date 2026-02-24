package LLDPractise.Zomato.factories;

import LLDPractise.Zomato.Strategy.PaymentStrategy;
import LLDPractise.Zomato.models.Order;
import LLDPractise.Zomato.models.*;

import java.util.List;

public interface OrderFactory {
    Order createOrder(User user, Cart cart, Restaurant restaurant, List<MenuItem> menuItems,
                      PaymentStrategy paymentStrategy, int totalCost, String orderType);
}
