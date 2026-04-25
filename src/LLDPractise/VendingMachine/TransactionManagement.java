package LLDPractise.VendingMachine;

import LLDPractise.VendingMachine.Entites.Denomination;

import java.util.ArrayList;
import java.util.List;

public class TransactionManagement {

    private int totalInserted = 0;
    private final List<Denomination> insertedMoney = new ArrayList<>();

    public void insertMoney(Denomination denomination){
        insertedMoney.add(denomination);
        totalInserted = totalInserted + denomination.getValue();
    }

    public int getTotalInserted(){
        return totalInserted;
    }

    public void reset(){
        totalInserted = 0;
        insertedMoney.clear();
    }

}
