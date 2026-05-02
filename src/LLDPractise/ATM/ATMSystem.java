package LLDPractise.ATM;

import LLDPractise.ATM.Entities.Card;
import LLDPractise.ATM.Entities.CashDispenser;
import LLDPractise.ATM.Entities.OperationType;
import LLDPractise.ATM.State.ATMState;
import LLDPractise.ATM.State.IdleState;
import LLDPractise.ATM.chainOfResponsibility.DispenseChain;
import LLDPractise.ATM.chainOfResponsibility.NoteDispenser100;
import LLDPractise.ATM.chainOfResponsibility.NoteDispenser20;
import LLDPractise.ATM.chainOfResponsibility.NoteDispenser50;

import java.util.concurrent.atomic.AtomicLong;

public class ATMSystem {
    private static ATMSystem instance = null;
    private final BankService bankService;
    private final CashDispenser cashDispenser;
    private static final AtomicLong transactionCounter = new AtomicLong(0);
    private ATMState currentState;
    private Card currentCard;

    private ATMSystem(){
        this.currentState = new IdleState();
        this.bankService = new BankService();
        DispenseChain c1 = new NoteDispenser100(100);
        DispenseChain c2 = new NoteDispenser50(20);
        DispenseChain c3 = new NoteDispenser20(30);
        c1.setNextChain(c2);
        c2.setNextChain(c3);
        this.cashDispenser = new CashDispenser(c1);
    }

    public static ATMSystem getInstance(){
        if(instance == null){
            instance = new ATMSystem();
        }
        return instance;
    }

    public void changeState(ATMState newState){
        this.currentState = newState;
    }

    public void setCurrentCard(Card card){
        this.currentCard = currentCard;
    }

    public void insertCard(String cardNumber){
        currentState.insertCard(this, cardNumber);
    }

    public void enterPin(String pin){
        currentState.enterPin(this, pin);
    }

    public void selectOperation(OperationType op, int... args){
        currentState.selectOperation(this, op, args);
    }

    public Card getCard(String cardNumber){
        return bankService.getCard(cardNumber);
    }

    public boolean authenticate(String pin){
        return bankService.authenticate(currentCard, pin);
    }

    public void checkBalance(){
        double balance = bankService.getBalance(currentCard);
        System.out.printf("Your current account balance is: $%.2f%n", balance);
    }

    public void withdrawCash(int amount){
        if(!cashDispenser.canDispenseCash(amount)){
            throw new IllegalStateException("Insufficient cash available in the ATM");
        }
        bankService.withdrawMoney(currentCard, amount);
        try{
            cashDispenser.dispenseChain(amount);
        }
        catch (Exception ex){
            bankService.depositMoney(currentCard, amount);
        }
    }

    public void depositCash(int amount){
        bankService.depositMoney(currentCard, amount);
    }

    public Card getCurrentCard(){
        return currentCard;
    }

    public BankService getBankService(){
        return bankService;
    }
}
