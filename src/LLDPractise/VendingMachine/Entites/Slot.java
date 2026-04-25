package LLDPractise.VendingMachine.Entites;

public class Slot {

    private final Product product;
    private int quantity;

    public Slot(Product product, int quantity){
        this.product = product;
        this.quantity = quantity;
    }

    public synchronized boolean isAvailable(){
        return quantity > 0;
    }

    public synchronized void dispense(){
        if(quantity <= 0){
            throw new RuntimeException("Out of Stock");
        }
        quantity--;
    }

    public int getQuantity(){
        return quantity;
    }

    public Product getProduct(){
        return product;
    }

    public synchronized void restock(int qty){
        quantity += qty;
    }

}
