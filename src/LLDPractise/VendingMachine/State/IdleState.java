package LLDPractise.VendingMachine.State;

import LLDPractise.VendingMachine.Entites.Denomination;
import LLDPractise.VendingMachine.VendingMachine;

public class IdleState implements State{


    @Override
    public void insertMoney(VendingMachine machine, Denomination denomination) {
        machine.getTransaction().insertMoney(denomination);
        machine.setState(new HasMoneyState());
    }

    @Override
    public void selectProduct(VendingMachine machine, int code) {
        throw new RuntimeException("Select product");
    }

    @Override
    public void dispense(VendingMachine machine) {
        throw new RuntimeException("No transaction started");
    }
}
