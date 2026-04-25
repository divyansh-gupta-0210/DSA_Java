package LLDPractise.VendingMachine;

import LLDPractise.VendingMachine.Entites.Slot;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class InventoryManagement {

    private final Map<Integer, Slot> slots = new HashMap<>();

    public synchronized void addSlot(int code, Slot slot){
        slots.put(code, slot);
    }

    public synchronized Slot getSlot(int code){
        if(!slots.containsKey(code)){
            throw new RuntimeException("Invalid slot selected");
        }
        return slots.get(code);
    }

    public synchronized void restock(int code, int quantity){
        getSlot(code).restock(quantity);
    }

    public synchronized Map<Integer, Slot> getAllSlots(){
        return Collections.unmodifiableMap(slots);
    }

}
