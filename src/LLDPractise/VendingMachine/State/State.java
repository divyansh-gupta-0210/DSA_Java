package LLDPractise.VendingMachine.State;

import LLDPractise.VendingMachine.Entites.Denomination;
import LLDPractise.VendingMachine.VendingMachine;

public interface State {
    void insertMoney(VendingMachine machine, Denomination denomination);
    void selectProduct(VendingMachine machine, int code);
    void dispense(VendingMachine machine);
}
