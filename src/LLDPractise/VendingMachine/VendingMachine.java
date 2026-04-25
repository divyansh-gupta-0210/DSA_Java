package LLDPractise.VendingMachine;

import LLDPractise.VendingMachine.Entites.Denomination;
import LLDPractise.VendingMachine.Entites.Product;
import LLDPractise.VendingMachine.Entites.Slot;
import LLDPractise.VendingMachine.State.IdleState;
import LLDPractise.VendingMachine.State.State;
import LLDPractise.VendingMachine.Strategy.ChangeStrategy;
import LLDPractise.VendingMachine.Strategy.DefaultChangeStrategy;

import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class VendingMachine {

    public static VendingMachine instance;
    private final InventoryManagement inventoryManagement = new InventoryManagement();
    public TransactionManagement transactionManagement = new TransactionManagement();
    private final ChangeStrategy strategy = new DefaultChangeStrategy();

    private final ReentrantLock lock = new ReentrantLock();
    private State currentState = new IdleState();
    private int selectedSlot;
    private int totalMoneyCollected = 0;

    private VendingMachine(){}

    public static synchronized VendingMachine getInstance(){
        if(instance == null){
            instance = new VendingMachine();
        }
        return instance;
    }

    public void insertMoney(Denomination denomination){
        lock.lock();
        try{
            currentState.insertMoney(this, denomination);
        }
        finally {
            lock.unlock();
        }
    }

    public void selectProduct(int code){
        lock.lock();
        try{
            currentState.selectProduct(this, code);
        }
        finally {
            lock.unlock();
        }
    }

    public void dispense(){
        lock.lock();
        try {
            currentState.dispense(this);
        }
        finally {
            lock.unlock();
        }
    }

    public void restock(int code, Product product, int qty){
        inventoryManagement.addSlot(code, new Slot(product, qty));
    }

    public int collectCash(){
        int cash = totalMoneyCollected;
        totalMoneyCollected = 0;
        return cash;
    }

    public void processDispense(){
        Slot slot = inventoryManagement.getSlot(selectedSlot);
        if(!slot.isAvailable()){
            throw new RuntimeException("Out of Stock");
        }
        int price = slot.getProduct().getPrice();
        int paid = transactionManagement.getTotalInserted();
        if(paid < price){
            throw new RuntimeException("Insufficient funds");
        }
        slot.dispense();
        totalMoneyCollected += price;
        int change = paid - price;
        Map<Denomination, Integer> changeMap = strategy.calculateChange(change);
        System.out.println("Dispensed: " + slot.getProduct().getName());
        System.out.println("Change Returned: " + changeMap);
        transactionManagement.reset();
    }

    public TransactionManagement getTransaction(){
        return transactionManagement;
    }

    public void setState(State state){
        this.currentState = state;
    }

    public void setSelectedSlot(int slot){
        this.selectedSlot = slot;
    }

}
