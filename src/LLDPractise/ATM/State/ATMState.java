package LLDPractise.ATM.State;

import LLDPractise.ATM.ATMSystem;
import LLDPractise.ATM.Entities.OperationType;

public interface ATMState {

    void insertCard(ATMSystem atmSystem, String cardNumber);
    void enterPin(ATMSystem atmSystem, String pin);
    void selectOperation(ATMSystem atmSystem, OperationType op, int... args);
    void ejectCard(ATMSystem atmSystem);

}
