package LLDPractise.VendingMachine.State;

import LLDPractise.VendingMachine.Entites.Denomination;
import LLDPractise.VendingMachine.VendingMachine;

public class HasMoneyState implements State{
    @Override
    public void insertMoney(VendingMachine machine, Denomination denomination) {
        machine.getTransaction().insertMoney(denomination);
    }

    @Override
    public void selectProduct(VendingMachine machine, int code) {
        machine.setSelectedSlot(code);
        machine.setState(new DispenseState());
    }

    @Override
    public void dispense(VendingMachine machine) {
        throw new RuntimeException("Select Product");
    }
}
