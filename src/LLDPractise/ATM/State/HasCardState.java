package LLDPractise.ATM.State;

import LLDPractise.ATM.ATMSystem;
import LLDPractise.ATM.Entities.OperationType;

public class HasCardState implements ATMState{
    @Override
    public void insertCard(ATMSystem atmSystem, String cardNumber) {
        System.out.println("Error: A card is already inserted. Cannot insert another card.");
    }

    @Override
    public void enterPin(ATMSystem atmSystem, String pin) {
        System.out.println("Authenticating pin . . .");
        boolean isAuthenticated = atmSystem.authenticate(pin);
        if(isAuthenticated){
            System.out.println("Authentication Successful");
            atmSystem.changeState(new AuthenticateState());
        }
        else{
            System.out.println("Authentication failed: Incorrect PIN.");
            ejectCard(atmSystem);
        }
    }

    @Override
    public void selectOperation(ATMSystem atmSystem, OperationType op, int... args) {
        System.out.println("Error: Please enter your PIN first to select an operation.");
    }

    @Override
    public void ejectCard(ATMSystem atmSystem) {
        System.out.println("Card has been ejected. Thank you for using our ATM.");
        atmSystem.setCurrentCard(null);
        atmSystem.changeState(new IdleState());
    }
}
