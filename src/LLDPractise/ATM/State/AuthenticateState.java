package LLDPractise.ATM.State;

import LLDPractise.ATM.ATMSystem;
import LLDPractise.ATM.Entities.OperationType;

public class AuthenticateState implements ATMState {
    @Override
    public void insertCard(ATMSystem atmSystem, String cardNumber) {
        System.out.println("Error: PIN has already been entered and authenticated.");
    }

    @Override
    public void enterPin(ATMSystem atmSystem, String pin) {
        System.out.println("Error: PIN has already been entered and authenticated.");
    }

    @Override
    public void selectOperation(ATMSystem atmSystem, OperationType op, int... args) {
        switch (op){
            case CHECK_BALANCE:
                atmSystem.checkBalance();
                break;
            case WITHDRAW_CASH:
                if(args.length == 0 || args[0] <= 0){
                    System.out.println("Error: Invalid withdrawal amount specified");
                    break;
                }
                int amountToWithdraw = args[0];
                double accountBalance = atmSystem.getBankService().getBalance(atmSystem.getCurrentCard());
                if(amountToWithdraw > accountBalance){
                    System.out.println("Error: Insufficient balance");
                    break;
                }
                System.out.println("Processing withdrawal of $" + amountToWithdraw);
                atmSystem.withdrawCash(amountToWithdraw);
                break;
            case DEPOSIT_CASH:
                if(args.length == 0 || args[0] <= 0){
                    System.out.println("Error: Invalid withdrawal amount specified");
                    break;
                }
                int amountToDeposit = args[0];
                System.out.println("Processing deposit for $" + amountToDeposit);
                atmSystem.depositCash(amountToDeposit);
                break;
            default:
                System.out.println("Error: Invalid operation selected");
                break;
        }
        System.out.println("Transaction complete");
        ejectCard(atmSystem);
    }

    @Override
    public void ejectCard(ATMSystem atmSystem) {
        System.out.println("Ending session. Card has been ejected. Thank you for using our ATM.");
        atmSystem.setCurrentCard(null);
        atmSystem.changeState(new IdleState());
    }
}
