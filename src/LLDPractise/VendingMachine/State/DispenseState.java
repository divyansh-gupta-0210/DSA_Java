package LLDPractise.VendingMachine.State;

import LLDPractise.VendingMachine.Entites.Denomination;
import LLDPractise.VendingMachine.VendingMachine;

public class DispenseState implements State{
    @Override
    public void insertMoney(VendingMachine machine, Denomination denomination) {
        throw new RuntimeException("Processing transaction");
    }

    @Override
    public void selectProduct(VendingMachine machine, int code) {
        throw new RuntimeException("Already Started");
    }

    @Override
    public void dispense(VendingMachine machine) {
        machine.processDispense();
        machine.setState(new IdleState());
    }
}
